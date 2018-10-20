package com.squishydev.setoz.englishkidstalk.ui.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivitySplashScreenBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaActivity;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.LevelSelectActivity;

import javax.inject.Inject;

public class SplashScreenActivity extends BaseActivity implements SplashScreenMvpView {

    @Inject
    SplashScreenMvpPresenter<SplashScreenMvpView> mPresenter;

    private int SPLASH_TIME_OUT = 3000;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashScreenActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_splash_screen);

        getActivityComponent().inject(this);

        mPresenter.onAttach(SplashScreenActivity.this);

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
    public void openLevelSelectActivity() {
        Intent intent = LevelSelectActivity.getStartIntent(SplashScreenActivity.this);
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
