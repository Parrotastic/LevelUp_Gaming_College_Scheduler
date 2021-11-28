package com.lukavalentine.databaseapp.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.R;

import java.util.Calendar;

public class TermDetail extends AppCompatActivity {
    private Repository repository;
    public static int numAlert;

    //Do we just edit the base term info here(e.g. name, start, end) or do we also edit the courses from here?
    //Both, I'm thinking.

    private int courseID;
    private String courseName;
    private String courseInstructor;
    private String courseNote;
    private String courseStart;
    private String courseEnd;

    private int termID;
    private String termName;
    private String termStart;
    private String termEnd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_detail);
    }

    Calendar myCalender = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener myDate;
    Long date;

    //AddTerm or AddTermScreen -> AddTerm = TermActivity.this, TermDetail.class, AddTermScreen = below with Receiver class.

    public void addTerm(View view) {

        Intent intent = new Intent(TermDetail.this, MyReceiver.class);


    }

    public void addTermScreen(View view) {
    }
}
