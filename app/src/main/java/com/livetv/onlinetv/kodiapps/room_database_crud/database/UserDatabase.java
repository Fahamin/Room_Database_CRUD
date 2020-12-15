package com.livetv.onlinetv.kodiapps.room_database_crud.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.livetv.onlinetv.kodiapps.room_database_crud.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public static UserDatabase instance;

    public static UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    , UserDatabase.class, "userdatabase").allowMainThreadQueries().build();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }
}
