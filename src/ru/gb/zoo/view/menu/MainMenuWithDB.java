package ru.gb.zoo.view.menu;

import ru.gb.zoo.view.commands.*;
import ru.gb.zoo.view.ui.UserConsoleUI;

public class MainMenuWithDB extends Menu {

    public MainMenuWithDB(UserConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new ShowAllAnimals(consoleUI));
        commandList.add(new AddAnimal(consoleUI));
        commandList.add(new OptionsAnimal(consoleUI));
        commandList.add(new DeleteAnimal(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

}
