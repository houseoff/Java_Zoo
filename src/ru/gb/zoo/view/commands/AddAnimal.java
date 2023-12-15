package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class AddAnimal extends Command {

    private final UserConsoleUI consoleUI;

    public AddAnimal(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Добавить новое животное";
    }

    @Override
    public void execute() { consoleUI.addAnimal(); }
}
