package com.example.jeffveleze.studioproject.services;

import com.example.jeffveleze.studioproject.models.Workout;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by jeffveleze on 11/6/17.
 */

public interface UserLogsEndPoint {

    @GET
    Observable<ArrayList<Workout>> getLogsFor(@Url String logsUrl);

}
