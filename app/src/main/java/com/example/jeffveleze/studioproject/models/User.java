
package com.example.jeffveleze.studioproject.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class User {

    private Integer id;
    private String username;
    private String email;
    private String birthday;
    private Integer age;
    private String gender;
    private String location;
    private Integer weight;
    private Object subscription;
    @SerializedName("subscription_data") private Object subscriptionData;
    @SerializedName("why_running_with") private Object whyRunningWith;
    @SerializedName("onboarding_finished") private Boolean onboardingFinished;
    @SerializedName("avatar_url") private String avatarUrl;
    @SerializedName("fb_user_id") private Object fbUserId;
    @SerializedName("fb_data") private Object fbData;
    private Object token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Object getSubscription() {
        return subscription;
    }

    public void setSubscription(Object subscription) {
        this.subscription = subscription;
    }

    public Object getSubscriptionData() {
        return subscriptionData;
    }

    public void setSubscriptionData(Object subscriptionData) {
        this.subscriptionData = subscriptionData;
    }

    public Object getWhyRunningWith() {
        return whyRunningWith;
    }

    public void setWhyRunningWith(Object whyRunningWith) {
        this.whyRunningWith = whyRunningWith;
    }

    public Boolean getOnboardingFinished() {
        return onboardingFinished;
    }

    public void setOnboardingFinished(Boolean onboardingFinished) {
        this.onboardingFinished = onboardingFinished;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Object getFbUserId() {
        return fbUserId;
    }

    public void setFbUserId(Object fbUserId) {
        this.fbUserId = fbUserId;
    }

    public Object getFbData() {
        return fbData;
    }

    public void setFbData(Object fbData) {
        this.fbData = fbData;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

}
