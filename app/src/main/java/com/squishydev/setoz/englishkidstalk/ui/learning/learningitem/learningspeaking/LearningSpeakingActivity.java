package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.utils.MediaUtils;

import java.util.List;

import javax.inject.Inject;

public class LearningSpeakingActivity extends BaseActivity implements LearningSpeakingMvpView, LearningSpeakingFragment.OnSpeakingResponse {


    List<LearningItem> learningItemList;
    int currentUserProgress = 1;
    int learningTopicId;

    @Inject
    LearningSpeakingMvpPresenter<LearningSpeakingMvpView> mPresenter;

    public static Intent getStartIntent(Context context, int learningTopicId) {
        Intent intent = new Intent(context, LearningSpeakingActivity.class);
        intent.putExtra("learning-topic-id",learningTopicId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_speaking);

        getActivityComponent().inject(this);

        mPresenter.onAttach(LearningSpeakingActivity.this);

        learningTopicId = getIntent().getIntExtra("learning-topic-id",1);

        mPresenter.getLearningSpeakingItem(learningTopicId);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();

        super.onDestroy();
    }

    @Override
    protected void setUp() {
        //ActivityLearningSpeakingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_learning_speaking);
    }

    void setLearningFragment(LearningItem learningItem){
        Fragment fragment = LearningSpeakingFragment.newInstance(learningItem);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, fragment).commit();
    }

    @Override
    public void setupLearningItem(List<LearningItem> learningItems) {
        learningItemList = learningItems;
        setLearningFragment(learningItemList.get(currentUserProgress-1));
        setProgressText(currentUserProgress);
    }

    void setProgressText(int progress){
        TextView tvUpdate = findViewById(R.id.tv_progress);
        tvUpdate.setText(progress+"/"+learningItemList.size());
    }

    @Override
    public void onSuccess() {
        MediaUtils.playSound(this,R.raw.correct);
        currentUserProgress++;
        if (currentUserProgress >= learningItemList.size())
            finish();
        setProgressText(currentUserProgress);
        setLearningFragment(learningItemList.get(currentUserProgress-1));
    }

    public  void  backSpeaking (View view){
        finish();
    }
}
