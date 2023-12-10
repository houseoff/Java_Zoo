package ru.gb.zoo.models.db;

import ru.gb.zoo.models.animals.Animal;

import java.sql.*;
import java.util.HashMap;

public class DBQuery {

    private final DBConnection dbConnection;

    public DBQuery(DBConnection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
    };

    // Функция для получения ID записи по заданному типу из таблицы animal_groups
    private int getIdFromAnimalGroups(String groupName) throws SQLException {
        try (Statement statement = dbConnection.get().createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    String.format("select * from sp_get_id_from_animal_groups('%s')", groupName)
            );
            resultSet.next();
            return resultSet.getInt("sp_get_id_from_animal_groups");
        }
    };

    // Функция для получения ID записи по заданному типу из таблицы animal_types
    private int getIdFromAnimalTypes(String typeName) throws SQLException {
        try (Statement statement = dbConnection.get().createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    String.format("select * from sp_get_id_from_animal_types('%s')", typeName)
            );
            resultSet.next();
            return resultSet.getInt("sp_get_id_from_animal_types");
        }
    };

    // Функция получения id группы животных по виду животного
    private String getGroupByType(String type) throws SQLException {
        try (Statement statement = dbConnection.get().createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    String.format("select * from sp_get_group_by_type('%s')", type)
            );
            resultSet.next();
            return resultSet.getString("sp_get_group_by_type");
        }
    };

    // Функция для получения записи по заданному типу из таблицы animal_groups по ID
    private String getGroupFromAnimalGroups(int id) throws SQLException {
        try (Statement statement = dbConnection.get().createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    String.format("select * from sp_get_group_from_animal_groups('%d')", id)
            );
            resultSet.next();
            return resultSet.getString("sp_get_group_from_animal_groups");
        }
    };

    // Функция для получения записи по заданному типу из таблицы animal_types по ID
    private String getTypeFromAnimalTypes(int id) throws SQLException {
        try (Statement statement = dbConnection.get().createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    String.format("select * from sp_get_type_from_animal_types('%d')", id)
            );
            resultSet.next();
            return resultSet.getString("sp_get_type_from_animal_types");
        }
    };

    // Функция для получения имени таблицы по виду животного
    private String getTableNameByType(String type) throws SQLException {
        try (Statement statement = dbConnection.get().createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    String.format("select * from sp_get_table('%s')", type)
            );
            resultSet.next();
            return resultSet.getString("sp_get_table");
        }
    };

    private HashMap<String, String> newHashMap(String keys) {
        HashMap<String, String> data = new HashMap<>();
        for (String key : keys.split(",")) {
            data.put(key.toLowerCase().trim(), "");
        }
        return data;
    };

    public String getAnimalTypes() throws SQLException {
        StringBuilder sb = new StringBuilder();
        try (Statement statement = dbConnection.get().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            ResultSet resultSet = statement.executeQuery("select * from sp_get_animal_types()");
            resultSet.last();
            int countRows = resultSet.getRow();
            resultSet.beforeFirst();
            while (resultSet.next()) {
                sb.append(resultSet.getString("type_name"));
                if (countRows != resultSet.getRow()) sb.append(", ");
            }
            return sb.toString();
        }
    }

    public String getAnimalGroups() throws SQLException {
        StringBuilder sb = new StringBuilder();
        try (Statement statement = dbConnection.get().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
        ) {
            ResultSet resultSet = statement.executeQuery("select * from sp_get_animal_groups()");
            resultSet.last();
            int countRows = resultSet.getRow();
            resultSet.beforeFirst();
            while (resultSet.next()) {
                sb.append(resultSet.getString("group_name"));
                if (countRows != resultSet.getRow()) sb.append(", ");
            }
            return sb.toString();
        }
    }

    public String getAllAnimals() {
        try (Statement statement = dbConnection.get().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
        )) {
            StringBuilder sb = new StringBuilder();
            ResultSet resultSet = statement.executeQuery("select * from sp_get_all_animals()");
            resultSet.last();
            int countRows = resultSet.getRow();
            resultSet.beforeFirst();
            while (resultSet.next()) {
                sb.append("Питомец: ID ").append(resultSet.getInt("id")).append(", ");
                sb.append("Имя: ").append(resultSet.getString("name")).append(", ");
                sb.append("Тип: ").append(resultSet.getString("type_name")).append(", ");
                sb.append("Группа: ").append(resultSet.getString("group_name")).append(", ");
                sb.append("Дата рождения: ").append(resultSet.getString("birthday")).append(", ");
                sb.append("Выполняемые команды: ").append(resultSet.getString("commands"));
                sb.append("\n");
            }
            if (countRows == 0) sb.append("Не найдено ни одной записи");
            else sb.append("Количество записей: ").append(countRows);
            return sb.toString();
        } catch (SQLException e) {
            return "Ошибка при выполнении SQL-запроса: " + e.getMessage();
        }
    };

    public HashMap<String, String> getAnimal(String table, int id) throws SQLException {
        try (Statement statement = dbConnection.get().createStatement()) {
            HashMap<String, String> data = newHashMap("id, name, type_name, group_name, birthday, commands");
            ResultSet resultSet = statement.executeQuery(
                    String.format("select * from sp_get_animal('%s', %d)", table, id)
            );
            while (resultSet.next()) {
                data.put("id", String.format("%d", resultSet.getInt("id")));
                data.put("name", resultSet.getString("name"));
                data.put("type_name", resultSet.getString("type_name"));
                data.put("group_name", resultSet.getString("group_name"));
                data.put("birthday", resultSet.getString("birthday"));
                data.put("commands", resultSet.getString("commands"));
            }
            return data;
        }
    };

    public void insertAnimal(Animal animal) throws SQLException {
        String table = this.getTableNameByType(animal.getType());
        String sql = "insert into " + table + " (type_id, group_id, name, birthday, commands) values (?, ?, ?, ?, ?);";
        try (PreparedStatement statement = dbConnection.get().prepareStatement(sql)) {
            statement.setInt(1, this.getIdFromAnimalTypes(animal.getType()));
            statement.setInt(2, this.getIdFromAnimalGroups(animal.getGroup()));
            statement.setString(3, animal.getName());
            statement.setDate(4, Date.valueOf(animal.getBirthday()));
            statement.setString(5, animal.getCommands());
            statement.executeUpdate();
        }
    };

    public void updateAnimal(Animal animal, String field, String newValue) throws SQLException {
        String table = this.getTableNameByType(animal.getType());
        if (field.equals("type_name")) {
            this.dropAnimal(animal);
            animal.setType(newValue);
            animal.setGroup(this.getGroupByType(animal.getType()));
            this.insertAnimal(animal);
        } else {
            String sql = String.format("update %s set %s = '%s' where id = %d;", table, field, newValue, animal.getId());
            try (Statement statement = dbConnection.get().createStatement()) {
                statement.executeUpdate(sql);
            }
        }
    };

    public void dropAnimal(Animal animal) throws SQLException {
        String table = this.getTableNameByType(animal.getType());
        String sql = String.format("delete from %s where id = %d;", table, animal.getId());
        try (Statement statement = dbConnection.get().createStatement()) {
            statement.executeUpdate(sql);
        }
    };
}
