package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class EditAnimalGroup extends Command {
    private final UserConsoleUI consoleUI;

    public EditAnimalGroup(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Редактировать группу животного";
    }

    @Override
    public void execute() { consoleUI.editAnimalGroup(); }
}
