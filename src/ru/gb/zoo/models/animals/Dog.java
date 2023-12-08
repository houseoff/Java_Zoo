package ru.gb.zoo.models.animals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Dog extends Animal {

    public Dog(HashMap<String, String> properties) {
        super(properties);
    }

    public Dog(Connection connection, String query) throws SQLException {
        super(connection, query);
    }

    public Dog(Connection connection, int id) throws SQLException {
        super(connection, String.format("select * from sp_get_animal('dogs', %d)", id));
    }
}
