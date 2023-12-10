package ru.gb.zoo.models.animals;

import java.util.HashMap;

public class Hamster extends Animal {

    public Hamster(String type_name, String group_name, String name, String birthday, String commands) {
        super(type_name, group_name, name, birthday, commands);
    }

    public Hamster(HashMap<String, String> properties) {
        super(properties);
    }
}
