package com.squishydev.setoz.englishkidstalk;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.data.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);




    }
}
