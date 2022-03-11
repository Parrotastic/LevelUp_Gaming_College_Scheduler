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
import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
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
    private String dbUserName;
    EditText loginUserNameEditText;
    EditText loginPasswordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_screen);




        userName = getIntent().getStringExtra("userName".toString());
        password = getIntent().getStringExtra("userPassword".toString());
//        List<UserEntity> allUsers = repository.getAllUsers();
        loginUserNameEditText = findViewById(R.id.loginUserNameEditText);
        loginPasswordEditText = findViewById(R.id.loginPasswordEditText);

        //BELOW LINE @ 48 IS A NULL OBJECT REFERENCE...
//        Caused b
//
//        y: java.lang.NullPointerException: Attempt to invoke virtual method 'android.text.Editable android.widget.EditText.getText()' on a null object reference

        loginUserNameEditText.setText(userName);
        loginPasswordEditText.setText(password);

        Repository repository= new Repository(getApplication());










        LevelEntity Level = new LevelEntity(1, "Level 1: Tutorial", "04/03/25", "10/30/25");
        repository.insert(Level);
        Level = new LevelEntity(2, "Level 2: Beginner's Lane", "11/03/25", "05/30/26");
        repository.insert(Level);
        Level = new LevelEntity(3, "Level 3: Rhombus Road", "06/03/26", "12/30/26");
        repository.insert(Level);

        CourseEntity course = new CourseEntity(1,"UI/UX 101", "001", "....", "04/03/25", "06/03/25", "In Progress",1);
        repository.insert(course);

        AssessmentEntity assessment = new AssessmentEntity(1,"Trial Boss: Angry Tree", "06/02/25", "06/03/25", "Objective",1);
        repository.insert(assessment);

        UserEntity user = new UserEntity(1, "admin", "password");
        repository.insert(user);




//        RecyclerView recyclerView = findViewById(R.id.associated_courses);
//
//        final CourseAdapter adapter = new CourseAdapter(this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        List<CourseEntity> filteredCourses = new ArrayList<>();
//        //Use this for the password/username verification
//        //If(username = userentity.username && password = userentity.password)
//        //True: intent to next activity
//        //False: Toast message invalid username/pass
//        for (CourseEntity c : repository.getAllCourses()) {
//            if (c.getLevelID() == LevelID) filteredCourses.add(c);
//        }
//        numCourses = filteredCourses.size();
//
//        adapter.setWords(filteredCourses);
//

//
//        if(id == R.id.delete_course){
//            if(numAssessments == 0){
//                repository.delete(currentCourse);
//                Intent intent = new Intent(CourseEdit.this, LevelEdit.class);
//                intent.putExtra("LevelID", currentCourse.getLevelID());
//                startActivity(intent);
//            }
//            else{
//                Toast.makeText(getApplicationContext(), "Cannot delete course with trial(s) assigned.", Toast.LENGTH_SHORT).show();
//            }
//        }




    }

    public void LevelScreen(View view) {
        Intent intent = new Intent(MainActivity.this, LevelActivity.class);
        startActivity(intent);
    }

    public void courseScreen(View view) {
        Intent intent = new Intent(MainActivity.this, CourseActivity.class);
        startActivity(intent);
    }


    public void assessmentScreen(View view) {
        Intent intent = new Intent(MainActivity.this, AssessmentActivity.class);
        startActivity(intent);
    }

    public void verifyLogin(View view) {
        Repository repository = new Repository(getApplication());
        userName = loginUserNameEditText.getText().toString();
        password = loginPasswordEditText.getText().toString();








        if (userName == userName && password == password){
            Toast.makeText(this, "Welcome! Time to gain exp! ☕", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, LevelActivity.class);
            startActivity(intent);

        }  else{
            Toast.makeText(this, "Invalid username/password", Toast.LENGTH_SHORT).show();

        }
//        for(UserEntity u : repository.getAllUsers()){
//            String dbUserName = u.getUserName().toString();
//            String dbUserPassWord = u.getUserPassword();
//
//            if (dbUserName == userName){
//                Toast.makeText(this, "Welcome! Time to gain exp! ☕", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, LevelActivity.class);
//                startActivity(intent);
//            }



    }
}