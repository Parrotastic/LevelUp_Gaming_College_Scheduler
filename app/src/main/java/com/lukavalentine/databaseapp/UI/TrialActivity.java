package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.TrialEntity;
import com.lukavalentine.databaseapp.R;

public class TrialActivity extends AppCompatActivity {
    private Repository repository;

    TrialEntity currentTrial;
    public static int numTrials;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);
        repository = new Repository(getApplication());
        repository.getAllTrials();
        RecyclerView recyclerView = findViewById(R.id.Trial_recycler_view);

        final TrialAdapter adapter = new TrialAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setWords(repository.getAllTrials());

    }

    public void addTrial(View view){
        Intent intent = new Intent(TrialActivity.this, TrialEdit.class);
        startActivity(intent);
    }

    public void addTrialFromScreen(View view){

    }
}
