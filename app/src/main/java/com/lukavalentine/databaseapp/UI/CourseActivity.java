package com.lukavalentine.databaseapp.UI;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.R;

public class CourseActivity extends AppCompatActivity {
    private Repository repository;

    int Id;
    String name;
    String instructor;
    String courseNote;
    String start;
    String end;
    int termID;

    CourseEntity currentCourse;
    public static int numCourses;


    //Should I be doing this with the PartActivity thing or the ProductActivity thing in mind?
    //Think I should keep in mind that it's probably going to more like the ProductActivity setup.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        repository = new Repository(getApplication());
        repository.getAllCourses();
        RecyclerView recyclerView = findViewById(R.id.course_recycler_view);

        final CourseAdapter adapter = new CourseAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setWords(repository.getAllCourses());




        

    }

    public void addCourse(View view) {

    }

    public void addCourseFromScreen(View view) {
    }
}
