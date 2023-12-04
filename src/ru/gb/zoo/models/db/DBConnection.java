package ru.gb.zoo.models.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final Connection connection;

    public DBConnection(String url, String user, String pass) throws SQLException {
        connection = DriverManager.getConnection(url, user, pass);
    }

    public Connection getConnection() {
        return connection;
    }
}
