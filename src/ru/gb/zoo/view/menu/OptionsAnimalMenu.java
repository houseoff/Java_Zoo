package ru.gb.zoo.view.menu;

import ru.gb.zoo.view.commands.*;
import ru.gb.zoo.view.ui.UserConsoleUI;

public class OptionsAnimalMenu extends Menu {

    public OptionsAnimalMenu(UserConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new ShowAnimalCommands(consoleUI));
        commandList.add(new EditAnimalName(consoleUI));
        commandList.add(new EditAnimalType(consoleUI));
        commandList.add(new EditAnimalGroup(consoleUI));
        commandList.add(new EditAnimalBirthday(consoleUI));
        commandList.add(new AddAnimalCommand(consoleUI));
        commandList.add(new DeleteAnimalCommand(consoleUI));
        if (consoleUI.previousMenu() != null)
            commandList.add(new Back(consoleUI));
    }

}
