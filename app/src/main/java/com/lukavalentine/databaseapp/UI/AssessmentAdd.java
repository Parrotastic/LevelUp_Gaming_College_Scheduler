package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class AssessmentAdd extends AppCompatActivity {
    private Repository repository;

    public static int numAlert;
    public static int numAssessments;

    private int courseID;
    private int assessmentID;
    private String assessmentName;
    private String assessmentStart;
    private String assessmentEnd;
    EditText assessmentAddName;
    EditText assessmentAddStart;
    EditText assessmentAddEnd;

    AssessmentEntity currentAssessment;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assessment);

        repository = new Repository(getApplication());

        courseID = getIntent().getIntExtra("courseID", -1);
        assessmentID = getIntent().getIntExtra("assessmentID", -1);
        assessmentName = getIntent().getStringExtra("assessmentName".toString());
        assessmentStart = getIntent().getStringExtra("assessmentStart".toString());
        assessmentEnd = getIntent().getStringExtra("assessmentEnd".toString());

        assessmentAddName = findViewById(R.id.assessmentAddName);
        assessmentAddStart = findViewById(R.id.assessmentAddStart);
        assessmentAddEnd = findViewById(R.id.assessmentAddEnd);

        if(currentAssessment != null){
            assessmentName = currentAssessment.getAssessmentName();
            assessmentStart = currentAssessment.getAssessmentStart();
            assessmentEnd = currentAssessment.getAssessmentEnd();
            courseID = currentAssessment.getCourseID();
        }

        if(assessmentID != -1){
            assessmentAddName.setText(assessmentName);
            assessmentAddStart.setText(assessmentStart);
            assessmentAddEnd.setText(assessmentEnd);
        }




    }

    public void saveAssessment(View view) {
        AssessmentEntity a;

        List<AssessmentEntity> allAssessments = repository.getAllAssessments();
        assessmentID = allAssessments.get(allAssessments.size() - 1).getAssessmentID();
        a = new AssessmentEntity(++assessmentID, assessmentAddName.getText().toString(),
                assessmentAddStart.getText().toString(), assessmentAddEnd.getText().toString(), courseID);

        repository.insert(a);

        Intent intent = new Intent(AssessmentAdd.this, CourseEdit.class);
        intent.putExtra("courseID", courseID);
        startActivity(intent);
    }
}
