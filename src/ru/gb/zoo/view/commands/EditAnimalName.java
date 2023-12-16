package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class EditAnimalName extends Command{
    private final UserConsoleUI consoleUI;

    public EditAnimalName(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Редактировать имя животного";
    }

    @Override
    public void execute() { consoleUI.editAnimalName(); }
}
