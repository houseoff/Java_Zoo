package ru.gb.zoo.view.menu;

import ru.gb.zoo.view.commands.Command;
import ru.gb.zoo.view.ui.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Command> commandList;
    protected ConsoleUI consoleUI;

    public Menu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        commandList = new ArrayList<>();
    }

    public int countItems() { return commandList.size(); }

    public String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < countItems(); i++) {
            sb.append(i + 1).append(". ");
            sb.append(commandList.get(i).description());
            if (i < countItems() - 1) sb.append("\n");
        }
        return sb.toString();
    }

    boolean checkPreviousMenu() {
        return consoleUI.previousMenu() != null;
    }

    public void addBackItemMenu(Command back) {
        if (checkPreviousMenu()) {
            commandList.add(back);
        }
    }

    public void execute(int index) {
        commandList.get(index).execute();
    }
}

