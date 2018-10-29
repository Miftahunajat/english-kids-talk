package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityLearningWritingBinding;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentLearningSpeakingBinding;

public class LearningWritingActivity extends AppCompatActivity {

    ActivityLearningWritingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learning_writing);
        WritingControl writingControl = new WritingControl(binding.fbQuestion, "Apakah saya binatang yang manusia yang suka mencumbu anjing",this );
        writingControl.buildLinearLayout();
    }
}
