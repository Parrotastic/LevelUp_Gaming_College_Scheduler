package com.lukavalentine.databaseapp.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course_table")
public class CourseEntity {
    @PrimaryKey
    private int courseID;
    private String courseName;
    private String courseInstructor;
    private String courseNote;
    private String courseStart;
    private String courseEnd;
    private String courseStatus;
    private int termID;



    @Override
    public String toString() {
        return "CourseEntity{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", courseInstructor='" + courseInstructor + '\'' +
                ", courseNote='" + courseNote + '\'' +
                ", courseStart='" + courseStart + '\'' +
                ", courseEnd='" + courseEnd + '\'' +
                ", courseEnd='" + courseStatus + '\'' +
                ", termID=" + termID +
                '}';
    }

    public CourseEntity(int courseID, String courseName, String courseInstructor, String courseNote, String courseStart, String courseEnd, String courseStatus, int termID) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;
        this.courseNote = courseNote;
        this.courseStart = courseStart;
        this.courseEnd = courseEnd;
        this.courseStatus = courseStatus;
        this.termID = termID;
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

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
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

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }
}
