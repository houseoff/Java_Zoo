package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class ImportDBConnection extends Command {

    private final UserConsoleUI consoleUI;

    public ImportDBConnection(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Импортировать подключение из файла";
    }

    @Override
    public void execute() {
        consoleUI.importDBConfig();
    }
}
