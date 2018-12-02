package com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningTopicsItem;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityLearningCategory2Binding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.battle.BattleActivity;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.homemenu.HomeFragment;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.LearningItemActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking.LearningSpeakingActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting.LearningWritingActivity;
import com.squishydev.setoz.englishkidstalk.utils.LearningConstant;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static java.security.AccessController.getContext;

public class LearningCategoryActivity extends BaseActivity implements LearningCategoryMvpView,
        LearningCategoryAdapter2.OnCategoryClick {

    @Inject
    LearningCategoryMvpPresenter<LearningCategoryMvpView> mPresenter;

    ActivityLearningCategory2Binding binding;
    LearningCategoryAdapter2 learningCategoryAdapter2;
    List<LearningTopicsItem> learningTopicsItem;
    int backgrounds[] = {R.drawable.latar_kategori_easy,R.drawable.latar_kategori_medium,R.drawable.latar_kategori_hard};
    Difficulty mDifficulty;
    int learningCategoryId;

    public static Intent getStartIntent(Context context, int learningCategoryId, Difficulty difficulty) {
        Intent intent = new Intent(context, LearningCategoryActivity.class);
        intent.putExtra("learning-category-id",learningCategoryId);
        intent.putExtra("difficulty",difficulty);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(LearningCategoryActivity.this);

        learningCategoryId = getIntent().getIntExtra("learning-category-id",1);

        mDifficulty = (Difficulty) getIntent().getSerializableExtra("difficulty");

        binding.getRoot().setBackground(ContextCompat.getDrawable(this,backgrounds[mDifficulty.getNumber()]));

        mPresenter.getLearningTopics(learningCategoryId);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learning_category_2);
        learningCategoryAdapter2 = new LearningCategoryAdapter2(new ArrayList<>(),this);

        binding.rvLearningCategory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.rvLearningCategory.setAdapter(learningCategoryAdapter2);
//        SnapToBlock snapToBlock = new SnapToBlock(2);
//        snapToBlock.attachToRecyclerView(binding.rvLearningCategory);


    }

    @Override
    public void setupTopicsItem(List<LearningTopicsItem> learningTopicsItems) {
        Log.v("Debug",learningTopicsItems.size() + "");
        this.learningTopicsItem = learningTopicsItems;
        learningCategoryAdapter2.addAll(learningTopicsItems);
    }

    @Override
    public void onClick(int position) {
        if (learningCategoryId == LearningConstant.CATEGORY_WRITING_MEDIUM ||
                learningCategoryId == LearningConstant.CATEGORY_WRITING_HARD) {
            Intent intent = LearningWritingActivity.getStartIntent(this, learningTopicsItem.get(position).getId());
            startActivity(intent);
        }else if (learningCategoryId == LearningConstant.CATEGORY_SPEAKING_HARD){
            Intent intent = LearningSpeakingActivity.getStartIntent(this, learningTopicsItem.get(position).getId());
            startActivity(intent);
        }
        else {
            Intent intent = LearningItemActivity.getStartIntent(this, learningTopicsItem.get(position).getId(),mDifficulty);
            startActivity(intent);
        }
    }

    public void backCategory (View view){
        finish();
    }
}
