package com.example.jeffveleze.studioproject.utils;

import retrofit2.http.GET;

/**
 * Created by jeffveleze on 11/4/17.
 */
public interface Constants {

    // Networking
    String LEADERS_BASE_URL = "https://dev.studioapi.club";
    String WORKOUTS_URL = "/workouts/dashboard";
    String WORKOUT_USERS_URL = "/workouts/{workoutId}/leaderboard";
    String ACCESS_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImludGVydmlld196cGlqdXFhX2RlbW9AdGZibncubmV0IiwiZXhwIjoxNTE0Njg3MDk5LCJmYl91c2VyX2lkIjoiMTE5MDgwMjI4ODU4NDk4IiwidXNlcl9pZCI6MjA4fQ.w0tlU1BWlRQ01M1htRNFOcmVnnEgkNd5Ue6foLUDcmY";
    String AUTHORIZATION_KEY = "Authorization";
    String WORKOUT_ID = "workoutId";

    // Others
    Integer WORKOUT_SELECTED = 0;
    Integer REFRESH_TIME_IN_SECONDS = 5;
    Integer SECOND = 1000;
    String HR_KEY = "HR";
    String DISTANCE_KEY = "D";
    String CIRCLE_KEY = "Circle";

}
