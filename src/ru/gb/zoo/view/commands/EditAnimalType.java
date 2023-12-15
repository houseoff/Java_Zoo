package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class EditAnimalType extends Command {
    private final UserConsoleUI consoleUI;

    public EditAnimalType(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Редактировать тип животного";
    }

    @Override
    public void execute() { consoleUI.editAnimalType(); }
}
