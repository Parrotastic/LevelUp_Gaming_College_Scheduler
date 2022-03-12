package com.lukavalentine.databaseapp.Entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "trial_table")
public class TrialEntity {

    @PrimaryKey
    private int TrialID;
    private String TrialName;
    private String TrialStart;
    private String TrialEnd;
    private String TrialType;
    private int courseID;






    @Override
    public String toString() {
        return "TrialEntity{" +
                "TrialID=" + TrialID +
                ", TrialName='" + TrialName + '\'' +
                ", TrialStart='" + TrialStart + '\'' +
                ", TrialEnd='" + TrialEnd + '\'' +
                ", TrialType='" + TrialType + '\'' +
                ", courseID=" + courseID +
                '}';
    }

    public TrialEntity(int TrialID, String TrialName, String TrialStart, String TrialEnd, String TrialType, int courseID) {
        this.TrialID = TrialID;
        this.TrialName = TrialName;
        this.TrialStart = TrialStart;
        this.TrialEnd = TrialEnd;
        this.TrialType = TrialType;
        this.courseID = courseID;
    }

    public int getTrialID() {
        return TrialID;
    }

    public void setTrialID(int TrialID) {
        this.TrialID = TrialID;
    }

    public String getTrialName() {
        return TrialName;
    }

    public void setTrialName(String TrialName) {
        this.TrialName = TrialName;
    }

    public String getTrialStart() {
        return TrialStart;
    }

    public void setTrialStart(String TrialStart) {
        this.TrialStart = TrialStart;
    }



    public String getTrialEnd() {
        return TrialEnd;
    }

    public void setTrialEnd(String TrialEnd) {
        this.TrialEnd = TrialEnd;
    }

    public String getTrialType() {
        return TrialType;
    }

    public void setTrialType(String TrialType) {
        this.TrialType = TrialType;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}



