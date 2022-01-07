package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

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

    EditText assessmentEditName;
    EditText assessmentEditStart;
    EditText assessmentEditEnd;

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

        assessmentEditName = findViewById(R.id.assessmentEditName);
        assessmentEditStart = findViewById(R.id.assessmentEditStart);
        assessmentEditEnd = findViewById(R.id.assessmentEditEnd);

        if(currentAssessment != null){
            assessmentName = currentAssessment.getAssessmentName();
            assessmentStart = currentAssessment.getAssessmentStart();
            assessmentEnd = currentAssessment.getAssessmentEnd();

        }

        if(assessmentID != -1){
            assessmentEditName.setText(assessmentName);
            assessmentEditStart.setText(assessmentStart);
            assessmentEditEnd.setText(assessmentEnd);
        }

        repository = new Repository(getApplication());

        




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void saveUpdatedAssessment(View view) {
        AssessmentEntity a;
        if(assessmentID != -1){
            a = new AssessmentEntity(assessmentID, assessmentEditName.getText().toString(),
                    assessmentEditStart.getText().toString(), assessmentEditEnd.getText().toString(), currentAssessment.getCourseID());
        }
        else{
            List<AssessmentEntity> allAssessments = repository.getAllAssessments();
            assessmentID = allAssessments.get(allAssessments.size() - 1).getAssessmentID();
            a = new AssessmentEntity(++assessmentID,assessmentEditName.getText().toString(),
                    assessmentEditStart.getText().toString(), assessmentEditEnd.getText().toString(), currentAssessment.getCourseID() );
        }
        repository.update(a);

        Intent intent = new Intent(AssessmentEdit.this, CourseEdit.class);



    }
}
