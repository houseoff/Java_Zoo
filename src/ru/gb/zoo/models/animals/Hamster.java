package ru.gb.zoo.models.animals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Hamster extends Animal {

    public Hamster(HashMap<String, String> properties) {
        super(properties);
    }

    public Hamster(Connection connection, String query) throws SQLException {
        super(connection, query);
    }

    public Hamster(Connection connection, int id) throws SQLException {
        super(connection, String.format("select * from sp_get_animal('hamsters', %d)", id));
    }
}
