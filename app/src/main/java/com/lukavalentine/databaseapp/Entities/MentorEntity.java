package com.lukavalentine.databaseapp.Entities;

public class MentorEntity {


    private String MentorName;
    private String MentorPhone;
    private String MentorEmail;

    public MentorEntity(String mentorName, String mentorPhone, String mentorEmail) {
        MentorName = mentorName;
        MentorPhone = mentorPhone;
        MentorEmail = mentorEmail;
    }

    @Override
    public String toString() {
        return "MentorEntity{" +
                "MentorName='" + MentorName + '\'' +
                ", MentorPhone='" + MentorPhone + '\'' +
                ", MentorEmail='" + MentorEmail + '\'' +
                '}';
    }

    public String getMentorName() {
        return MentorName;
    }

    public void setMentorName(String mentorName) {
        MentorName = mentorName;
    }

    public String getMentorPhone() {
        return MentorPhone;
    }

    public void setMentorPhone(String mentorPhone) {
        MentorPhone = mentorPhone;
    }

    public String getMentorEmail() {
        return MentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        MentorEmail = mentorEmail;
    }
}
