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
import com.lukavalentine.databaseapp.Entities.LevelEntity;
import com.lukavalentine.databaseapp.Entities.UserEntity;
import com.lukavalentine.databaseapp.R;

import java.util.ArrayList;
import java.util.List;

public class LevelEdit extends AppCompatActivity {
    private Repository repository;
    private CourseAdapter searchCourseAdapter;
    public static int numAlert;
    public static int numCourses;

    private int LevelID;
    private String LevelName;
    private String LevelStart;
    private String LevelEnd;
    EditText editLevelName;
    EditText editLevelStart;
    EditText editLevelEnd;
    LevelEntity currentLevel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_detail);

        LevelID = getIntent().getIntExtra("LevelID", -1);
        LevelName = getIntent().getStringExtra("LevelName".toString());
        LevelStart = getIntent().getStringExtra("LevelStart".toString());
        LevelEnd = getIntent().getStringExtra("LevelEnd".toString());

        repository = new Repository(getApplication());
        List<LevelEntity> allLevels = repository.getAllLevels();

        for (LevelEntity t : allLevels) {
            if (t.getLevelID() == LevelID)
                currentLevel = t;
        }

        editLevelName = findViewById(R.id.LevelName);
        editLevelStart = findViewById(R.id.LevelStart);
        editLevelEnd = findViewById(R.id.LevelEnd);

        if (currentLevel != null) {
            LevelName = currentLevel.getLevelName();
            LevelStart = currentLevel.getLevelStart();
            LevelEnd = currentLevel.getLevelEnd();
        }
        if (LevelID != -1) {
            editLevelName.setText(LevelName);
            editLevelStart.setText(LevelStart);
            editLevelEnd.setText(LevelEnd);
        }


        repository = new Repository(getApplication());
        RecyclerView recyclerView = findViewById(R.id.associated_courses);

        final CourseAdapter adapter = new CourseAdapter(this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<CourseEntity> filteredCourses = new ArrayList<>();

        for (CourseEntity c : repository.getAllCourses()) {
            if (c.getLevelID() == LevelID) filteredCourses.add(c);
        }
        numCourses = filteredCourses.size();

        adapter.setWords(filteredCourses);
//
//




    }






    public void saveLevel(View view) {


    }

    public void addLevelFromScreen(View view) {
        LevelEntity t;
        if (LevelID != -1)
            t = new LevelEntity(LevelID, editLevelName.getText().toString(), editLevelStart.getText().toString(), editLevelEnd.getText().toString());
        else {
            List<LevelEntity> allLevels = repository.getAllLevels();
            LevelID = allLevels.get(allLevels.size() - 1).getLevelID();
            t = new LevelEntity(++LevelID, editLevelName.getText().toString(), editLevelStart.getText().toString(), editLevelEnd.getText().toString());
        }
        repository.update(t);

        Intent intent = new Intent(LevelEdit.this, LevelActivity.class);
        intent.putExtra("LevelID", LevelID);
        startActivity(intent);


    }




    public void editLevelScreen(View view) {
    }

    public void addCourseToLevel(View view){
        LevelID = getIntent().getIntExtra("LevelID", -1);

        Intent intent = new Intent(LevelEdit.this, CourseAdd.class);
        intent.putExtra("LevelID", LevelID);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.level_menu, menu);
        return true;

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.delete_Level){
            if(numCourses == 0){
                repository.delete(currentLevel);
                Intent intent = new Intent(LevelEdit.this, LevelActivity.class);
                intent.putExtra("LevelID", LevelID);
                startActivity(intent);

            }
            else{
                Toast.makeText(getApplicationContext(), "Cannot delete level with course(s) assigned.", Toast.LENGTH_SHORT).show();
            }
        }
//
//        if(id == R.id.share_Level){
//            Intent sendIntent = new Intent();
//            sendIntent.setAction(Intent.ACTION_SEND);
//            sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out this information!");
//
//            sendIntent.putExtra(Intent.EXTRA_TITLE, "Level Info");
//            sendIntent.setType("text/plain");
//
//            Intent shareIntent = Intent.createChooser(sendIntent, null);
//            startActivity(shareIntent);
//            return true;
//        }




        return super.onOptionsItemSelected(item);



    }


}
