package ru.gb.zoo.models.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ru.gb.zoo.models.db.DBConfig;
import java.io.File;
import java.io.IOException;

public class YAMLReader extends Reader {

    @Override
    public DBConfig read(String filename) throws IOException {
        File yaml = new File(filename);
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(yaml, DBConfig.class);
    }
}
