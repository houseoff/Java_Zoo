package ru.gb.zoo.models.animals;

import java.util.HashMap;

public class Horse extends Animal {

    public Horse(String type_name, String group_name, String name, String birthday, String commands) {
        super(type_name, group_name, name, birthday, commands);
    }

    public Horse(HashMap<String, String> properties) {
        super(properties);
    }
}
