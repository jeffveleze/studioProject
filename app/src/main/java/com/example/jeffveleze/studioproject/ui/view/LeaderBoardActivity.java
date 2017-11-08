package com.example.jeffveleze.studioproject.ui.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeffveleze.studioproject.R;
import com.example.jeffveleze.studioproject.models.LeaderBoardUser;
import com.example.jeffveleze.studioproject.ui.presenter.LeaderBoardPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LeaderBoardActivity extends BaseActivity implements LeaderBoardView {

    private LeaderBoardPresenter presenter;

    private RecyclerView leadersRecycleView;
    private RecyclerView.Adapter leadersAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<LeaderBoardUser> leaderBoardUsers;
    private TextView className, instructorName, remainingTime;
    private ImageView instructorImage;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leader_board_activity);

        setupView();
        handleProgressDialog();
        loadData();
    }

    private void setupView() {
        className = (TextView) findViewById(R.id.class_name);
        instructorName = (TextView) findViewById(R.id.instructor_name);
        remainingTime = (TextView) findViewById(R.id.remaining_time);
        instructorImage = (ImageView) findViewById(R.id.instructor_image);

        presenter = new LeaderBoardPresenter(LeaderBoardActivity.this);
    }

    private void handleProgressDialog() {
        createProgressDialog();
        showProgressDialog();
    }

    private void loadData() {
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

    @Override
    public void setupClassInformationWith(String instructorUrlImage, String className, String instructorName, String remainingTime) {
        Picasso.with(LeaderBoardActivity.this)
                .load(instructorUrlImage)
                .resize(80, 80)
                .transform(new CircleTransform())
                .centerCrop()
                .into(instructorImage);
        this.className.setText(className);
        this.instructorName.setText(instructorName);
        this.remainingTime.setText(remainingTime);
    }

    @Override
    public void updateRemainingTimeWith(String remainingTime) {

    }

}
