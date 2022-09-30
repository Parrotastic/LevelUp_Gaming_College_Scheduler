package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.LevelEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class LevelAdd extends AppCompatActivity {
    private Repository repository;


    public static int numAlert;
    public static int numLevels;



    private int LevelID;
    private String LevelName;
    private String LevelStart;
    private String LevelEnd;
    EditText LevelAddName;
    EditText LevelAddStart;
    EditText LevelAddEnd;
    LevelEntity currentLevel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_level);

        repository = new Repository(getApplication());



        LevelID = getIntent().getIntExtra("LevelID", -1);
        LevelName = getIntent().getStringExtra("LevelName".toString());
        LevelStart = getIntent().getStringExtra("LevelStart".toString());
        LevelEnd = getIntent().getStringExtra("LevelEnd".toString());

        LevelAddName = findViewById(R.id.LevelAddName);
        LevelAddStart = findViewById(R.id.LevelAddStart);
        LevelAddEnd = findViewById(R.id.LevelAddEnd);

        if(currentLevel != null){
            LevelName = currentLevel.getLevelName();
            LevelStart = currentLevel.getLevelStart();
            LevelEnd = currentLevel.getLevelEnd();
        }

        if(LevelID != -1){
            LevelAddName.setText(LevelName);
            LevelAddStart.setText(LevelStart);
            LevelAddEnd.setText(LevelEnd);
        }
    }







    public void addLevelFromScreen(View view) {
        LevelEntity t;

        int LevelSize;




        List<LevelEntity> allLevels = repository.getAllLevels();

        LevelSize = allLevels.size();

        if(LevelSize == 0){
            LevelID = LevelSize;
        } else{
            LevelID = allLevels.get(allLevels.size() -1).getLevelID();
        }

        t = new LevelEntity(++LevelID, LevelAddName.getText().toString(), LevelAddStart.getText().toString(), LevelAddEnd.getText().toString());
        repository.insert(t);

        Intent intent = new Intent(LevelAdd.this, LevelActivity.class);
        intent.putExtra("LevelID", LevelID);
        startActivity(intent);


    }


}
