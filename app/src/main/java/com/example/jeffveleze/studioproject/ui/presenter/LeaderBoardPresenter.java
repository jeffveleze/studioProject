package com.example.jeffveleze.studioproject.ui.presenter;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

import com.example.jeffveleze.studioproject.R;
import com.example.jeffveleze.studioproject.models.LeaderBoardItem;
import com.example.jeffveleze.studioproject.models.LeaderBoardUser;
import com.example.jeffveleze.studioproject.models.UserLog;
import com.example.jeffveleze.studioproject.models.Workout;
import com.example.jeffveleze.studioproject.services.LeaderBoardInteractor;
import com.example.jeffveleze.studioproject.ui.view.LeaderBoardActivity;
import com.example.jeffveleze.studioproject.ui.view.LeaderBoardView;

import java.security.acl.LastOwnerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.jeffveleze.studioproject.utils.Constants.REFRESH_TIME_IN_SECONDS;
import static com.example.jeffveleze.studioproject.utils.Constants.SECOND;
import static com.example.jeffveleze.studioproject.utils.Constants.WORKOUT_SELECTED;

/**
 * Created by jeffveleze on 11/4/17.
 */
public class LeaderBoardPresenter {

    private LeaderBoardView view;
    private LeaderBoardInteractor interactor;
    private CompositeDisposable disposables;
    private ArrayList<LeaderBoardUser> leaderBoardUsers;
    private Workout selectedWorkout;
    private Timer refreshTimer;
    private int secondsCounter = 0;
    private int workoutDurationInSeconds = 0;

    public LeaderBoardPresenter(LeaderBoardView view) {
        this.view = view;
        interactor = new LeaderBoardInteractor();
        disposables = new CompositeDisposable();
    }

    public void detachView() {
        view = null;

        if (disposables != null) {
            disposables.clear();
        }
    }

    public void getLeaderBoardList() {
        disposables.add(interactor.getWorkouts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(workouts -> {
                            selectedWorkout = workouts.get(WORKOUT_SELECTED);
                            getUsersFor(selectedWorkout.getId());
                        }, throwable -> {
                        }
                ));
    }

    public void userWasSelectedIn(int userPosition) {
        if (userPosition > 0 && userPosition < leaderBoardUsers.size())  {
            for (int userIndex = 0; userIndex < leaderBoardUsers.size() ; userIndex++) {
                leaderBoardUsers.get(userIndex).setSelected(false);
            }
            leaderBoardUsers.get(userPosition).setSelected(true);
            view.updateLeaderBoardWith(leaderBoardUsers);
        }
    }

    private void getUsersFor(int workoutId) {
        disposables.add(interactor.getLeaderBoardItemsFor(workoutId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(leaderBoardItems -> {
                            setBaseDataFor(leaderBoardItems);
                        }, throwable -> {
                        }
                ));
    }

    private void setBaseDataFor(ArrayList<LeaderBoardItem> leaderBoardItems) {
        leaderBoardUsers = new ArrayList<>();

        for (LeaderBoardItem leaderBoardItem : leaderBoardItems) {
            LeaderBoardUser user = new LeaderBoardUser();
            user.setName(leaderBoardItem.getUser().getUsername());
            user.setGender(leaderBoardItem.getUser().getGender());
            user.setLocation(leaderBoardItem.getUser().getLocation());
            user.setUrlAvatar(leaderBoardItem.getUser().getAvatarUrl());
            user.setUrlLogs(leaderBoardItem.getLogUrlPath());
            leaderBoardUsers.add(user);
        }

        loadLogs();
    }

    private void loadLogs() {
        final int[] numberOfUsersLoaded = {0};

        for (int index = 0; index < leaderBoardUsers.size(); index++) {
            String url = leaderBoardUsers.get(index).getUrlLogs();
            int userIndex = index;
            int logStartIndex = 0;
            disposables.add(interactor.getLogsFor(url)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(logs -> {
                                numberOfUsersLoaded[0]++;
                                leaderBoardUsers.get(userIndex).setLogs(logs);
                                handleLogsData(logs, userIndex, logStartIndex);
                                if (numberOfUsersLoaded[0] == leaderBoardUsers.size()) {
                                    handleLogsLoaded();
                                }
                            }, throwable -> {
                            }
                    ));
        }
    }

    private void handleLogsData(ArrayList<UserLog> logs, int userIndex, int logIndex) {
        if (logs.get(logIndex).getType().equals("HR")) {
            leaderBoardUsers.get(userIndex).setHeartRate(logs.get(logIndex).getValue());
        } else if (logs.get(logIndex).getType().equals("D")) {
            leaderBoardUsers.get(userIndex).setDistance(Float.valueOf(logs.get(logIndex).getValue()));
        }
    }

    private void handleLogsLoaded() {
        sortListLeaderBoardUsers();
        setUpView();
        formatWorkoutDuration();
        startTimer();
    }

    private void sortListLeaderBoardUsers() {
        if (leaderBoardUsers.size() > 0) {
            Collections.sort(leaderBoardUsers, (leaderBoardUser, leaderBoardUserComparate)
                    -> leaderBoardUserComparate.getDistance().compareTo(leaderBoardUser.getDistance()));
        }
    }

    private void setUpView() {
        view.setupLeaderBoardWith(leaderBoardUsers);
        view.setupClassInformationWith(selectedWorkout.getInstructor().getAvatarUrl(),
                selectedWorkout.getName(),
                selectedWorkout.getInstructor().getName(),
                selectedWorkout.getDuration());
    }

    private void formatWorkoutDuration() {
        String time = selectedWorkout.getDuration();
        String timeSplit[] = time.split(":");
        workoutDurationInSeconds = Integer.parseInt(timeSplit[0]) * 60 * 60 +
                Integer.parseInt(timeSplit[1]) * 60 +
                Integer.parseInt(timeSplit[2]);
    }

    private void startTimer() {
        secondsCounter = 0;

        new CountDownTimer(300000, SECOND) {
            public void onTick(long millisUntilFinished) {
                handleTriggeredEvent();
            }
            public void onFinish() {
                Log.d("seconds remaining: ", "done" );
            }

        }.start();
    }

    private void stopTimerTask() {
        if (refreshTimer != null) {
            refreshTimer.cancel();
            refreshTimer = null;
        }
    }

    private void handleTriggeredEvent() {
        secondsCounter ++;
        updateRemainingTimeInView();
        if (secondsCounter % REFRESH_TIME_IN_SECONDS == 0) {
            lookUpForUsersData();
        }
    }

    private void lookUpForUsersData() {
        for (int userIndex = 0; userIndex < leaderBoardUsers.size() ; userIndex++) {
            ArrayList<UserLog> userLogs = leaderBoardUsers.get(userIndex).getLogs();
            for (int logIndex = 0; logIndex < userLogs.size() ; logIndex++) {
                if (userLogs.get(logIndex).getTimeInterval() == secondsCounter) {
                    handleLogsData(userLogs, userIndex, logIndex);
                }
            }
        }

        updateLeaderBoard();
    }

    private void updateLeaderBoard() {
        sortListLeaderBoardUsers();
        view.updateLeaderBoardWith(leaderBoardUsers);
    }

    private void updateRemainingTimeInView() {
        int remainingTime = workoutDurationInSeconds - secondsCounter;
        long remainingTimeInMilliSeconds = remainingTime * 1000;
        String date = new SimpleDateFormat("mm:ss").format(new Date(remainingTimeInMilliSeconds));
        view.updateRemainingTimeWith(date);
    }

}
