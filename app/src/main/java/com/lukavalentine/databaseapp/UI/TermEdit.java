package com.lukavalentine.databaseapp.UI;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.Entities.TermEntity;
import com.lukavalentine.databaseapp.Entities.UserEntity;
import com.lukavalentine.databaseapp.R;

import java.util.ArrayList;
import java.util.List;

public class TermEdit extends AppCompatActivity {
    private Repository repository;
    private CourseAdapter searchCourseAdapter;
    public static int numAlert;
    public static int numCourses;

    private int termID;
    private String termName;
    private String termStart;
    private String termEnd;
    EditText editTermName;
    EditText editTermStart;
    EditText editTermEnd;
    TermEntity currentTerm;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_detail);

        termID = getIntent().getIntExtra("termID", -1);
        termName = getIntent().getStringExtra("termName".toString());
        termStart = getIntent().getStringExtra("termStart".toString());
        termEnd = getIntent().getStringExtra("termEnd".toString());

        repository = new Repository(getApplication());
        List<TermEntity> allTerms = repository.getAllTerms();

        for (TermEntity t : allTerms) {
            if (t.getTermID() == termID)
                currentTerm = t;
        }

        editTermName = findViewById(R.id.termName);
        editTermStart = findViewById(R.id.termStart);
        editTermEnd = findViewById(R.id.termEnd);

        if (currentTerm != null) {
            termName = currentTerm.getTermName();
            termStart = currentTerm.getTermStart();
            termEnd = currentTerm.getTermEnd();
        }
        if (termID != -1) {
            editTermName.setText(termName);
            editTermStart.setText(termStart);
            editTermEnd.setText(termEnd);
        }


        repository = new Repository(getApplication());
        RecyclerView recyclerView = findViewById(R.id.associated_courses);

        final CourseAdapter adapter = new CourseAdapter(this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<CourseEntity> filteredCourses = new ArrayList<>();

        for (CourseEntity c : repository.getAllCourses()) {
            if (c.getTermID() == termID) filteredCourses.add(c);
        }
        numCourses = filteredCourses.size();

        adapter.setWords(filteredCourses);
//
//




    }






    public void saveTerm(View view) {


    }

    public void addTermFromScreen(View view) {
        TermEntity t;
        if (termID != -1)
            t = new TermEntity(termID, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
        else {
            List<TermEntity> allTerms = repository.getAllTerms();
            termID = allTerms.get(allTerms.size() - 1).getTermID();
            t = new TermEntity(++termID, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
        }
        repository.update(t);

        Intent intent = new Intent(TermEdit.this, TermActivity.class);
        intent.putExtra("termID", termID);
        startActivity(intent);


    }




    public void editTermScreen(View view) {
    }

    public void addCourseToTerm(View view){
        termID = getIntent().getIntExtra("termID", -1);

        Intent intent = new Intent(TermEdit.this, CourseAdd.class);
        intent.putExtra("termID", termID);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.term_menu, menu);
        return true;

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.delete_term){
            if(numCourses == 0){
                repository.delete(currentTerm);
                Intent intent = new Intent(TermEdit.this, TermActivity.class);
                intent.putExtra("termID", termID);
                startActivity(intent);

            }
            else{
                Toast.makeText(getApplicationContext(), "Cannot delete level with course(s) assigned.", Toast.LENGTH_SHORT).show();
            }
        }
//
//        if(id == R.id.share_term){
//            Intent sendIntent = new Intent();
//            sendIntent.setAction(Intent.ACTION_SEND);
//            sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out this information!");
//
//            sendIntent.putExtra(Intent.EXTRA_TITLE, "Term Info");
//            sendIntent.setType("text/plain");
//
//            Intent shareIntent = Intent.createChooser(sendIntent, null);
//            startActivity(shareIntent);
//            return true;
//        }




        return super.onOptionsItemSelected(item);



    }


}
