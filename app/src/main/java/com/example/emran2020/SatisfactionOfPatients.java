package com.example.emran2020;

public class SatisfactionOfPatients {

    public String id;
    public String satisfaction;
    public int value;

    public SatisfactionOfPatients() {
    }

    public SatisfactionOfPatients(String id, String satisfaction, int value) {
        this.id = id;
        this.satisfaction = satisfaction;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}



