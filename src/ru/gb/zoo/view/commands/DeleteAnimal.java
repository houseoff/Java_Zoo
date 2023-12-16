package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class DeleteAnimal extends Command {
    private final UserConsoleUI consoleUI;

    public DeleteAnimal(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Удалить животное";
    }

    @Override
    public void execute() { consoleUI.deleteAnimal(); }
}
