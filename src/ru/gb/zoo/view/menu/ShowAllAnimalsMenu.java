package ru.gb.zoo.view.menu;

import ru.gb.zoo.view.commands.Back;
import ru.gb.zoo.view.commands.ShowAllAnimalsByBirthday;
import ru.gb.zoo.view.commands.ShowAllAnimalsByTypeName;
import ru.gb.zoo.view.ui.UserConsoleUI;

public class ShowAllAnimalsMenu extends Menu {
    public ShowAllAnimalsMenu(UserConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new ShowAllAnimalsByTypeName(consoleUI));
        commandList.add(new ShowAllAnimalsByBirthday(consoleUI));
        if (consoleUI.previousMenu() != null)
            commandList.add(new Back(consoleUI));
    }
}
