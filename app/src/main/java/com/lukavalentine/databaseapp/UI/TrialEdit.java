package com.lukavalentine.databaseapp.UI;

import android.app.AlarmManager;
import android.app.PendingIntent;
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

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.TrialEntity;
import com.lukavalentine.databaseapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TrialEdit extends AppCompatActivity {
    private Repository repository;
    public static int numAlert;
    public static int numTrials;

    private int TrialID;
    private String TrialName;
    private String TrialStart;
    private String TrialEnd;
    private String TrialType;
    private int courseID;

    EditText TrialEditName;
    EditText TrialEditStart;
    EditText TrialEditEnd;
    EditText TrialEditType;


    TrialEntity currentTrial;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial_detail);

        TrialID = getIntent().getIntExtra("TrialID", -1);
        TrialName = getIntent().getStringExtra("TrialName".toString());
        TrialStart = getIntent().getStringExtra("TrialStart".toString());
        TrialEnd = getIntent().getStringExtra("TrialEnd".toString());
        TrialType = getIntent().getStringExtra("TrialType".toString());
        courseID = getIntent().getIntExtra("courseID", -1);

        repository = new Repository(getApplication());
        List<TrialEntity> allTrials = repository.getAllTrials();

        for(TrialEntity a : allTrials){
            if(a.getTrialID() == TrialID)
                currentTrial = a;

        }

        TrialEditName = findViewById(R.id.TrialEditName);
        TrialEditStart = findViewById(R.id.TrialEditStart);
        TrialEditEnd = findViewById(R.id.TrialEditEnd);
        TrialEditType = findViewById(R.id.TrialEditType);

        if(currentTrial != null){
            TrialName = currentTrial.getTrialName();
            TrialStart = currentTrial.getTrialStart();
            TrialEnd = currentTrial.getTrialEnd();
            TrialType = currentTrial.getTrialType();

        }

        if(TrialID != -1){
            TrialEditName.setText(TrialName);
            TrialEditStart.setText(TrialStart);
            TrialEditEnd.setText(TrialEnd);
            TrialEditType.setText(TrialType);
        }

        repository = new Repository(getApplication());

        




    }



    public void saveUpdatedTrial(View view) {
        TrialEntity a;
        if(TrialID != -1){
            a = new TrialEntity(TrialID, TrialEditName.getText().toString(),
                    TrialEditStart.getText().toString(), TrialEditEnd.getText().toString(), TrialEditType.getText().toString(),currentTrial.getCourseID());
        }
        else{
            List<TrialEntity> allTrials = repository.getAllTrials();
            TrialID = allTrials.get(allTrials.size() - 1).getTrialID();
            a = new TrialEntity(++TrialID,TrialEditName.getText().toString(),
                    TrialEditStart.getText().toString(), TrialEditEnd.getText().toString(), TrialEditType.getText().toString(), currentTrial.getCourseID() );
        }
        repository.update(a);

        Intent intent = new Intent(TrialEdit.this, CourseEdit.class);
        intent.putExtra("courseID", courseID);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.trial_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if(id == R.id.delete_Trial){

            repository.delete(currentTrial);
            Intent intent = new Intent(TrialEdit.this, CourseEdit.class);
            intent.putExtra("courseID", courseID);
            startActivity(intent);
        }

        if(id == R.id.Trial_start_notif){
            Intent intent=new Intent(TrialEdit.this,MyReceiver.class);
            intent.putExtra("key","Get ready! Your trial begins today!");
            PendingIntent sender= PendingIntent.getBroadcast(TrialEdit.this,++numAlert,intent,0);
            AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);


            String sDate = TrialEditStart.getText().toString();
            String myFormat = "MM/DD/YY";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            Date myDate = null;

            try {
                myDate = sdf.parse(sDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Long trigger = myDate.getTime();


            //date=myCalendar.getTimeInMillis();
            alarmManager.set(AlarmManager.RTC_WAKEUP, trigger, sender);
            return true;




        }

        if(id == R.id.Trial_end_notif){
            Intent intent=new Intent(TrialEdit.this,MyReceiver.class);
            intent.putExtra("key","Your trial ends today");
            PendingIntent sender= PendingIntent.getBroadcast(TrialEdit.this,++numAlert,intent,0);
            AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);


            String sDate = TrialEditEnd.getText().toString();
            String myFormat = "MM/DD/YY";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            Date myDate = null;

            try {
                myDate = sdf.parse(sDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Long trigger = myDate.getTime();


            //date=myCalendar.getTimeInMillis();
            alarmManager.set(AlarmManager.RTC_WAKEUP, trigger, sender);
            return true;


        }



        return super.onOptionsItemSelected(item);
    }
}
