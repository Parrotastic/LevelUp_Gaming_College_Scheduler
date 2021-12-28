package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.TermEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class TermAdd extends AppCompatActivity {
    private Repository repository;

    //Probably don't need these two.
    public static int numAlert;
    public static int numTerms;

    private int termID;
    private String termName;
    private String termStart;
    private String termEnd;
    EditText termAddName;
    EditText termAddStart;
    EditText termAddEnd;
    TermEntity currentTerm;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);

        repository = new Repository(getApplication());

        termID = getIntent().getIntExtra("termID", -1);
        termName = getIntent().getStringExtra("termName".toString());
        termStart = getIntent().getStringExtra("termStart".toString());
        termEnd = getIntent().getStringExtra("termEnd".toString());

        termAddName = findViewById(R.id.termAddName);
        termAddStart = findViewById(R.id.termAddStart);
        termAddEnd = findViewById(R.id.termAddEnd);

        if(currentTerm != null){
            termName = currentTerm.getTermName();
            termStart = currentTerm.getTermStart();
            termEnd = currentTerm.getTermEnd();
        }

        if(termID != -1){
            termAddName.setText(termName);
            termAddStart.setText(termStart);
            termAddEnd.setText(termEnd);
        }
    }





    public void addTerm(View view) {
        Intent intent = new Intent(TermAdd.this, TermActivity.class);
        intent.putExtra("termID", termID);
        startActivity(intent);
    }

    public void addTermFromScreen(View view) {
        TermEntity t;


        //Not saving added term.
        t = new TermEntity(termID, termAddName.getText().toString(), termAddStart.getText().toString(), termAddEnd.getText().toString());
        List<TermEntity> allTerms = repository.getAllTerms();
        termID = allTerms.get(allTerms.size() - 1).getTermID();
        t = new TermEntity(++termID, termAddName.getText().toString(), termAddStart.getText().toString(), termAddEnd.getText().toString());
        repository.insert(t);


    }

    //
}
