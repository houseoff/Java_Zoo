package ru.gb.zoo.models.readers;

import ru.gb.zoo.models.db.DBConfig;
import java.io.IOException;

public abstract class Reader {
    private DBConfig config;
    public abstract DBConfig read(String filename) throws IOException;
}
