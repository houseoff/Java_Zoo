import ru.gb.zoo.models.animals.*;
import ru.gb.zoo.models.db.DBQuery;
import ru.gb.zoo.models.db.DBConnection;
import ru.gb.zoo.models.readers.YAMLReader;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        DBConnection conn = new DBConnection(new YAMLReader().read("db_config.yaml"));
        DBQuery dbAnimal = new DBQuery(conn);
        Horse horse = new Horse(dbAnimal.getAnimal("horse", 1));
        System.out.println(horse);
        dbAnimal.updateAnimal(horse, "type_name", "собака");
    }
}