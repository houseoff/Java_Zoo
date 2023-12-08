package ru.gb.zoo.models.animals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Horse extends Animal {
    public Horse(HashMap<String, String> properties) {
        super(properties);
    }

    public Horse(Connection connection, String query) throws SQLException {
        super(connection, query);
    }

    public Horse(Connection connection, int id) throws SQLException {
        super(connection, String.format("select * from sp_get_animal('horses', %d)", id));
    }
}
