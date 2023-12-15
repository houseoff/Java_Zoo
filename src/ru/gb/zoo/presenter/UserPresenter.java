package ru.gb.zoo.presenter;

import ru.gb.zoo.models.animals.Animal;
import ru.gb.zoo.models.db.DBConnection;
import ru.gb.zoo.models.db.DBQuery;
import ru.gb.zoo.models.readers.YAMLReader;
import ru.gb.zoo.view.View;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class UserPresenter extends Presenter {

    public UserPresenter(View view) {
        super(view);
    }

    private void editAnimalProperties(int id, String type, String field, String newPropertyValue) {
        try {
            Animal animal = this.getAnimal(id, type);
            query.updateAnimal(animal, field, newPropertyValue);
            view().print("Информация обновлена");
        } catch (SQLException e) {
            view().print("Произошла ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    private Animal getAnimal(int id, String type) throws SQLException {
        String table = query.getTableNameByType(type);
        HashMap<String, String> data = query.getAnimal(table, id);
        return new Animal(data);
    }

    public void getConfigFromYAMLReader(String filename) {
        try {
            this.config = new YAMLReader().read(filename);
            view().print("Конфигурация из файла \"" + filename + "\" считана успешно");
            newConnection();
        } catch (IOException e) {
            view().print(e.getMessage());
        }
    }

    private void newConnection() {
        try {
            this.connection = new DBConnection(this.config);
            this.query = new DBQuery(connection);
            view().print("Подключение к базе выполнено");
        } catch (SQLException e) {
            view().print(e.getMessage());
        }
    }

    public void addAnimal(HashMap<String, String> data) {
        try {
            query.insertAnimal(new Animal(data));
            view().print("Данные успешно записаны");
        } catch (SQLException e) {
            view().print("Произошла ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    public boolean isExistsAnimal(int id, String type) {
        try {
            return query.ifExistsAnimal(id, type);
        } catch (SQLException e) {
            view().print("Произошла ошибка при выполнении запроса: " + e.getMessage());
            return false;
        }
    }

    public void getAllAnimals() {
        view().print(query.getAllAnimals());
    }

    public boolean isEmptyQuery() {
        return query == null;
    }

    public void deleteAnimal(int id, String type) {
        try {
            query.deleteAnimal(this.getAnimal(id, type));
            view().print("Запись удалена");
        } catch (SQLException e) {
            view().print("Произошла ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    public String getAllTypes() {
        try {
            return query.getAnimalTypes();
        } catch (SQLException e) {
            view().print("Произошла ошибка при выполнении запроса: " + e.getMessage());
            return null;
        }
    }

    public String getAllGroups() {
        try {
            return query.getAnimalGroups();
        } catch (SQLException e) {
            view().print("Произошла ошибка при выполнении запроса: " + e.getMessage());
            return null;
        }
    }

    public void addAnimalCommand() {
        // todo
    }

    public void deleteAnimalCommand() {
        // todo
    }

    public void editAnimalName(int id, String type, String newName) {
        this.editAnimalProperties(id, type, "name", newName);
    }

    public void editAnimalType(int id, String type, String newType) {
        this.editAnimalProperties(id, type, "type_name", newType);
    }

    public void editAnimalGroup(int id, String type, String newGroup) {
        this.editAnimalProperties(id, type, "group_name", newGroup);
    }

    public void editAnimalBirthday(int id, String type, String newBirthday) {
        this.editAnimalProperties(id, type, "birthday", newBirthday);
    }

    public void showAnimalCommands(int id, String type) {
        try {
            view().print("Выполняемые команды: " + getAnimal(id, type).getCommands());
        } catch (SQLException e) {
            view().print("Произошла ошибка при выполнении запроса: " + e.getMessage());
        }
    }
}
