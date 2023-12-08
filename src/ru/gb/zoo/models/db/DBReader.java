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

    public ResultSet read(String query) throws SQLException {
        try (Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
        )) {
            StringBuilder sb = new StringBuilder();
            return statement.executeQuery(query);
        }
    }
}
