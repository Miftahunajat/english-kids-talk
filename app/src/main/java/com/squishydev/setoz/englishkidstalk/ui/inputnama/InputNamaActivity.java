package com.squishydev.setoz.englishkidstalk.ui.inputnama;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityInputNamaBinding;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.LevelSelectActivity;
import com.squishydev.setoz.englishkidstalk.ui.pilihavatar.PilihAvatar;

public class InputNamaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInputNamaBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_input_nama);

        binding.btnNext.setOnClickListener(v ->{
            startActivity(new Intent(InputNamaActivity.this, LevelSelectActivity.class));
        });
    }
}
