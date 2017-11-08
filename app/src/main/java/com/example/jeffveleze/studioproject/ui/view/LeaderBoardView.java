package com.example.jeffveleze.studioproject.ui.view;

import com.example.jeffveleze.studioproject.models.LeaderBoardUser;

import java.util.ArrayList;

/**
 * Created by jeffveleze on 11/4/17.
 */
public interface LeaderBoardView extends BaseView {

    void setupLeaderBoardWith(ArrayList<LeaderBoardUser> leaderBoardUsers);
    void updateLeaderBoardWith(ArrayList<LeaderBoardUser> leaderBoardUsers);

}
