package ru.gb.zoo.models.animals;

import ru.gb.zoo.models.animals.commands.Commands;

public abstract class Animal {
    protected String name;
    protected String birthDay;
    protected Commands commands;

    public String getCommands() {
        return commands.toString();
    }

    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public Boolean addCommand(String command) {
        
    }
}
