package com.lukavalentine.databaseapp.Entities;

public class EventEntity {
    private String EventName;
    private String EventDate;

    public EventEntity(String eventName, String eventDate) {
        this.EventName = eventName;
        this.EventDate = eventDate;
    }



    @Override
    public String toString() {
        return "EventEntity{" +
                "EventName='" + EventName + '\'' +
                ", EventDate='" + EventDate + '\'' +
                '}';
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }
}
