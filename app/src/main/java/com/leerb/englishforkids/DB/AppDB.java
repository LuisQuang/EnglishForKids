package com.leerb.englishforkids.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.leerb.englishforkids.DB.entity.Question;


@Database(entities = {Question.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    private static AppDB instance;
    public abstract DAO getDao();
}
