package ru.gb.zoo.models.db;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DBConfig {
    @JsonProperty
    private String type;
    @JsonProperty
    private String server;
    @JsonProperty
    private String port;
    @JsonProperty
    private String database;
    @JsonProperty
    private String user;
    @JsonProperty
    private String password;

    public String getUrl() {
        return "jdbc:" + type + "://" +
                server + ":" + port + "/" +
                database;
    };

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
