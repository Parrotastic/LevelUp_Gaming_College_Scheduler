package com.lukavalentine.databaseapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.TrialEntity;
import com.lukavalentine.databaseapp.R;

import java.util.List;

public class TrialAdd extends AppCompatActivity {
    private Repository repository;

    public static int numAlert;
    public static int numTrials;

    private int courseID;
    private int TrialID;
    private String TrialName;
    private String TrialStart;
    private String TrialEnd;
    private String TrialType;
    EditText TrialAddName;
    EditText TrialAddStart;
    EditText TrialAddEnd;
    EditText TrialAddType;

    TrialEntity currentTrial;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trial);

        repository = new Repository(getApplication());

        courseID = getIntent().getIntExtra("courseID", -1);
        TrialID = getIntent().getIntExtra("TrialID", -1);
        TrialName = getIntent().getStringExtra("TrialName".toString());
        TrialStart = getIntent().getStringExtra("TrialStart".toString());
        TrialEnd = getIntent().getStringExtra("TrialEnd".toString());
        TrialType = getIntent().getStringExtra("TrialType".toString());

        TrialAddName = findViewById(R.id.TrialAddName);
        TrialAddStart = findViewById(R.id.TrialAddStart);
        TrialAddEnd = findViewById(R.id.TrialAddEnd);
        TrialAddType = findViewById(R.id.TrialAddType);

        if(currentTrial != null){
            TrialName = currentTrial.getTrialName();
            TrialStart = currentTrial.getTrialStart();
            TrialEnd = currentTrial.getTrialEnd();
            TrialType = currentTrial.getTrialType();
            courseID = currentTrial.getCourseID();
        }

        if(TrialID != -1){
            TrialAddName.setText(TrialName);
            TrialAddStart.setText(TrialStart);
            TrialAddEnd.setText(TrialEnd);
            TrialAddType.setText(TrialType);
        }




    }

    public void saveTrial(View view) {
        TrialEntity a;

        int TrialSize;

        List<TrialEntity> allTrials = repository.getAllTrials();

        TrialSize = allTrials.size();

        if(TrialSize == 0){
            TrialID = TrialSize;
        }
        else{
            TrialID = allTrials.get(allTrials.size() - 1).getTrialID();
        }


        a = new TrialEntity(++TrialID, TrialAddName.getText().toString(),
                TrialAddStart.getText().toString(), TrialAddEnd.getText().toString(), TrialAddType.getText().toString(), courseID);

        repository.insert(a);

        Intent intent = new Intent(TrialAdd.this, CourseEdit.class);
        intent.putExtra("courseID", courseID);
        startActivity(intent);
    }
}
