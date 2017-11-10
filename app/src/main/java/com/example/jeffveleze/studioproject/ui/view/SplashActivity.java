package com.example.jeffveleze.studioproject.ui.view;

import android.content.Intent;
import android.view.WindowManager;
import com.daimajia.androidanimations.library.Techniques;
import com.example.jeffveleze.studioproject.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import static com.example.jeffveleze.studioproject.utils.SplashConstants.imagePath;

public class SplashActivity extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorPrimaryDark);
        configSplash.setAnimCircularRevealDuration(1000);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);

        //Customize Path
        configSplash.setPathSplash(imagePath);
        configSplash.setOriginalHeight(200);
        configSplash.setOriginalWidth(200);
        configSplash.setAnimPathStrokeDrawingDuration(2000);
        configSplash.setPathSplashStrokeSize(3);
        configSplash.setPathSplashStrokeColor(R.color.white);
        configSplash.setAnimPathFillingDuration(3000);
        configSplash.setPathSplashFillColor(R.color.white);

        //Customize Title
        configSplash.setTitleSplash(getString(R.string.app_name));
        configSplash.setTitleTextColor(R.color.white);
        configSplash.setTitleTextSize(35f);
        configSplash.setAnimTitleDuration(2000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);

    }

    @Override
    public void animationsFinished() {
        goToLeaderBoardView();
    }

    private void goToLeaderBoardView() {
        Intent intent = new Intent(this, LeaderBoardActivity.class);
        startActivity(intent);
    }

}
