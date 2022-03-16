package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
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
    String Mentor;
    String courseNote;
    String start;
    String end;
    int LevelID;

    CourseEntity currentCourse;
    public static int numCourses;



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
        Intent intent = new Intent(CourseActivity.this, CourseEdit.class);
        startActivity(intent);

    }

    public void addCourseFromScreen(View view) {
    }
}
