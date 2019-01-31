package com.wew.health.deltahacks2019;

import java.util.UUID;

public class Patient {

    private static UUID patientId;
    private String firstName;
    private String lastName;
    private String seat;
    private int age;
    private long lastTimeServed;
    private long nextTimeServed;
    private int alertType;//0 == none, 1 == moderate, 2 == serious
    private String alertMessage;

    public Patient() {
        patientId = UUID.randomUUID();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getLastTimeServed() {
        return lastTimeServed;
    }

    public void setLastTimeServed(long lastTimeServed) {
        this.lastTimeServed = lastTimeServed;
    }

    public long getNextTimeServed() {
        return nextTimeServed;
    }

    public void setNextTimeServed(long nextTimeServed) {
        this.nextTimeServed = nextTimeServed;
    }

    public int isAlertType() {
        return alertType;
    }

    public void setAlertType(int alertType) {
        this.alertType = alertType;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }
}
