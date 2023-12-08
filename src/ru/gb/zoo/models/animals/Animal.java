package ru.gb.zoo.models.animals;

import ru.gb.zoo.models.animals.commands.Commands;

import java.sql.*;
import java.util.HashMap;

public abstract class Animal {
    protected int id;
    protected String name;
    protected String type_name;
    protected String group_name;
    protected String birthday;
    protected Commands commands;

    public Animal(HashMap<String, String> properties) {
        this.type_name = properties.get("type_name");
        this.group_name = properties.get("group_name");
        this.name = properties.get("name");
        this.birthday = properties.get("birthday");
        commands = new Commands(properties.get("commands"));
    }

    public Animal(Connection connection, String query) throws SQLException {
        try (Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
        )) {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            this.id = resultSet.getInt("id");
            this.name = resultSet.getString("name");
            this.type_name = resultSet.getString("type_name");
            this.group_name = resultSet.getString("group_name");
            this.birthday = resultSet.getString("birthday");
            commands = new Commands(resultSet.getString("commands"));
        }
    };


    public static String getAllAnimals(Connection connection) {
        try (Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
        )) {
            StringBuilder sb = new StringBuilder();
            ResultSet resultSet = statement.executeQuery("select * from sp_get_all_animals()");
            resultSet.last();
            int countRows = resultSet.getRow();
            resultSet.beforeFirst();
            while (resultSet.next()) {
                sb.append("Питомец № ").append(resultSet.getRow()).append(", ");
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

    public int getId() {
        return id;
    }

    public String getType() {
        return type_name;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCommands() {
        return commands.toString();
    }

    public void setType(String type) {
        this.type_name = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(String birthday) {
        this.birthday = birthday;
    }

    public Boolean addCommand(String command) {
		command = command.trim().toLowerCase();
        if (commands.get().contains(command))
			return false;
		else {
			commands.add(command);
			return true;
		}
    }

    public Boolean removeCommand(String command) {
        command = command.trim().toLowerCase();
        if (commands.get().contains(command)) {
            commands.remove(command);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type_name='" + type_name + '\'' +
                ", group_name='" + group_name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", commands=" + commands +
                '}';
    }
}
