package com.lukavalentine.databaseapp.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    //TODO: Hook up search to activity via button or context.
    //Leaning towards a floating action button

    private Repository repository;
    private CourseAdapter searchCourseAdapter;
    public static int numCourses;

    EditText courseSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        repository = new Repository(getApplication());
        //Not sure if below is needed
        //List<CourseEntity> allCourses = repository.getAllCourses();

        RecyclerView recyclerView = findViewById(R.id.searchRecyclerView);




    }

    public void searchForCourses(View view) {
    }

}
