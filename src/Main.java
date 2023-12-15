import ru.gb.zoo.view.View;
import ru.gb.zoo.view.ui.UserConsoleUI;

public class Main {
    public static void main(String[] args) {
        View view;
        view = new UserConsoleUI();
        view.start();
    }
}