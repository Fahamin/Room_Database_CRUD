package com.livetv.onlinetv.kodiapps.room_database_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Delete;
import androidx.room.Update;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.livetv.onlinetv.kodiapps.room_database_crud.database.UserDao;
import com.livetv.onlinetv.kodiapps.room_database_crud.database.UserDatabase;
import com.livetv.onlinetv.kodiapps.room_database_crud.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText fname, lname;
    UserDatabase userDatabase; // = UserDatabase.getInstance(this);
    User user;
    UserDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.first_nameid);
        lname = findViewById(R.id.last_nameid);

        userDatabase = UserDatabase.getInstance(this);
        user = new User();
        dao = userDatabase.userDao();

    }


    public void updateData(View view) {
        //init the entity
        User u = new User();
        u.setId(3);
        u.setFirstName("Jane");
        u.setLastName("Doe");

        dao.update(u);
    }

    public void insertData(View view) {
        String firstname = fname.getText().toString();
        String lastname = lname.getText().toString();


        user.setFirstName(firstname);
        user.setLastName(lastname);
        dao.insert(user);
        Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();

    }

    public void deletData(View view) {
        //init the entity
        User u = new User();
        u.setId(3);
        u.setFirstName("Jane");
        u.setLastName("Doe");
        dao.delete(u);
    }

    public void showData(View view) {
        startActivity(new Intent(this, DataShowAct.class));

        //get single user by id
        //   User u = dao.getUser(3);

    }


}