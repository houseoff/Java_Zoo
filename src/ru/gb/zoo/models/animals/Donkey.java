package ru.gb.zoo.models.animals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Donkey extends Animal {

    public Donkey(HashMap<String, String> properties) {
        super(properties);
    }

    public Donkey(Connection connection, String query) throws SQLException {
        super(connection, query);
    }

    public Donkey(Connection connection, int id) throws SQLException {
        super(connection, String.format("select * from sp_get_animal('donkeys', %d)", id));
    }
}
