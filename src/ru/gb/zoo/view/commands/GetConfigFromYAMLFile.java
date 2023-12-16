package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class GetConfigFromYAMLFile extends Command {

    private final UserConsoleUI consoleUI;

    public GetConfigFromYAMLFile(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Из YAML-файла";
    }

    @Override
    public void execute() { consoleUI.getConfigFromYAMLFile(); }

}
