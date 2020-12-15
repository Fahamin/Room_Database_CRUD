package com.livetv.onlinetv.kodiapps.room_database_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.livetv.onlinetv.kodiapps.room_database_crud.adapter.UserAdapter;
import com.livetv.onlinetv.kodiapps.room_database_crud.database.UserDao;
import com.livetv.onlinetv.kodiapps.room_database_crud.database.UserDatabase;
import com.livetv.onlinetv.kodiapps.room_database_crud.model.User;

import java.util.List;

public class DataShowAct extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText fname, lname;
    UserDatabase userDatabase; // = UserDatabase.getInstance(this);
    User user;
    UserDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);

        userDatabase = UserDatabase.getInstance(this);
        dao = userDatabase.userDao();


        List<User> users = dao.getAllUsers();

      // users.clear();
        recyclerView = findViewById(R.id.rec_viewID);

        UserAdapter adapter = new UserAdapter(this, users, recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}