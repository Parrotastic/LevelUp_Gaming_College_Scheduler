package com.lukavalentine.databaseapp.DAO;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lukavalentine.databaseapp.Entities.AssessmentEntity;
import com.lukavalentine.databaseapp.Entities.CourseEntity;

import java.util.List;

public interface CourseDAO {
    @Insert
    void insert(CourseEntity course);

    @Update
    void update(CourseEntity course);

    @Delete
    void delete(CourseEntity course);

    @Query("DELETE FROM course_table")
    void deleteAllCourses();

    @Query("SELECT * FROM course_table ORDER BY courseID ASC")
    List<CourseEntity> getAllCourses();
}
