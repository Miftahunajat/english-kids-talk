package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityLearningWritingBinding;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentLearningSpeakingBinding;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking.LearningSpeakingFragment;

public class LearningWritingActivity extends AppCompatActivity{

    ActivityLearningWritingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learning_writing);

        Fragment fragment = LearningWritingFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_writing,fragment).commit();
    }

    public

}
