package ru.gb.zoo.presenter;

import ru.gb.zoo.models.db.DBConfig;
import ru.gb.zoo.models.db.DBConnection;
import ru.gb.zoo.models.db.DBQuery;
import ru.gb.zoo.view.View;

import java.util.HashMap;

public abstract class Presenter {
    protected View view;
    protected DBConfig config;
    protected DBConnection connection;
    protected DBQuery query;

    public Presenter(View view) {
        this.view = view;
    }

    public View view() {
        return view;
    }

}
