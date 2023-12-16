package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class ShowAllAnimalsByBirthday extends Command {
    private final UserConsoleUI consoleUI;

    public ShowAllAnimalsByBirthday(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Отсортировать по дате рождения";
    }

    @Override
    public void execute() {
        consoleUI.showAllAnimalsByBirthday();
    }
}
