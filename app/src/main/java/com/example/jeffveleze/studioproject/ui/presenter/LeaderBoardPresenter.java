package com.example.jeffveleze.studioproject.ui.presenter;

import com.example.jeffveleze.studioproject.models.LeaderBoardItem;
import com.example.jeffveleze.studioproject.models.LeaderBoardUser;
import com.example.jeffveleze.studioproject.models.UserLog;
import com.example.jeffveleze.studioproject.services.LeaderBoardInteractor;
import com.example.jeffveleze.studioproject.ui.view.LeaderBoardView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jeffveleze on 11/4/17.
 */
public class LeaderBoardPresenter {

    private LeaderBoardView view;
    private LeaderBoardInteractor interactor;
    private CompositeDisposable disposables;
    private ArrayList<LeaderBoardUser> leaderBoardUsers;

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
        disposables.add(interactor.getWorkouts().concatMap(workouts -> interactor.getLeaderBoardItemsFor(workouts.get(0).getId()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(leaderBoardItems -> {
                            setBaseDataFor(leaderBoardItems);
                        }, throwable -> {
                            System.out.println("");
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
        final int[] numberOfUsers = {0};

        for (int index = 0; index < leaderBoardUsers.size(); index++) {
            String url = leaderBoardUsers.get(index).getUrlLogs();
            int finalPosition = index;
            disposables.add(interactor.getLogsFor(url)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(logs -> {
                                numberOfUsers[0]++;
                                leaderBoardUsers.get(finalPosition).setLogs(logs);
                                handleLogsData(logs, finalPosition);

                                if (numberOfUsers[0] == leaderBoardUsers.size()) {
                                    sortListLeaderBoardUsers();
                                    view.setupLeaderBoardWith(leaderBoardUsers);
                                }
                            }, throwable -> {
                                System.out.println("");
                            }
                    ));
        }
    }

    private void handleLogsData(ArrayList<UserLog> logs, int position) {
        if (logs.get(0).getType().equals("HR")) {
            leaderBoardUsers.get(position).setHeartRate(logs.get(0).getValue());
        } else if (logs.get(0).getType().equals("D")) {
            leaderBoardUsers.get(position).setDistance(Float.valueOf(logs.get(0).getValue()));
        }
    }

    public void sortListLeaderBoardUsers() {

        if (leaderBoardUsers.size() > 0) {
            Collections.sort(leaderBoardUsers, (leaderBoardUser, leaderBoardUserComparate)
                    -> leaderBoardUserComparate.getDistance().compareTo(leaderBoardUser.getDistance()));
        }


        /*Timestamp stamp = new Timestamp(leaderBoardUsers.get(0).getLogs().get(0).getCurrentTimestamp());
        Date date = new Date(stamp.getTime());
        String format2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH).format(date);
        System.out.println(format2);*/
    }

}
