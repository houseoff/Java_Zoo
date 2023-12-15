package ru.gb.zoo.view.commands;

public abstract class Command {
    protected String description;

    public String description() {
        return description;
    }

    public abstract void execute();
}
