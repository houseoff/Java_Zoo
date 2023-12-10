package ru.gb.zoo.models.animals;

import java.util.HashMap;

public class Cat extends Animal {

    public Cat(String type_name, String group_name, String name, String birthday, String commands) {
        super(type_name, group_name, name, birthday, commands);
    }

    public Cat(HashMap<String, String> properties) {
        super(properties);
    }
}
