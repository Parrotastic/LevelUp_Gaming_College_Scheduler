package com.lukavalentine.databaseapp.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lukavalentine.databaseapp.Database.Repository;

import java.util.Calendar;

public class TermDetail extends AppCompatActivity {
    private Repository repository;
    public static int numAlert;

    private int courseID;
    private String courseName;
    private String courseInstructor;
    private String courseNote;
    private String courseStart;
    private String courseEnd;
    private int termID;
    Calendar myCalender = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener myDate;
    Long date;

    public void addTerm(View view) {
        //Intent intent = new Intent(TermActivity.this, TermDetail.class);

    }
}
