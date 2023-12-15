package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.ConsoleUI;

public class Back extends Command {
    private final ConsoleUI consoleUI;

    public Back(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        description = "Назад";
    }

    @Override
    public void execute() {
        consoleUI.back();
    }
}
