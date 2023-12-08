package ru.gb.zoo.models.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWriter {

    private final Connection connection;

    public DBWriter (Connection connection) {
        this.connection = connection;
    };

    public String write(String query) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            return "Запрос успешно выполнен";
        } catch (SQLException e) {
            return "Ошибка при выполнении SQL-запроса: " + e.getMessage();
        }
    }
}
