package com.lukavalentine.databaseapp.UI;

import android.app.SearchManager;
import android.content.Context;
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
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
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


//

    }



    public void addTermScreen(View view){
        Intent intent = new Intent(TermActivity.this, TermAdd.class);
        startActivity(intent);

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.term_menu, menu);
//
//
//
//
//    return true;
//    }
}
