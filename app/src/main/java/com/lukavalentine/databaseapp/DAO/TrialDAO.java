package com.lukavalentine.databaseapp.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.lukavalentine.databaseapp.Entities.TrialEntity;
import com.lukavalentine.databaseapp.Entities.LevelEntity;

import java.util.List;
@Dao
public interface TrialDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TrialEntity Trial);

    @Update
    void update(TrialEntity Trial);

    @Delete
    void delete(TrialEntity Trial);

    @Query("DELETE FROM trial_table")
    void deleteAllTrials();

    @Query("SELECT * FROM trial_table ORDER BY TrialID ASC")
    List<TrialEntity> getAllTrials();
}
