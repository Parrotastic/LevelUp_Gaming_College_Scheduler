package com.lukavalentine.databaseapp.UI;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.R;

import java.util.Calendar;

public class CourseDetail extends AppCompatActivity {
    private Repository repository;
    public static int numAlert;

    private int courseID;
    private String courseName;
    private String courseInstructor;
    private String courseNote;
    private String courseStart;
    private String courseEnd;

    private int assessmentID;
    private String assessmentName;
    private String assessmentStart;
    private String assessmentEnd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
    }

    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener myDate;
    Long date;

    //AddCourse Method screen here.


}
