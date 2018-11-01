package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityLearningWritingBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class LearningWritingActivity extends BaseActivity implements LearningWritingMvpView,
        LearningWritingFragment.OnWritingResponse {

    @Inject
    LearningWritingMvpPresenter<LearningWritingMvpView> mPresenter;

    ActivityLearningWritingBinding binding;
    List<LearningItem> learningItemList;
    int currentUserProgress = 1;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LearningWritingActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(LearningWritingActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learning_writing);
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

    void setLearningFragment(LearningItem learningItem){
        Fragment fragment = LearningWritingFragment.newInstance(learningItem);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_writing, fragment).commit();
    }

    @Override
    public void onSuccess() {
        currentUserProgress++;
        setProgressText(currentUserProgress);
        setLearningFragment(learningItemList.get(currentUserProgress-1));
    }
}
