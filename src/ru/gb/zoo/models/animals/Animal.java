package ru.gb.zoo.models.animals;

import ru.gb.zoo.models.animals.commands.Commands;
import java.util.HashMap;
import java.util.Objects;

public class Animal {
    protected int id;
    protected String type_name;
    protected String group_name;
    protected String name;
    protected String birthday;
    protected Commands commands;

    public Animal(HashMap<String, String> properties) {
        if (properties.containsKey("id") && !Objects.equals(properties.get("id"), ""))
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

    public String getStringCommands() {
        return commands.toString();
    }

    public Commands getCommands() {
        return commands;
    }

    public void setType(String type) {
        this.type_name = type;
    }

    public void setGroup(String group) {
        this.group_name = group;
    }

    public void setCommands(Commands commands) {
        this.commands = commands;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(String birthday) {
        this.birthday = birthday;
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
