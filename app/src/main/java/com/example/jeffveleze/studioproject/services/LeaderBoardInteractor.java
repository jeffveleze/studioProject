package com.example.jeffveleze.studioproject.services;


import com.example.jeffveleze.studioproject.models.LeaderBoardItem;
import com.example.jeffveleze.studioproject.models.UserLog;
import com.example.jeffveleze.studioproject.models.Workout;

import java.util.ArrayList;

import io.reactivex.Observable;

import static com.example.jeffveleze.studioproject.utils.Constants.ACCESS_TOKEN;

/**
 * Created by jeffveleze on 11/4/17.
 */

public class LeaderBoardInteractor {

    private LeaderUsersService leaderUsersService;

    public LeaderBoardInteractor() {
        this.leaderUsersService = new LeaderUsersService();

    }

    public Observable<ArrayList<Workout>> getWorkouts() {
        return leaderUsersService.getRetrofitEndPoint().getWorkouts(ACCESS_TOKEN);
    }

    public Observable<ArrayList<LeaderBoardItem>> getLeaderBoardItemsFor(int workoutSessionId) {
        return leaderUsersService.getRetrofitEndPoint().getLeaderBoardItemsFor(workoutSessionId, ACCESS_TOKEN);
    }

    public Observable<ArrayList<UserLog>> getLogsFor(String logsUrl) {
        return leaderUsersService.getRetrofitEndPoint().getLogsFor(logsUrl);
    }

}
