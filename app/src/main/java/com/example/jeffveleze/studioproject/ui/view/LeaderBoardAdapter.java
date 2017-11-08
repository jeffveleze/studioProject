package com.example.jeffveleze.studioproject.ui.view;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeffveleze.studioproject.R;
import com.example.jeffveleze.studioproject.models.LeaderBoardUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jeffveleze on 11/5/17.
 */
public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.ViewHolder> {
    private ArrayList<LeaderBoardUser> dataSource;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView ranking;
        private ImageView avatarImage;
        private TextView nameTextView;
        private TextView genderAndLocationTextView;
        private TextView distanceTextView;
        private TextView distanceUnitsTextView;
        private TextView heartRateTextView;
        private TextView heartRateUnitsTextView;

        private ViewHolder(View itemView) {
            super(itemView);

            ranking = (TextView) itemView.findViewById(R.id.ranking);
            avatarImage = (ImageView) itemView.findViewById(R.id.avatar_image);
            nameTextView = (TextView) itemView.findViewById(R.id.name);
            genderAndLocationTextView = (TextView) itemView.findViewById(R.id.gender_and_location);
            distanceTextView = (TextView) itemView.findViewById(R.id.distance);
            distanceUnitsTextView = (TextView) itemView.findViewById(R.id.distance_units);
            heartRateTextView = (TextView) itemView.findViewById(R.id.heart_rate);
            heartRateUnitsTextView = (TextView) itemView.findViewById(R.id.heart_rate_units);
        }
    }

    public LeaderBoardAdapter(ArrayList<LeaderBoardUser> leaderBoardUsers, Context context) {
        dataSource = leaderBoardUsers;
        this.context = context;
    }

    @Override
    public LeaderBoardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leader_board_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LeaderBoardAdapter.ViewHolder viewHolder, int position) {
        LeaderBoardUser user = dataSource.get(position);

        String rankingText = "#" + (position + 1);
        viewHolder.ranking.setText(rankingText);
        viewHolder.nameTextView.setText(user.getName());
        String genderAndLocationText = user.getGender() + " / " + user.getLocation();
        viewHolder.genderAndLocationTextView.setText(genderAndLocationText);
        Picasso.with(context)
                .load(user.getUrlAvatar())
                .resize(80, 80)
                .transform(new CircleTransform())
                .centerCrop()
                .into(viewHolder.avatarImage);
        viewHolder.distanceTextView.setText(user.getDistance() == null ? "0" : String.valueOf(user.getDistance()));
        viewHolder.heartRateTextView.setText(user.getHeartRate() == null ? "0" : user.getHeartRate());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}

