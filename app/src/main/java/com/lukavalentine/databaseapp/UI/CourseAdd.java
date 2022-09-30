package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class CourseAdd extends AppCompatActivity {
    private Repository repository;

    public static int numAlert;
    public static int numCourses;

    private int LevelID;
    private int courseID;
    private String courseName;
    private String courseMentor;
    private String courseNote;
    private String courseStart;
    private String courseEnd;
    private String courseStatus;
    EditText courseAddName;
    EditText courseAddMentor;
    EditText courseAddStart;
    EditText courseAddEnd;
    EditText courseAddStatus;
    EditText courseAddNote;
    EditText courseAddLevelID;
    CourseEntity currentCourse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        repository = new Repository(getApplication());


        LevelID = getIntent().getIntExtra("LevelID", -1);
        courseID = getIntent().getIntExtra("courseID", -1);
        courseName = getIntent().getStringExtra("courseName".toString());
        courseMentor = getIntent().getStringExtra("courseMentor".toString());
        courseNote = getIntent().getStringExtra("courseNote".toString());
        courseStart = getIntent().getStringExtra("courseStart".toString());
        courseEnd = getIntent().getStringExtra("courseEnd".toString());
        courseStatus = getIntent().getStringExtra("courseStatus".toString());

        courseAddName = findViewById(R.id.courseAddName);
        courseAddMentor = findViewById(R.id.courseAddMentor);
        courseAddNote = findViewById(R.id.courseAddNote);
        courseAddStart = findViewById(R.id.courseAddStart);
        courseAddEnd = findViewById(R.id.courseAddEnd);
        courseAddStatus = findViewById(R.id.courseAddStatus);


        if(currentCourse != null){
         courseName = currentCourse.getCourseName();
         courseMentor = currentCourse.getCourseMentor();
         courseNote = currentCourse.getCourseNote();
         courseStart = currentCourse.getCourseStart();
         courseEnd = currentCourse.getCourseEnd();
         courseStatus = currentCourse.getCourseStatus();
         LevelID = currentCourse.getLevelID();
        }

        if(courseID != -1){
            courseAddName.setText(courseName);
            courseAddMentor.setText(courseMentor);
            courseAddNote.setText(courseNote);
            courseAddStart.setText(courseStart);
            courseAddEnd.setText(courseEnd);
            courseAddStatus.setText(courseStatus);

        }


    }



    public void saveCourse(View view) {
        CourseEntity c;
        int courseSize;

        List<CourseEntity> allCourses = repository.getAllCourses();

        courseSize = allCourses.size();

        if(courseSize == 0){
            courseID = courseSize;
        }else{
            courseID = allCourses.get(allCourses.size() - 1).getCourseID();
        }


        c = new CourseEntity(++courseID, courseAddName.getText().toString(), courseAddMentor.getText().toString(),
                courseAddNote.getText().toString(), courseAddStart.getText().toString(), courseAddEnd.getText().toString(), courseAddStatus.getText().toString(),LevelID);

        repository.insert(c);

        Intent intent = new Intent(CourseAdd.this, LevelEdit.class);
        intent.putExtra("LevelID", LevelID);
        startActivity(intent);
    }

}
