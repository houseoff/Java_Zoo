package ru.gb.zoo.models.animals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Cat extends Animal {

    public Cat(HashMap<String, String> properties) {
        super(properties);
    }

    public Cat(Connection connection, String query) throws SQLException {
        super(connection, query);
    }

    public Cat(Connection connection, int id) throws SQLException {
        super(connection, String.format("select * from sp_get_animal('cats', %d)", id));
    }
}
