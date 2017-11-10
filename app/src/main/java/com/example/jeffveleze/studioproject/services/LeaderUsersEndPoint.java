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

import static com.example.jeffveleze.studioproject.utils.Constants.AUTHORIZATION_KEY;
import static com.example.jeffveleze.studioproject.utils.Constants.WORKOUTS_URL;
import static com.example.jeffveleze.studioproject.utils.Constants.WORKOUT_ID;
import static com.example.jeffveleze.studioproject.utils.Constants.WORKOUT_USERS_URL;

/**
 * Created by jeffveleze on 11/4/17.
 */
public interface LeaderUsersEndPoint {

    @GET(WORKOUTS_URL)
    Observable<ArrayList<Workout>> getWorkouts(@Header(AUTHORIZATION_KEY) String token);

    @GET(WORKOUT_USERS_URL)
    Observable<ArrayList<LeaderBoardItem>> getLeaderBoardItemsFor(@Path(WORKOUT_ID) int workoutId,
                                                                  @Header(AUTHORIZATION_KEY) String token);
    @GET
    Observable<ArrayList<UserLog>> getLogsFor(@Url String logsUrl);
}
