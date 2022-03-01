package com.lukavalentine.databaseapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.lukavalentine.databaseapp.DAO.AssessmentDAO;
import com.lukavalentine.databaseapp.DAO.CourseDAO;
import com.lukavalentine.databaseapp.DAO.TermDAO;
import com.lukavalentine.databaseapp.DAO.UserDAO;
import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.Entities.TermEntity;
import com.lukavalentine.databaseapp.Entities.UserEntity;

@Database(entities = {AssessmentEntity.class, CourseEntity.class, TermEntity.class, UserEntity.class}, version = 7, exportSchema = false)
public abstract class DatabaseBuilder extends RoomDatabase {
    public abstract AssessmentDAO assessmentDAO();
    public abstract CourseDAO courseDAO();
    public abstract TermDAO termDAO();
    public abstract UserDAO userDAO();

    private static volatile DatabaseBuilder INSTANCE;

    static DatabaseBuilder getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (DatabaseBuilder.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseBuilder.class, "MyDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;

    }

}
