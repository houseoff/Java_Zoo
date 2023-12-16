package ru.gb.zoo.view.menu;

import ru.gb.zoo.view.commands.AddAnimal;
import ru.gb.zoo.view.commands.Finish;
import ru.gb.zoo.view.commands.ImportDBConnection;
import ru.gb.zoo.view.ui.UserConsoleUI;

public class MainMenuWithoutDB extends Menu {

    public MainMenuWithoutDB(UserConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new ImportDBConnection(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

}
