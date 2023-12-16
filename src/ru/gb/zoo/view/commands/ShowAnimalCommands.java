package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class ShowAnimalCommands extends Command {
    private final UserConsoleUI consoleUI;

    public ShowAnimalCommands(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Показать выполняемые животным команды";
    }

    @Override
    public void execute() { consoleUI.showAnimalCommands(); }
}
