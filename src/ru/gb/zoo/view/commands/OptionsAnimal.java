package ru.gb.zoo.view.commands;

import ru.gb.zoo.view.ui.UserConsoleUI;

public class OptionsAnimal extends Command {

    private final UserConsoleUI consoleUI;

    public OptionsAnimal(UserConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = "Просмотр/корректировка информации о животном";
    }

    @Override
    public void execute() { consoleUI.updateAnimal(); }

}
