package com.lukavalentine.databaseapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.lukavalentine.databaseapp.DAO.TrialDAO;
import com.lukavalentine.databaseapp.DAO.CourseDAO;
import com.lukavalentine.databaseapp.DAO.LevelDAO;
import com.lukavalentine.databaseapp.DAO.UserDAO;
import com.lukavalentine.databaseapp.Entities.TrialEntity;
import com.lukavalentine.databaseapp.Entities.CourseEntity;
import com.lukavalentine.databaseapp.Entities.LevelEntity;
import com.lukavalentine.databaseapp.Entities.UserEntity;

@Database(entities = {TrialEntity.class, CourseEntity.class, LevelEntity.class, UserEntity.class}, version = 10, exportSchema = false)
public abstract class DatabaseBuilder extends RoomDatabase {
    public abstract TrialDAO TrialDAO();
    public abstract CourseDAO courseDAO();
    public abstract LevelDAO LevelDAO();
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
