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
import com.lukavalentine.databaseapp.Entities.EventEntity;
import com.lukavalentine.databaseapp.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {



    Repository Repository;
    ArrayList<EventEntity> eventsArrayList;
    SearchAdapter searchAdapter;
    RecyclerView recyclerView;
    String[] eventsName;
    String[] eventsDate;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //Thinking about doing something more simplistic like listing events rather
        //than trying to pull courses...

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        //courseSearch = findViewById(R.id.searchEditText);
        Repository = new Repository(getApplication());
        //Repository.getAllCourses();
        recyclerView = findViewById(R.id.searchRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //searchCourseAdapter.setWords(Repository.getAllCourses());

        //courseArrayList = new ArrayList<CourseEntity>();
        eventsArrayList = new ArrayList<EventEntity>();


        eventsName = new String[]{
                "Tavern Talk with Julie",
                "Owning Your Growth Mentality",
                "Not Waiting For the Future",
                "Dev Ops 101",
                "Miraculous Potions and Battle Systems",
                "Not Your Fairy Godmother: Write Your Own Vivid Characters",
                "Tool Time with Jan and Bob",
                "Networking For Good and Evil",
                "Working with your Inner Introvert",
        };

        eventsDate = new String[]{
          "12/22/22",
          "01/03/23",
          "01/31/23",
          "02/22/23",
          "03/14/23",
          "03/23/23",
          "04/01/23",
          "05/02/23",
          "06/03/23"
        };


        getData();



        
        

    }

    private void getData() {

        for (int i= 0;i<eventsName.length;i++){
            EventEntity events = new EventEntity(eventsName[i], eventsDate[i]);
            eventsArrayList.add(events);

        }

        searchAdapter = new SearchAdapter(this, eventsArrayList);
        recyclerView.setAdapter(searchAdapter);
        searchAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_events);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search for events!");
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

//    public void searchForCourses(View view) {
//        repository = new Repository(getApplication());
//        //Not sure if below is needed
//        //List<CourseEntity> allCourses = repository.getAllCourses();
//
//        RecyclerView recyclerView = findViewById(R.id.searchRecyclerView);
//        final CourseAdapter adapter = new CourseAdapter(this);
//        recyclerView.setAdapter(adapter);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
////        String courseSearch1 = courseSearch.getText().toString();
////        ArrayList<String> filteredCourses = new ArrayList();
////
////        ArrayList<String> strings = new ArrayList<String>();
////        strings.add("String1");
////        strings.add("String2");
////        strings.add("String3");
////        strings.add("String4");
////        strings.add("String5");
////
////
////
////        for (int i = 0; i < 5; i++) {
////            if (strings.get(i) == courseSearch1) filteredCourses.add(strings.get(i));
////
////        }
////        numCourses = filteredCourses.size();
//
//        //adapter.setWords(filteredCourses);
//    }

}
