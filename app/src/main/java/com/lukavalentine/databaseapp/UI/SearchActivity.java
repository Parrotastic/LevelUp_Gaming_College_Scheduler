package com.lukavalentine.databaseapp.UI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.Entities.MentorEntity;
import com.lukavalentine.databaseapp.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {


    Repository Repository;
    ArrayList<MentorEntity> MentorsArrayList;
    SearchAdapter searchAdapter;
    RecyclerView recyclerView;
    String[] MentorName;
    String[] MentorPhone;
    String[] MentorEmail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Repository = new Repository(getApplication());

        recyclerView = findViewById(R.id.searchRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        MentorsArrayList = new ArrayList<MentorEntity>();


        MentorName = new String[]{
                "Julie T.",
                "Julian M.",
                "Mark P.",
                "Anita Z.",
                "Luka V.",
                "Marcus W.",
                "Lola Z.",
                "Marsha K.",
                "Lucian P.",
        };

        MentorPhone = new String[]{
                "111-111-1111",
                "222-222-2222",
                "333-333-3333",
                "444-444-4444",
                "555-555-5555",
                "666-666-6666",
                "777-777-7777",
                "888-888-8888",
                "999-999-9999"
        };

        MentorEmail = new String[]{
                "juliet@avgc.com",
                "julianm@avgc.com",
                "markp@avgc.com",
                "anitaz@avgc.com",
                "lukav@avgc.com",
                "marcusw@avgc.com",
                "lolaz@avgc.com",
                "marshak@avgc.com",
                "lucianp@avgc.com"

        };


        getData();


    }

    private void getData() {

        for (int i = 0; i < MentorName.length; i++) {
            MentorEntity Mentors = new MentorEntity(MentorName[i], MentorPhone[i], MentorEmail[i]);
            MentorsArrayList.add(Mentors);

        }

        searchAdapter = new SearchAdapter(this, MentorsArrayList);
        recyclerView.setAdapter(searchAdapter);
        searchAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_Mentors);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search for Mentors!");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }


}
