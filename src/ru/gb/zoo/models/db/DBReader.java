package ru.gb.zoo.models.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBReader {

    private final Connection connection;

    public DBReader(Connection connection) {
        this.connection = connection;
    };

    public String showPetsTable() {
        try (Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
        )) {
            StringBuilder sb = new StringBuilder();
            ResultSet resultSet = statement.executeQuery("select id, name, type, birthday, commands from pets");
            resultSet.last();
            int countRows = resultSet.getRow();
            resultSet.beforeFirst();
            while (resultSet.next()) {
                sb.append("Питомец № ").append(resultSet.getInt("id")).append(", ");
                sb.append("Имя: ").append(resultSet.getString("name")).append(", ");
                sb.append("Тип: ").append(resultSet.getString("type")).append(", ");
                sb.append("Дата рождения: ").append(resultSet.getString("birthday")).append(", ");
                sb.append("Выполняемые команды: ").append(resultSet.getString("commands"));
                if (resultSet.getRow() != countRows) sb.append("\n");
            }
            return sb.toString();
        } catch (SQLException e) {
            return "Ошибка при выполнении SQL-запроса: " + e.getMessage();
        }
    };
}
