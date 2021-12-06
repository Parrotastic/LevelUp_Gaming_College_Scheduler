package com.lukavalentine.databaseapp.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
import com.lukavalentine.databaseapp.R;

public class AssessmentActivity extends AppCompatActivity {
    private Repository repository;

    AssessmentEntity currentAssessment;
    public static int numAssessments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);
        repository = new Repository(getApplication());
        repository.getAllAssessments();
        RecyclerView recyclerView = findViewById(R.id.assessment_recycler_view);

        //Work on Assessment Adapter first.
        //final AssessmentAdapter adapter = new AssessmentAdapter(this);
    }
}
