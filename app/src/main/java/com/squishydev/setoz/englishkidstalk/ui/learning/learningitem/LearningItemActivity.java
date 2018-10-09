package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityLearningItemBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryAdapter;
import com.squishydev.setoz.englishkidstalk.utils.MediaUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class LearningItemActivity extends BaseActivity implements LearningItemMvpView,LearningItemAdapter.OnItemClick {

    @Inject
    LearningItemMvpPresenter<LearningItemMvpView> mPresenter;

    ActivityLearningItemBinding binding;
    LearningItemAdapter learningItemAdapter;
    List<LearningItem> learningItems;

    public static Intent getStartIntent(Context context, int id) {
        Intent intent = new Intent(context, LearningItemActivity.class);
        intent.putExtra("id_category",id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(LearningItemActivity.this);

        mPresenter.getLearningItem(getIntent().getIntExtra("id_category",0));
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learning_item);
        learningItemAdapter = new LearningItemAdapter(new ArrayList<>(),this);
        binding.rvLearningItem.setLayoutManager(new GridLayoutManager(this,2));
        binding.rvLearningItem.setAdapter(learningItemAdapter);

    }

    @Override
    public void onClick(int position) {
        MediaUtils.playSound(this,learningItems.get(position).getSound());

    }

    @Override
    public void setupLearningItem(List<LearningItem> learningItems) {
        learningItemAdapter.addAll(learningItems);
        this.learningItems = learningItems;
    }
}
