package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class EditAnimalBirthday extends Command {
    private final UserConsoleUI consoleUI;

    public EditAnimalBirthday(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Редактировать дату рождения животного";
    }

    @Override
    public void execute() { consoleUI.editAnimalBirthday(); }
}
