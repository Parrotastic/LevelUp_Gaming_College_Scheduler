package com.lukavalentine.databaseapp.UI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class AssessmentEdit extends AppCompatActivity {
    private Repository repository;
    public static int numAlert;
    public static int numAssessments;

    private int assessmentID;
    private String assessmentName;
    private String assessmentStart;
    private String assessmentEnd;

    AssessmentEntity currentAssessment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_detail);

        assessmentID = getIntent().getIntExtra("assessmentID", -1);
        assessmentName = getIntent().getStringExtra("assessmentName".toString());
        assessmentStart = getIntent().getStringExtra("assessmentStart".toString());
        assessmentEnd = getIntent().getStringExtra("assessmentEnd".toString());

        repository = new Repository(getApplication());
        List<AssessmentEntity> allAssessments = repository.getAllAssessments();

        for(AssessmentEntity a : allAssessments){
            if(a.getAssessmentID() == assessmentID)
                currentAssessment = a;

        }

        




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void saveUpdatedAssessment(View view) {
    }
}
