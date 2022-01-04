package com.lukavalentine.databaseapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lukavalentine.databaseapp.Database.DatabaseBuilder;
import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.Entities.TermEntity;
import com.lukavalentine.databaseapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Repository repository = new Repository(getApplication());



        repository.deleteAllAssessments();
        repository.deleteAllCourses();
        repository.deleteAllTerms();



        TermEntity term = new TermEntity(1, "Spring 2025", "04/03/25", "10/30/25");
        repository.insert(term);
        term = new TermEntity(2, "Winter 2025", "11/03/25", "05/30/26");
        repository.insert(term);
        term = new TermEntity(3, "Summer 2026", "06/03/26", "12/30/26");
        repository.insert(term);

        CourseEntity course = new CourseEntity(1,"Practical Algebra", "001", "....", "04/03/25", "06/03/25", 1);
        repository.insert(course);

        AssessmentEntity assessment = new AssessmentEntity(1,"PJGB Objective", "06/02/25", "06/03/25", 1);
        repository.insert(assessment);


    }

    public void termScreen(View view) {
        Intent intent = new Intent(MainActivity.this, TermActivity.class);
        startActivity(intent);
    }

    public void courseScreen(View view) {
        Intent intent = new Intent(MainActivity.this, CourseActivity.class);
        startActivity(intent);
    }


    public void assessmentScreen(View view) {
        Intent intent = new Intent(MainActivity.this, AssessmentActivity.class);
        startActivity(intent);
    }
}