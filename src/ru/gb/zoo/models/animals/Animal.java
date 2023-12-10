package ru.gb.zoo.models.animals;

import ru.gb.zoo.models.animals.commands.Commands;
import java.util.HashMap;

public abstract class Animal {
    protected int id;
    protected String type_name;
    protected String group_name;
    protected String name;
    protected String birthday;
    protected Commands commands;

    public Animal(String type_name, String group_name, String name, String birthday, String commands) {
        this.type_name = type_name;
        this.group_name = group_name;
        this.name = name;
        this.birthday = birthday;
        this.commands = new Commands(commands);
    };

    public Animal(HashMap<String, String> properties) {
        this.id = Integer.parseInt(properties.get("id"));
        this.type_name = properties.get("type_name");
        this.group_name = properties.get("group_name");
        this.name = properties.get("name");
        this.birthday = properties.get("birthday");
        commands = new Commands(properties.get("commands"));
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type_name;
    }

    public String getGroup() {
        return group_name;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCommands() {
        return commands.toString();
    }

    public void setType(String type) {
        this.type_name = type;
    }

    public void setGroup(String group) {
        this.group_name = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(String birthday) {
        this.birthday = birthday;
    }

    public Boolean addCommand(String command) {
		command = command.trim().toLowerCase();
        if (commands.get().contains(command))
			return false;
		else {
			commands.add(command);
			return true;
		}
    }

    public Boolean removeCommand(String command) {
        command = command.trim().toLowerCase();
        if (commands.get().contains(command)) {
            commands.remove(command);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type_name='" + type_name + '\'' +
                ", group_name='" + group_name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", commands=" + commands +
                '}';
    }
}
