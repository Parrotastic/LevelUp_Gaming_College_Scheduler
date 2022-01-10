package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.DAO.TermDAO;
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


//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT){
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                int position = viewHolder.getAdapterPosition();
//                //adapter.d
//
//
//            }
//        };

    }



    public void addTermScreen(View view){
        Intent intent = new Intent(TermActivity.this, TermAdd.class);
        startActivity(intent);

    }

    //Use PartActivity Line 89~115 for deletes via menus and exception control for e.g.(term with course, or course with assessment.)



}
