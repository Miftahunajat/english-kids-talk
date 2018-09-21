package com.squishydev.setoz.englishkidstalk.ui.splashscreen;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityMainBinding;
import com.squishydev.setoz.englishkidstalk.databinding.ActivitySplashScreenBinding;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_splash_screen);
        binding.imageView16.setOnClickListener(view -> {
            startActivity(new Intent(SplashScreenActivity.this, InputNamaActivity.class));
        });
//        binding.ivBackgroundSplash.setOnClickListener(view -> startActivity(new Intent(SplashScreenActivity.this,)));
    }
}
