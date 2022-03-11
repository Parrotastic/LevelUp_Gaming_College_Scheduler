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

import com.lukavalentine.databaseapp.DAO.LevelDAO;
import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.R;

public class LevelActivity extends AppCompatActivity {
    private Repository Repository;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        Repository = new Repository(getApplication());
        Repository.getAllLevels();
        RecyclerView recyclerView = findViewById(R.id.Level_recycler_view);

        final LevelAdapter adapter = new LevelAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setWords(Repository.getAllLevels());


//

    }



    public void addLevelScreen(View view){
        Intent intent = new Intent(LevelActivity.this, LevelAdd.class);
        startActivity(intent);

    }

    public void searchCourses(View view) {
        Intent intent = new Intent(LevelActivity.this, SearchActivity.class);
        startActivity(intent);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.Level_menu, menu);
//
//
//
//
//    return true;
//    }
}
