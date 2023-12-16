package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class ShowAllAnimalsByTypeName extends Command {

    private final UserConsoleUI consoleUI;

    public ShowAllAnimalsByTypeName(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Отсортировать по виду животного";
    }

    @Override
    public void execute() {
        consoleUI.showAllAnimalsByTypeName();
    }
}
