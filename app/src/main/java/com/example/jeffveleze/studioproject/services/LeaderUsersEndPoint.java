package com.example.jeffveleze.studioproject.services;

import com.example.jeffveleze.studioproject.models.LeaderBoardItem;
import com.example.jeffveleze.studioproject.models.UserLog;
import com.example.jeffveleze.studioproject.models.Workout;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by jeffveleze on 11/4/17.
 */
public interface LeaderUsersEndPoint {

    @GET("/workouts/dashboard")
    Observable<ArrayList<Workout>> getWorkouts(@Header("Authorization") String token);

    @GET("/workouts/{workoutId}/leaderboard")
    Observable<ArrayList<LeaderBoardItem>> getLeaderBoardItemsFor(@Path("workoutId") int workoutId,
                                                                  @Header("Authorization") String token);
    @GET
    Observable<ArrayList<UserLog>> getLogsFor(@Url String logsUrl);
}
