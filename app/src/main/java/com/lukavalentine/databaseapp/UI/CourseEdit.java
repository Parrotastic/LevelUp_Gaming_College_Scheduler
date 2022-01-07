package com.lukavalentine.databaseapp.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CourseEdit extends AppCompatActivity {
    private Repository repository;
    public static int numAlert;
    public static int numCourses;

    private int courseID;
    private String courseName;
    private String courseInstructor;
    private String courseNote;
    private String courseStart;
    private String courseEnd;
    EditText courseEditName;
    EditText courseEditInstructor;
    EditText courseEditNote;
    EditText courseEditStart;
    EditText courseEditEnd;

//    private int assessmentID;
//    private String assessmentName;
//    private String assessmentStart;
//    private String assessmentEnd;

    CourseEntity currentCourse;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        courseID = getIntent().getIntExtra("courseID", -1);
        courseName = getIntent().getStringExtra("courseName".toString());
        courseInstructor = getIntent().getStringExtra("courseInstructor".toString());
        courseNote = getIntent().getStringExtra("courseNote".toString());
        courseStart = getIntent().getStringExtra("courseStart".toString());
        courseEnd = getIntent().getStringExtra("courseEnd".toString());

        repository = new Repository(getApplication());
        List<CourseEntity> allCourses = repository.getAllCourses();

        for (CourseEntity c : allCourses){
            if (c.getCourseID() == courseID)
                currentCourse = c;


        }

         courseEditName = findViewById(R.id.courseEditName);
         courseEditInstructor = findViewById(R.id.courseEditInstructor);
         courseEditNote = findViewById(R.id.courseEditNote);
         courseEditStart = findViewById(R.id.courseEditStart);
         courseEditEnd = findViewById(R.id.courseEditEnd);

         if (currentCourse != null){
             courseName = currentCourse.getCourseName();
             courseInstructor = currentCourse.getCourseInstructor();
             courseNote = currentCourse.getCourseNote();
             courseStart = currentCourse.getCourseStart();
             courseEnd = currentCourse.getCourseEnd();

         }

         if(courseID != -1){
             courseEditName.setText(courseName);
             courseEditInstructor.setText(courseInstructor);
             courseEditNote.setText(courseNote);
             courseEditStart.setText(courseStart);
             courseEditEnd.setText(courseEnd);
         }

         repository = new Repository(getApplication());
        RecyclerView recyclerView = findViewById(R.id.associated_assessments);
        final AssessmentAdapter adapter = new AssessmentAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<AssessmentEntity> filteredAssessments = new ArrayList<>();
        for (AssessmentEntity a : repository.getAllAssessments()){
            if(a.getCourseID() == courseID) filteredAssessments.add(a);
        }
        numCourses = filteredAssessments.size();
        adapter.setWords(filteredAssessments);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    //    Calendar myCalendar = Calendar.getInstance();
//    DatePickerDialog.OnDateSetListener myDate;
//    Long date;

    public void saveUpdatedCourse(View view) {
        CourseEntity c;
        if(courseID != -1)
            c = new CourseEntity(courseID, courseEditName.getText().toString(), courseEditInstructor.getText().toString(),
                    courseEditNote.getText().toString(), courseEditStart.getText().toString(), courseEditEnd.getText().toString(), currentCourse.getTermID());
        else{
            List<CourseEntity> allCourses = repository.getAllCourses();
            courseID = allCourses.get(allCourses.size() - 1).getCourseID();
            c = new CourseEntity(++courseID, courseEditName.getText().toString(), courseEditInstructor.getText().toString(),
                    courseEditNote.getText().toString(), courseEditStart.getText().toString(), courseEditEnd.getText().toString(), currentCourse.getTermID());
        }
        repository.update(c);

        Intent intent = new Intent(CourseEdit.this, TermEdit.class);
    }

    public void addAssessmentToCourse(View view) {
        courseID = getIntent().getIntExtra("courseID", -1);

        Intent intent = new Intent(CourseEdit.this, AssessmentAdd.class);
        intent.putExtra("courseID", courseID);
        startActivity(intent);
    }




}
