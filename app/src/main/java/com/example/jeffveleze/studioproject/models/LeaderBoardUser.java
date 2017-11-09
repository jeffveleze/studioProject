package com.example.jeffveleze.studioproject.models;

import android.graphics.Color;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by jeffveleze on 11/4/17.
 */
public class LeaderBoardUser {

    private String name;
    private String gender;
    private String location;
    private ImageView avatarImage;
    private String urlAvatar;
    private String urlLogs;
    private String heartRate;
    private Float distance = 0.0f;
    private ArrayList<UserLog> logs;
    private Boolean isSelected = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ImageView getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(ImageView avatarImage) {
        this.avatarImage = avatarImage;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getUrlLogs() {
        return urlLogs;
    }

    public void setUrlLogs(String urlLogs) {
        this.urlLogs = urlLogs;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public ArrayList<UserLog> getLogs() {
        return logs;
    }

    public void setLogs(ArrayList<UserLog> logs) {
        this.logs = logs;
    }

    public Boolean getSelected() { return isSelected; }

    public void setSelected(Boolean selected) { isSelected = selected; }

}
