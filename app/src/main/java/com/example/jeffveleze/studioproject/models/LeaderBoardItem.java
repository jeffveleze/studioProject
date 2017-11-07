
package com.example.jeffveleze.studioproject.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class LeaderBoardItem {

    private Integer id;
    @SerializedName("workout_id") private Integer workoutId;
    @SerializedName("user_id") private Integer userId;
    private String filename;
    @SerializedName("log_url_path") private String logUrlPath;
    @SerializedName("max_heart_rate") private Integer maxHeartRate;
    @SerializedName("max_speed") private Integer maxSpeed;
    @SerializedName("max_heart_rate_age") private Integer maxHeartRateAge;
    @SerializedName("heart_rate_percentage") private Integer heartRatePercentage;
    private Integer points;
    private User user;
    @SerializedName("created_at") private String createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLogUrlPath() {
        return logUrlPath;
    }

    public void setLogUrlPath(String logUrlPath) {
        this.logUrlPath = logUrlPath;
    }

    public Integer getMaxHeartRate() {
        return maxHeartRate;
    }

    public void setMaxHeartRate(Integer maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getMaxHeartRateAge() {
        return maxHeartRateAge;
    }

    public void setMaxHeartRateAge(Integer maxHeartRateAge) {
        this.maxHeartRateAge = maxHeartRateAge;
    }

    public Integer getHeartRatePercentage() {
        return heartRatePercentage;
    }

    public void setHeartRatePercentage(Integer heartRatePercentage) {
        this.heartRatePercentage = heartRatePercentage;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
