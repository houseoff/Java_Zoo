package ru.gb.zoo.view.menu;

import ru.gb.zoo.view.commands.Back;
import ru.gb.zoo.view.commands.GetConfigFromYAMLFile;
import ru.gb.zoo.view.ui.UserConsoleUI;

public class ImportDBConfigMenu extends Menu {
    public ImportDBConfigMenu(UserConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetConfigFromYAMLFile(consoleUI));
        addBackItemMenu(new Back(consoleUI));
    }
}
