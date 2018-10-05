package com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityLearningCategoryBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.LearningItemActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class LearningCategoryActivity extends BaseActivity implements LearningCategoryMvpView,LearningCategoryAdapter.OnCategoryClick {

    @Inject
    LearningCategoryMvpPresenter<LearningCategoryMvpView> mPresenter;

    ActivityLearningCategoryBinding binding;
    LearningCategoryAdapter learningCategoryAdapter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LearningCategoryActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(LearningCategoryActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learning_category);
        learningCategoryAdapter = new LearningCategoryAdapter(new ArrayList<>(),this);
        binding.rvLearningCategory.setLayoutManager(new GridLayoutManager(this,2));
        binding.rvLearningCategory.setAdapter(learningCategoryAdapter);
    }

    @Override
    public void setupLearningCategory(List<LearningCategory> learningCategories) {
        Log.v("Debug",learningCategories.size() + "");
        learningCategoryAdapter.addAll(learningCategories);
    }

    @Override
    public void onClick(int position) {
        Intent intent = LearningItemActivity.getStartIntent(this);
        startActivity(intent);
    }
}
