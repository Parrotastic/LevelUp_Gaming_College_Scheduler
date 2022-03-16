package com.lukavalentine.databaseapp.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course_table")
public class CourseEntity {
    @PrimaryKey
    private int courseID;
    private String courseName;
    private String courseMentor;
    private String courseNote;
    private String courseStart;
    private String courseEnd;
    private String courseStatus;
    private int LevelID;



    @Override
    public String toString() {
        return "CourseEntity{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", courseMentor='" + courseMentor + '\'' +
                ", courseNote='" + courseNote + '\'' +
                ", courseStart='" + courseStart + '\'' +
                ", courseEnd='" + courseEnd + '\'' +
                ", courseEnd='" + courseStatus + '\'' +
                ", LevelID=" + LevelID +
                '}';
    }

    public CourseEntity(int courseID, String courseName, String courseMentor, String courseNote, String courseStart, String courseEnd, String courseStatus, int LevelID) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseMentor = courseMentor;
        this.courseNote = courseNote;
        this.courseStart = courseStart;
        this.courseEnd = courseEnd;
        this.courseStatus = courseStatus;
        this.LevelID = LevelID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseMentor() {
        return courseMentor;
    }

    public void setCourseMentor(String courseMentor) {
        this.courseMentor = courseMentor;
    }

    public String getCourseNote() {
        return courseNote;
    }

    public void setCourseNote(String courseNote) {
        this.courseNote = courseNote;
    }

    public String getCourseStart() {
        return courseStart;
    }

    public void setCourseStart(String courseStart) {
        this.courseStart = courseStart;
    }

    public String getCourseEnd() {
        return courseEnd;
    }

    public void setCourseEnd(String courseEnd) {
        this.courseEnd = courseEnd;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public int getLevelID() {
        return LevelID;
    }

    public void setLevelID(int LevelID) {
        this.LevelID = LevelID;
    }
}
