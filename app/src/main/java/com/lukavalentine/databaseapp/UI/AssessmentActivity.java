package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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

        final AssessmentAdapter adapter = new AssessmentAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setWords(repository.getAllAssessments());

    }

    public void addAssessment(View view){
        Intent intent = new Intent(AssessmentActivity.this, AssessmentDetail.class);
        startActivity(intent);
    }

    public void addAssessmentFromScreen(View view){

    }
}
