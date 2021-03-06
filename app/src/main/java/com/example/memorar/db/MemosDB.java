package com.example.memorar.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.memorar.model.Memo;

@Database(entities = Memo.class, version = 1)
public abstract class MemosDB extends RoomDatabase {
    private static final String DATABASE_NAME = "memosDb";

    public abstract MemosDao memosDao();

    private static MemosDB instance;

    public static MemosDB getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, MemosDB.class, DATABASE_NAME).allowMainThreadQueries().build();
        return instance;

    }
}
