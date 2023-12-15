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
        String filename = input.getString(
                "Введите имя YAML-файла",
                ".*",
                "Ошибка ввода");
        userPresenter.getConfigFromYAMLReader(filename);
    }

    public void addAnimal() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", input.getString(
                "Введите имя животного",
                ".*",
                "Пожалуйста, введите имя животного"));
        data.put("type_name", input.getString(
                String.format("Введите вид животного (доступные для ввода типы: %s)", userPresenter.getAllTypes())));
        data.put("group_name", input.getString(
                String.format("Введите группу животного (доступные для ввода типы: %s)",
                        userPresenter.getAllGroups())));
        data.put("birthday", input.getString(
                "Введите дату рождения в формате ГГГГ-ММ-ДД",
                "^\\d{4}-\\d{2}-\\d{2}$",
                "Пожалуйста, введите дату в вышеуказанном формате"));
        data.put("commands", input.getString(
                "Введите команды, которые умеет выполнять животное, через запятую",
                ".*",
                "Пожалуйста, введите команды"));
        userPresenter.addAnimal(data);
    }

    public void getAllAnimals() {
        userPresenter.getAllAnimals();
    }

    public void deleteAnimal() {
        cachedId = input.getInt(
                "Введите ID животного",
                "^[0-9]|[1-9](\\d+)?$",
                "Ошибка ввода. Введите положительное число");
        cachedType = input.getString(
                String.format("Введите вид животного (доступные для ввода типы: %s)", userPresenter.getAllTypes()));
        if (userPresenter.isExistsAnimal(cachedId, cachedType)) userPresenter.deleteAnimal(cachedId, cachedType);
        else print("Не найдено ни одной записи о данном животном");
    }

    public void addAnimalCommand() {
        userPresenter.addAnimalCommand();
    }

    public void deleteAnimalCommand() {
        userPresenter.deleteAnimalCommand();
    }

    public void editAnimalName() {
        userPresenter.editAnimalName(cachedId, cachedType, input.getString("Введите новое имя животного"));
    }

    public void editAnimalType() {
        userPresenter.editAnimalType(cachedId, cachedType, input.getString(
                String.format("Введите вид животного (доступные для ввода типы: %s)", userPresenter.getAllTypes())));
    }

    public void editAnimalGroup() {
        userPresenter.editAnimalGroup(cachedId, cachedType, input.getString(
                String.format("Введите группу животного (доступные для ввода типы: %s)",
                        userPresenter.getAllGroups())));
    }

    public void editAnimalBirthday() {
        userPresenter.editAnimalBirthday(cachedId, cachedType, input.getString(
                "Введите новую дату рождения в формате ГГГГ-ММ-ДД",
                "^\\d{4}-\\d{2}-\\d{2}$",
                "Пожалуйста, введите дату в вышеуказанном формате"));
    }

    public void updateAnimal() {
        previousMenu = currentMenu;
        currentMenu = new OptionsAnimalMenu(this);
        cachedId = input.getInt(
                "Введите ID животного",
                "^[0-9]|[1-9](\\d+)?$",
                "Ошибка ввода. Введите положительное число");
        cachedType = input.getString(
                String.format("Введите вид животного (доступные для ввода типы: %s)", userPresenter.getAllTypes()));
        if (userPresenter.isExistsAnimal(cachedId, cachedType)) showMenu(currentMenu);
        else print("Не найдено ни одной записи о данном животном");
        back();
    }

    public void showAnimalCommands() {
        userPresenter.showAnimalCommands(cachedId, cachedType);
    }
}
