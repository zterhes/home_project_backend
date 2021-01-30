package com.szegedrugby.szegedRugbyBackend.entity;

public class TrainingRegisterRequest {
    private String title;
    private String type;

    public TrainingRegisterRequest(String title, String type) {
        this.title = title;
        this.type = type;
    }

    @Override
    public String toString() {
        return "TrainingRegisterRequest{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
