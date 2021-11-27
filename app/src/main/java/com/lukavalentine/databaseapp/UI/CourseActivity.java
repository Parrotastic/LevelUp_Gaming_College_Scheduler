package com.lukavalentine.databaseapp.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.R;

public class CourseActivity extends AppCompatActivity {
    private Repository repository;

    int ID;
    String name;
    String instructor;
    String courseNote;
    String start;
    String end;
    int termID;

    CourseEntity currentCourse;
    public static int numCourses;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.id.);
    }
}
