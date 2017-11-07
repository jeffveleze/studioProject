
package com.example.jeffveleze.studioproject.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class UserLog {

    @SerializedName("workout_session_id") private Integer workoutSessionId;
    @SerializedName("time_interval") private Integer timeInterval;
    private String type;
    @SerializedName("current_timestamp") private Long currentTimestamp;
    private String value;

    public Integer getWorkoutSessionId() {
        return workoutSessionId;
    }

    public void setWorkoutSessionId(Integer workoutSessionId) {
        this.workoutSessionId = workoutSessionId;
    }

    public Integer getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCurrentTimestamp() {
        return currentTimestamp;
    }

    public void setCurrentTimestamp(Long currentTimestamp) {
        this.currentTimestamp = currentTimestamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
