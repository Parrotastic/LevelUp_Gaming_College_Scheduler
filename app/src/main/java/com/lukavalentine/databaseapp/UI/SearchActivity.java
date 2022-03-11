package com.lukavalentine.databaseapp.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {



    private Repository repository;
    private CourseAdapter searchCourseAdapter;
    public static int numCourses;

    EditText courseSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        courseSearch = findViewById(R.id.searchEditText);


//




    }

    public void searchForCourses(View view) {
        repository = new Repository(getApplication());
        //Not sure if below is needed
        //List<CourseEntity> allCourses = repository.getAllCourses();

        RecyclerView recyclerView = findViewById(R.id.searchRecyclerView);
        final CourseAdapter adapter = new CourseAdapter(this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        String courseSearch1 = courseSearch.getText().toString();
//        ArrayList<String> filteredCourses = new ArrayList();
//
//        ArrayList<String> strings = new ArrayList<String>();
//        strings.add("String1");
//        strings.add("String2");
//        strings.add("String3");
//        strings.add("String4");
//        strings.add("String5");
//
//
//
//        for (int i = 0; i < 5; i++) {
//            if (strings.get(i) == courseSearch1) filteredCourses.add(strings.get(i));
//
//        }
//        numCourses = filteredCourses.size();

        //adapter.setWords(filteredCourses);
    }

}
