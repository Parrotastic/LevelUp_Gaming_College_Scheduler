package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.R;

public class TermActivity extends AppCompatActivity {
    private Repository Repository;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);
        Repository = new Repository(getApplication());
        Repository.getAllTerms();
        RecyclerView recyclerView = findViewById(R.id.term_recycler_view);

        final TermAdapter adapter = new TermAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setWords(Repository.getAllTerms());
    }

    public void addTerm(View view){
        Intent intent = new Intent(TermActivity.this, TermDetail.class);

    }
}
