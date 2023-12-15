package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class AddAnimalCommand extends Command {
    private final UserConsoleUI consoleUI;

    public AddAnimalCommand(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Добавить команду животному";
    }

    @Override
    public void execute() { consoleUI.addAnimalCommand(); }
}
