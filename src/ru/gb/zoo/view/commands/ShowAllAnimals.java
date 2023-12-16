package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class ShowAllAnimals extends Command {
    private final UserConsoleUI consoleUI;

    public ShowAllAnimals(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Посмотреть всех животных";
    }

    @Override
    public void execute() {
        consoleUI.showAllAnimals();
    }
}
