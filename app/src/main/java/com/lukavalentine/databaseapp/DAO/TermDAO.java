package com.lukavalentine.databaseapp.DAO;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lukavalentine.databaseapp.Entities.TermEntity;

import java.util.List;

public interface TermDAO {
    @Insert
    void insert(TermEntity term);

    @Update
    void update(TermEntity term);

    @Delete
    void delete(TermEntity term);

    @Query("DELETE FROM term_table")
    void deleteAllTerms();

    @Query("SELECT * FROM term_table ORDER BY termID ASC")
    List<TermEntity> getAllTerms();
}
