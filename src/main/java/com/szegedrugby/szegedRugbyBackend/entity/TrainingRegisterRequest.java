package com.szegedrugby.szegedRugbyBackend.entity;

public class TrainingRegisterRequest {
    private String title;
    private String type;
    private Long planId;

    public TrainingRegisterRequest(String title, String type, Long planId) {
        this.title = title;
        this.type = type;
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "TrainingRegisterRequest{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", planId=" + planId +
                '}';
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
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
