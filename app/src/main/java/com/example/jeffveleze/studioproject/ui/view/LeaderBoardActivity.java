package com.example.jeffveleze.studioproject.ui.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jeffveleze.studioproject.R;
import com.example.jeffveleze.studioproject.models.LeaderBoardUser;
import com.example.jeffveleze.studioproject.ui.presenter.LeaderBoardPresenter;

import java.util.ArrayList;

public class LeaderBoardActivity extends BaseActivity implements LeaderBoardView {

    private LeaderBoardPresenter presenter;

    private RecyclerView leadersRecycleView;
    private RecyclerView.Adapter leadersAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<LeaderBoardUser> leaderBoardUsers;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leader_board_activity);

        presenter = new LeaderBoardPresenter(LeaderBoardActivity.this);
        createProgressDialog();
        showProgressDialog();
        presenter.getLeaderBoardList();
    }

    @Override
    public void setupLeaderBoardWith(ArrayList<LeaderBoardUser> leaderBoardUsers) {
        this.leaderBoardUsers = leaderBoardUsers;

        leadersRecycleView = (RecyclerView) findViewById(R.id.leaders_recycle_view);
        leadersRecycleView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        leadersRecycleView.setLayoutManager(layoutManager);

        leadersAdapter = new LeaderBoardAdapter(this.leaderBoardUsers, LeaderBoardActivity.this);
        leadersRecycleView.setAdapter(leadersAdapter);

        hideProgressDialog();
    }

    @Override
    public void updateLeaderBoardWith(ArrayList<LeaderBoardUser> leaderBoardUsers) {
        this.leaderBoardUsers = leaderBoardUsers;
        leadersAdapter.notifyDataSetChanged();
    }

}
