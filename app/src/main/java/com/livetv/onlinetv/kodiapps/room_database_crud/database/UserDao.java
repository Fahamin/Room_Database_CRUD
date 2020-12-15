package com.livetv.onlinetv.kodiapps.room_database_crud.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.livetv.onlinetv.kodiapps.room_database_crud.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    public Long insert(User user);

    @Query("SELECT * FROM 'User' ORDER BY 'id' DESC")
    public List<User> getAllUsers();

    @Query("SELECT * FROM 'User' WHERE 'id' = :id")
    public User getUser(int id);

    @Update
    public void update(User user);

    @Delete
    public void delete(User user);
}

