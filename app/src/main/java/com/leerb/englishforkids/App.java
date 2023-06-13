package com.leerb.englishforkids;

import android.app.Application;

import androidx.room.Room;

import com.leerb.englishforkids.DB.AppDB;

public class App extends Application {
    private static final String DATABASE_NAME = "question.db";
    private static App instance;
    private Storage storage;
    private AppDB db;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        storage = new Storage();
        initDB();
    }

    private void initDB() {
        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, DATABASE_NAME).createFromAsset("db/Question").fallbackToDestructiveMigration().build();
    }

    public Storage getStorage() {
        return storage;
    }

    public AppDB getDb() {
        return db;
    }

    public static App getInstance() {
        return instance;
    }

}
