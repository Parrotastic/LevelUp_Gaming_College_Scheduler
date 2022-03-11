package com.lukavalentine.databaseapp.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.lukavalentine.databaseapp.Entities.LevelEntity;

import java.util.List;
@Dao
public interface LevelDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LevelEntity Level);

    @Update
    void update(LevelEntity Level);

    @Delete
    void delete(LevelEntity Level);

    @Query("DELETE FROM Level_table")
    void deleteAllLevels();

    @Query("SELECT * FROM Level_table ORDER BY LevelID ASC")
    List<LevelEntity> getAllLevels();
}
