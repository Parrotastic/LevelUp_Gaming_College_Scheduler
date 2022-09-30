package com.lukavalentine.databaseapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lukavalentine.databaseapp.Database.DatabaseBuilder;
import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.TrialEntity;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.Entities.LevelEntity;
import com.lukavalentine.databaseapp.Entities.UserEntity;
import com.lukavalentine.databaseapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Repository repository;
    private String userName;
    private String password;
    EditText loginUserNameEditText;
    EditText loginPasswordEditText;
    UserEntity currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_screen);
        Repository repository = new Repository(getApplication());


        LevelEntity Level = new LevelEntity(1, "Level 1: Tutorial", "04/03/25", "10/30/25");
        repository.insert(Level);
        Level = new LevelEntity(2, "Level 2: Beginner's Lane", "11/03/25", "05/30/26");
        repository.insert(Level);
        Level = new LevelEntity(3, "Level 3: Rhombus Road", "06/03/26", "12/30/26");
        repository.insert(Level);

        CourseEntity course = new CourseEntity(1, "UI/UX 101", "001", "....", "04/03/25", "06/03/25", "In Progress", 1);
        repository.insert(course);

        TrialEntity Trial = new TrialEntity(1, "Trial Boss: Angry Tree", "06/02/25", "06/03/25", "Objective", 1);
        repository.insert(Trial);

        UserEntity user = new UserEntity(1, "admin", "password");
        repository.insert(user);

        List<UserEntity> allUsers = repository.getAllUsers();
        userName = getIntent().getStringExtra("userName".toString());
        password = getIntent().getStringExtra("userPassword".toString());

        loginUserNameEditText = findViewById(R.id.loginUserNameEditText);
        loginPasswordEditText = findViewById(R.id.loginPasswordEditText);

        loginUserNameEditText.setText(userName);

        loginPasswordEditText.setText(password);





    }

    public void LevelScreen(View view) {
        Intent intent = new Intent(MainActivity.this, LevelActivity.class);
        startActivity(intent);
    }

    public void courseScreen(View view) {
        Intent intent = new Intent(MainActivity.this, CourseActivity.class);
        startActivity(intent);
    }


    public void TrialScreen(View view) {
        Intent intent = new Intent(MainActivity.this, TrialActivity.class);
        startActivity(intent);
    }

    public void verifyLogin(View view) {


        repository = new Repository(getApplication());
        userName = loginUserNameEditText.getText().toString();
        password = loginPasswordEditText.getText().toString();


        for (UserEntity u : repository.getAllUsers()) {
            String dbUserName = u.getUserName();

            String dbUserPassword = u.getUserPassword();

            if (dbUserName.contentEquals(userName) && dbUserPassword.contentEquals(password)) {
                Toast.makeText(this, "Welcome! Time to gain exp! ☕", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, LevelActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid username/password", Toast.LENGTH_SHORT).show();

            }


        }
    }
}