package ru.gb.zoo.view.ui;

import ru.gb.zoo.view.View;
import ru.gb.zoo.view.menu.Menu;

public abstract class ConsoleUI implements View {
    protected Input input;
    protected Menu previousMenu;
    protected Menu currentMenu;
    protected boolean work;
    protected int cachedId;
    protected String cachedType;

    public ConsoleUI() {
        work  = true;
        input = new Input();
    }

    public void back() {
        currentMenu = previousMenu;
        previousMenu = null;
    }

    protected void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Ошибка при очистке консоли: " + e.getMessage());
        }
    }

    public int getCachedId() {
        return cachedId;
    }

    public String getCachedType() {
        return cachedType;
    }

    public abstract Menu previousMenu();

}
