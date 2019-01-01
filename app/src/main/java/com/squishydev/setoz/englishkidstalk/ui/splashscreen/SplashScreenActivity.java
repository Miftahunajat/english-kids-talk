package com.squishydev.setoz.englishkidstalk.ui.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivitySplashScreenBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.DashboardActivity;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaActivity;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.LevelSelectActivity;
import com.squishydev.setoz.englishkidstalk.utils.AnimationUtil;

import javax.inject.Inject;

public class SplashScreenActivity extends BaseActivity implements SplashScreenMvpView {

    @Inject
    SplashScreenMvpPresenter<SplashScreenMvpView> mPresenter;
    ActivitySplashScreenBinding binding;

    private int SPLASH_TIME_OUT = 3000;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashScreenActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash_screen);

        getActivityComponent().inject(this);

        mPresenter.onAttach(SplashScreenActivity.this);

        animate();

    }

    private void animate() {
        binding.ivIconSplash.startAnimation(AnimationUtil.getInstance(this).getBounceAnimation(100));
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.hyperspace_jump);
        binding.ivBackgroundSplash.startAnimation(animation);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

        new Handler().postDelayed(() -> {
            mPresenter.checkUserLoggedInMode();
        },SPLASH_TIME_OUT);
    }


    @Override
    public void openDashboardActivity() {
        Intent intent = DashboardActivity.getStartIntent(SplashScreenActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openInputNamaActivity() {
        Intent intent = InputNamaActivity.getStartIntent(SplashScreenActivity.this);
        startActivity(intent);
        finish();
    }
}
