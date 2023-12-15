package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class DeleteAnimalCommand extends Command {
    private final UserConsoleUI consoleUI;

    public DeleteAnimalCommand(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Удалить команду у животного";
    }

    @Override
    public void execute() { consoleUI.deleteAnimalCommand(); }
}
