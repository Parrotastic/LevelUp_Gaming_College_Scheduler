package com.lukavalentine.databaseapp.UI;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukavalentine.databaseapp.Database.Repository;
import com.lukavalentine.databaseapp.Entities.TrialEntity;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CourseEdit extends AppCompatActivity {
    private Repository repository;
    public static int numAlert;
    public static int numTrials;

    private int courseID;
    private String courseName;
    private String courseInstructor;
    private String courseNote;
    private String courseStart;
    private String courseEnd;
    private String courseStatus;
    EditText courseEditName;
    EditText courseEditInstructor;
    EditText courseEditNote;
    EditText courseEditStart;
    EditText courseEditEnd;
    EditText courseEditStatus;
    private int LevelID;
    CourseEntity currentCourse;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        courseID = getIntent().getIntExtra("courseID", -1);
        courseName = getIntent().getStringExtra("courseName".toString());
        courseInstructor = getIntent().getStringExtra("courseInstructor".toString());
        courseNote = getIntent().getStringExtra("courseNote".toString());
        courseStart = getIntent().getStringExtra("courseStart".toString());
        courseEnd = getIntent().getStringExtra("courseEnd".toString());
        courseStatus = getIntent().getStringExtra("courseStatus".toString());
        LevelID = getIntent().getIntExtra("LevelID", -1);

        repository = new Repository(getApplication());
        List<CourseEntity> allCourses = repository.getAllCourses();

        for (CourseEntity c : allCourses){
            if (c.getCourseID() == courseID)
                currentCourse = c;


        }

         courseEditName = findViewById(R.id.courseEditName);
         courseEditInstructor = findViewById(R.id.courseEditInstructor);
         courseEditNote = findViewById(R.id.courseEditNote);
         courseEditStart = findViewById(R.id.courseEditStart);
         courseEditEnd = findViewById(R.id.courseEditEnd);
         courseEditStatus = findViewById(R.id.courseEditStatus);

         if (currentCourse != null){
             courseName = currentCourse.getCourseName();
             courseInstructor = currentCourse.getCourseInstructor();
             courseNote = currentCourse.getCourseNote();
             courseStart = currentCourse.getCourseStart();
             courseEnd = currentCourse.getCourseEnd();
             courseStatus = currentCourse.getCourseStatus();

         }

         if(courseID != -1){
             courseEditName.setText(courseName);
             courseEditInstructor.setText(courseInstructor);
             courseEditNote.setText(courseNote);
             courseEditStart.setText(courseStart);
             courseEditEnd.setText(courseEnd);
             courseEditStatus.setText(courseStatus);
         }
         repository = new Repository(getApplication());
        RecyclerView recyclerView = findViewById(R.id.associated_Trials);
        final TrialAdapter adapter = new TrialAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<TrialEntity> filteredTrials = new ArrayList<>();
        for (TrialEntity a : repository.getAllTrials()){
            if(a.getCourseID() == courseID) filteredTrials.add(a);
        }
        numTrials = filteredTrials.size();
        adapter.setWords(filteredTrials);


    }




    public void saveUpdatedCourse(View view) {
        CourseEntity c;
        if(courseID != -1)
            c = new CourseEntity(courseID, courseEditName.getText().toString(), courseEditInstructor.getText().toString(),
                    courseEditNote.getText().toString(), courseEditStart.getText().toString(), courseEditEnd.getText().toString(), courseEditStatus.getText().toString(), currentCourse.getLevelID());
        else{
            List<CourseEntity> allCourses = repository.getAllCourses();
            courseID = allCourses.get(allCourses.size() - 1).getCourseID();
            c = new CourseEntity(++courseID, courseEditName.getText().toString(), courseEditInstructor.getText().toString(),
                    courseEditNote.getText().toString(), courseEditStart.getText().toString(), courseEditEnd.getText().toString(),  courseEditStatus.getText().toString() ,currentCourse.getLevelID());
        }
        repository.update(c);

        Intent intent = new Intent(CourseEdit.this, LevelEdit.class);
        intent.putExtra("LevelID", LevelID);
        startActivity(intent);
    }

    public void addTrialToCourse(View view) {
        courseID = getIntent().getIntExtra("courseID", -1);

        Intent intent = new Intent(CourseEdit.this, TrialAdd.class);
        intent.putExtra("courseID", courseID);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.course_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if(id == R.id.delete_course){
            if(numTrials == 0){
                repository.delete(currentCourse);
                Intent intent = new Intent(CourseEdit.this, LevelEdit.class);
                intent.putExtra("LevelID", currentCourse.getLevelID());
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Cannot delete course with trial(s) assigned.", Toast.LENGTH_SHORT).show();
            }
        }

        if(id == R.id.share_course){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, currentCourse.getCourseNote());

            sendIntent.putExtra(Intent.EXTRA_TITLE, "Course Note(s)");
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
            return true;
        }

        if(id == R.id.course_start_notif){

            Intent intent=new Intent(CourseEdit.this,MyReceiver.class);
            intent.putExtra("key","Your course begins today");
            PendingIntent sender= PendingIntent.getBroadcast(CourseEdit.this,++numAlert,intent,0);
            AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);


            String sDate = courseEditStart.getText().toString();
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

        if(id == R.id.course_end_notif){

            Intent intent=new Intent(CourseEdit.this,MyReceiver.class);
            intent.putExtra("key","Your course ends today");
            PendingIntent sender= PendingIntent.getBroadcast(CourseEdit.this,++numAlert,intent,0);
            AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);


            String sDate = courseEditEnd.getText().toString();
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
