package ru.gb.zoo.models.animals.commands;

import java.util.ArrayList;

public class Commands extends ArrayList<String> {

    public Commands() {
        ArrayList<String> commands = new ArrayList<String>();
    };

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            if (i == this.size() - 1)
                sb.append(this.get(i));
            else
                sb.append(this.get(i)).append(",\n");
        }
        return sb.toString();
    }
}
