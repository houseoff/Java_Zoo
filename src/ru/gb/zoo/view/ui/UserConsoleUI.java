package ru.gb.zoo.view.ui;

import ru.gb.zoo.presenter.UserPresenter;
import ru.gb.zoo.view.menu.*;

import java.util.HashMap;

public class UserConsoleUI extends ConsoleUI {

    private final UserPresenter userPresenter;

    public UserConsoleUI() {
        super();
        this.userPresenter = new UserPresenter(this);
    }

    public void importDBConfig() {
        previousMenu = currentMenu;
        currentMenu = new ImportDBConfigMenu(this);
        showMenu(currentMenu);
        if (previousMenu() != null) back();
    }

    @Override
    public void start() {
        previousMenu = null;
        welcome();
        while (work) {
            if (userPresenter.isEmptyQuery()) {
                currentMenu = new MainMenuWithoutDB(this);
            } else currentMenu = new MainMenuWithDB(this);
            showMenu(currentMenu);
        }
    }

    public void showMenu(Menu menu) {
        print(menu.getMenu());
        Integer choice = input.getInt(
                "Ввод",
                "\\d+",
                1,
                menu.countItems(),
                "Ошибка ввода. Данный пункт меню не найден");
        menu.execute(choice - 1);
    }

    @Override
    public void print(String data) {
        print(data, false);
    }

    public void print(String data, Boolean clearConsole) {
        if (clearConsole) {
            clearConsole();
        }
        System.out.println(data);
    }

    @Override
    public void welcome() {
        print("Добро пожаловать в зоопарк!");
    }

    @Override
    public void finish() {
        print("Приятного дня!");
        work = false;
    }

    @Override
    public Menu previousMenu() {
        return previousMenu;
    }

    public void getConfigFromYAMLFile() {
        clearConsole();
        String filename = input.getString("Введите имя YAML-файла");
        userPresenter.getConfigFromYAMLReader(filename);
    }

    public void addAnimal() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", input.getString("Введите имя животного"));
        data.put("type_name", input.getString(
                String.format("Введите вид животного (доступные для ввода виды: %s)", userPresenter.getAllTypes()),
                userPresenter.getAllTypes(),
                "Пожалуйста, введите вид из вышеуказанных",
                false,
                true
        ));
        data.put("group_name", input.getString(
                String.format("Введите группу животного (доступные для ввода группы: %s)", userPresenter.getAllGroups()),
                userPresenter.getAllGroups(),
                "Пожалуйста, введите группу из вышеуказанных",
                false,
                true));
        data.put("birthday", input.getString(
                "Введите дату рождения в формате ГГГГ-ММ-ДД",
                "^\\d{4}-\\d{2}-\\d{2}$",
                "Пожалуйста, введите дату в вышеуказанном формате"));
        data.put("commands", input.getString(
                "Введите команды, которые умеет выполнять животное, через запятую"));
        userPresenter.addAnimal(data);
    }

    public void deleteAnimal() {
        cachedId = input.getInt(
                "Введите ID животного",
                "^[0-9]|[1-9](\\d+)?$",
                "Ошибка ввода. Введите положительное число");
        cachedType = input.getString(
                String.format("Введите вид животного (доступные для ввода виды: %s)", userPresenter.getAllTypes()),
                userPresenter.getAllTypes(),
                "Пожалуйста, введите вид из вышеуказанных",
                false,
                true
        );
        if (userPresenter.isExistsAnimal(cachedId, cachedType))
            userPresenter.deleteAnimal(cachedId, cachedType);
        else print("Не найдено ни одной записи о данном животном");
    }

    public void addAnimalCommand() {
        String command = input.getString("Введите команду, которую необходимо добавить");
        userPresenter.addAnimalCommand(cachedId, cachedType, command);
    }

    public void deleteAnimalCommand() {
        String command = input.getString("Введите команду, которую необходимо удалить");
        userPresenter.deleteAnimalCommand(cachedId, cachedType, command);
    }

    public void editAnimalName() {
        userPresenter.editAnimalName(cachedId, cachedType, input.getString("Введите новое имя животного"));
    }

    public void editAnimalType() {
        userPresenter.editAnimalType(cachedId, cachedType, input.getString(
                String.format("Введите вид животного (доступные для ввода виды: %s)", userPresenter.getAllTypes()),
                userPresenter.getAllTypes(),
                "Пожалуйста, введите вид из вышеуказанных",
                false,
                true
        ));
    }

    public void editAnimalGroup() {
        userPresenter.editAnimalGroup(cachedId, cachedType, input.getString(
                String.format("Введите группу животного (доступные для ввода группы: %s)", userPresenter.getAllGroups()),
                userPresenter.getAllGroups(),
                "Пожалуйста, введите группу из вышеуказанных",
                false,
                true));
    }

    public void editAnimalBirthday() {
        userPresenter.editAnimalBirthday(cachedId, cachedType, input.getString(
                "Введите новую дату рождения в формате ГГГГ-ММ-ДД",
                "^\\d{4}-\\d{2}-\\d{2}$",
                "Пожалуйста, введите дату в вышеуказанном формате",
                false));
    }

    public void updateAnimal() {
        previousMenu = currentMenu;
        currentMenu = new OptionsAnimalMenu(this);
        cachedId = input.getInt(
                "Введите ID животного",
                "^[0-9]|[1-9](\\d+)?$",
                "Ошибка ввода. Введите положительное число");
        cachedType = input.getString(
                String.format("Введите вид животного (доступные для ввода типы: %s)", userPresenter.getAllTypes()),
                userPresenter.getAllTypes(),
                "Пожалуйста, введите тип из вышеуказанных",
                false,
                true
        );
        if (userPresenter.isExistsAnimal(cachedId, cachedType)) showMenu(currentMenu);
        else print("Не найдено ни одной записи о данном животном");
    }

    public void showAllAnimals() {
        previousMenu = currentMenu;
        currentMenu = new ShowAllAnimalsMenu(this);
        showMenu(currentMenu);
    }

    public void showAllAnimalsByBirthday() {
        userPresenter.showAllAnimalsByBirthday();
    }

    public void showAllAnimalsByTypeName() {
        userPresenter.showAllAnimalsByTypeName();
    }

    public void showAnimalCommands() {
        userPresenter.showAnimalCommands(cachedId, cachedType);
    }

}
