package com.lukavalentine.databaseapp.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "level_table")
public class LevelEntity {
    @PrimaryKey
    private int LevelID;
    private String LevelName;
    private String LevelStart;
    private String LevelEnd;

    @Override
    public String toString() {
        return "LevelEntity{" +
                "LevelID=" + LevelID +
                ", LevelName='" + LevelName + '\'' +
                ", LevelStart='" + LevelStart + '\'' +
                ", LevelEnd='" + LevelEnd + '\'' +
                '}';
    }

    public LevelEntity(int LevelID, String LevelName, String LevelStart, String LevelEnd) {
        this.LevelID = LevelID;
        this.LevelName = LevelName;
        this.LevelStart = LevelStart;
        this.LevelEnd = LevelEnd;
    }

    public int getLevelID() {
        return LevelID;
    }

    public void setLevelID(int LevelID) {
        this.LevelID = LevelID;
    }

    public String getLevelName() {
        return LevelName;
    }

    public void setLevelName(String LevelName) {
        this.LevelName = LevelName;
    }

    public String getLevelStart() {
        return LevelStart;
    }

    public void setLevelStart(String LevelStart) {
        this.LevelStart = LevelStart;
    }

    public String getLevelEnd() {
        return LevelEnd;
    }

    public void setLevelEnd(String LevelEnd) {
        this.LevelEnd = LevelEnd;
    }
}
