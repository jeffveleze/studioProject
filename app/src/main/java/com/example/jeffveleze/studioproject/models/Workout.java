
package com.example.jeffveleze.studioproject.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Workout {

    private Integer id;
    @SerializedName("instructor_id") private Integer instructorId;
    @SerializedName("audio_id") private Integer audioId;
    private String name;
    @SerializedName("background_url") private String backgroundUrl;
    @SerializedName("publish_date") private String publishDate;
    private String duration;
    private String difficulty;
    private Object description;
    @SerializedName("is_welcome_run") private Boolean isWelcomeRun;
    @SerializedName("users_took") private Integer usersTook;
    private Instructor instructor;
    private Audio audio;
    @SerializedName("top_users") private ArrayList<TopUser> topUsers = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getAudioId() {
        return audioId;
    }

    public void setAudioId(Integer audioId) {
        this.audioId = audioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Boolean getIsWelcomeRun() {
        return isWelcomeRun;
    }

    public void setIsWelcomeRun(Boolean isWelcomeRun) {
        this.isWelcomeRun = isWelcomeRun;
    }

    public Integer getUsersTook() {
        return usersTook;
    }

    public void setUsersTook(Integer usersTook) {
        this.usersTook = usersTook;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public ArrayList<TopUser> getTopUsers() {
        return topUsers;
    }

    public void setTopUsers(ArrayList<TopUser> topUsers) {
        this.topUsers = topUsers;
    }

}
