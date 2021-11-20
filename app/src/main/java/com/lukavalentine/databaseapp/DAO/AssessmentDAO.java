package com.lukavalentine.databaseapp.DAO;


import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
import com.lukavalentine.databaseapp.Entities.TermEntity;

import java.util.List;

public interface AssessmentDAO {
    @Insert
    void insert(AssessmentEntity assessment);

    @Update
    void update(AssessmentEntity assessment);

    @Delete
    void delete(AssessmentEntity assessment);

    @Query("DELETE FROM assessment_table")
    void deleteAllAssessments();

    @Query("SELECT * FROM assessment_table ORDER BY assessmentID ASC")
    List<AssessmentEntity> getAllAssessments();
}
