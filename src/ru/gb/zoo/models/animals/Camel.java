package ru.gb.zoo.models.animals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Camel extends Animal {

    public Camel(HashMap<String, String> properties) {
        super(properties);
    }

    public Camel(Connection connection, String query) throws SQLException {
        super(connection, query);
    }

    public Camel(Connection connection, int id) throws SQLException {
        super(connection, String.format("select * from sp_get_animal('camels', %d)", id));
    }
}
