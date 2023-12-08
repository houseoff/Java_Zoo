package ru.gb.zoo.models.animals.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Commands {

    List<String> commands;

    public Commands() {
        commands = new ArrayList<String>();
    };

    public Commands(String commandLine) {
        commands = new ArrayList<>();
        for (String line : commandLine.split(",")) {
            commands.add(line.trim());
        }
    };

    public List<String> get() {
        return commands;
    };

    public void add(String command) {
        commands.add(command);
    };

    public void remove(String command) {
        commands.removeAll(Collections.singleton(command));
    };

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.commands.size(); i++) {
            if (i == this.commands.size() - 1)
                sb.append(this.commands.get(i));
            else
                sb.append(this.commands.get(i)).append(", ");
        }
        return sb.toString();
    }
}
