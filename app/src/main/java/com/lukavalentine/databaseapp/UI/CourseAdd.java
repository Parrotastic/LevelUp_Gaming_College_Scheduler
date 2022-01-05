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

    private int termID;
    private int courseID;
    private String courseName;
    private String courseInstructor;
    private String courseNote;
    private String courseStart;
    private String courseEnd;
    EditText courseAddName;
    EditText courseAddInstructor;
    EditText courseAddStart;
    EditText courseAddEnd;
    EditText courseAddNote;
    EditText courseAddTermID;
    CourseEntity currentCourse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        repository = new Repository(getApplication());


        termID = getIntent().getIntExtra("termID", -1);
        courseID = getIntent().getIntExtra("courseID", -1);
        courseName = getIntent().getStringExtra("courseName".toString());
        courseInstructor = getIntent().getStringExtra("courseInstructor".toString());
        courseNote = getIntent().getStringExtra("courseNote".toString());
        courseStart = getIntent().getStringExtra("courseStart".toString());
        courseEnd = getIntent().getStringExtra("courseEnd".toString());

        courseAddName = findViewById(R.id.courseAddName);
        courseAddInstructor = findViewById(R.id.courseAddInstructor);
        courseAddNote = findViewById(R.id.courseAddNote);
        courseAddStart = findViewById(R.id.courseAddStart);
        courseAddEnd = findViewById(R.id.courseAddEnd);
        //courseAddTermID = findViewById(R.id.courseAddTermID);

        if(currentCourse != null){
         courseName = currentCourse.getCourseName();
         courseInstructor = currentCourse.getCourseInstructor();
         courseNote = currentCourse.getCourseNote();
         courseStart = currentCourse.getCourseStart();
         courseEnd = currentCourse.getCourseEnd();
         termID = currentCourse.getTermID();
        }

        if(courseID != -1){
            courseAddName.setText(courseName);
            courseAddInstructor.setText(courseInstructor);
            courseAddNote.setText(courseNote);
            courseAddStart.setText(courseStart);
            courseAddEnd.setText(courseEnd);
            //courseAddTermID.setText(termID);
        }


    }

    public void addAssessment(View view) {
    }

    public void saveCourse(View view) {
        CourseEntity c;

        List<CourseEntity> allCourses = repository.getAllCourses();
        courseID = allCourses.get(allCourses.size() - 1).getCourseID();
        c = new CourseEntity(++courseID, courseAddName.getText().toString(), courseAddInstructor.getText().toString(),
                courseAddNote.getText().toString(), courseAddStart.getText().toString(), courseAddEnd.getText().toString(), termID);

        repository.insert(c);

        Intent intent = new Intent(CourseAdd.this, TermEdit.class);
        intent.putExtra("termID", termID);
        startActivity(intent);
    }

}
