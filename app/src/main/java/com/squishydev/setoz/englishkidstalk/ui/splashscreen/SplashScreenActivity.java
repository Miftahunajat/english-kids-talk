package com.squishydev.setoz.englishkidstalk.ui.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivitySplashScreenBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaActivity;
import javax.inject.Inject;

public class SplashScreenActivity extends BaseActivity implements SplashScreenMvpView {

    @Inject
    SplashScreenMvpPresenter<SplashScreenMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashScreenActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_splash_screen);
//        binding.imageView16.setOnClickListener(view -> {
//            startActivity(new Intent(SplashScreenActivity.this, InputNamaActivity.class));
//        });
//        binding.imageView14.setOnClickListener(view -> {
//            startActivity(new Intent(SplashScreenActivity.this, InputNamaActivity.class));
//        });

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

    }

}
