package ru.gb.zoo.models.animals;

import ru.gb.zoo.models.animals.commands.Commands;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Animal {
    int id;
    protected String type;
    protected String name;
    protected String birthDay;
    protected Commands commands;

    public Animal(String type, String name, String birthDay) {
        this.type = type;
        this.name = name;
        this.birthDay = birthDay;
        commands = new Commands();
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getCommands() {
        return commands.toString();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Boolean addCommand(String command) {
		command = command.trim().toLowerCase();
        if (commands.contains(command))
			return false;
		else {
			commands.add(command);
			return true;
		}
    }

    public Boolean removeCommand(String command) {
        command = command.trim().toLowerCase();
        if (commands.contains(command)) {
            commands.removeAll(Collections.singleton(command));
            return true;
        }
        return false;
    }
}
