package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityBuatAkunBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class LearningSpeakingActivity extends BaseActivity implements LearningSpeakingMvpView, LearningSpeakingFragment.OnSpeakingResponse {


    List<LearningItem> learningItemList;
    int currentUserProgress = 1;

    @Inject
    LearningSpeakingMvpPresenter<LearningSpeakingMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LearningSpeakingActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_speaking);

        getActivityComponent().inject(this);

        mPresenter.onAttach(LearningSpeakingActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();

        super.onDestroy();
    }

    @Override
    protected void setUp() {
        //ActivityLearningSpeakingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_learning_speaking);

        LearningItem learningItem = new LearningItem();
        learningItem.setLearningItemImage("http://belitongekspres.co.id/wp-content/uploads/2016/11/boks-Miftahun-Pulus-tak-lulus-SD-kuliahkan-3-anak.jpg");
        learningItem.setLearningItemTitle("Miftahun");
        setLearningFragment(learningItem);
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
        currentUserProgress++;
        setProgressText(currentUserProgress);
        setLearningFragment(learningItemList.get(currentUserProgress-1));
    }
}
