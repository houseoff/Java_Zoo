import ru.gb.zoo.models.animals.*;
import ru.gb.zoo.models.db.DBConnection;
import ru.gb.zoo.models.readers.YAMLReader;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        DBConnection conn = new DBConnection(new YAMLReader().read("db_config.yaml"));
        Horse horse = new Horse(conn.getConnection(), 2);
        System.out.println(horse);
    }
}