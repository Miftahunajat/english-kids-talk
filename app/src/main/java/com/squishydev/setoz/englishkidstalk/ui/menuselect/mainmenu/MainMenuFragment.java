package com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentLevelEasyBinding;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentLevelHardBinding;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentLevelMediumBinding;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengeActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryActivity;
import com.squishydev.setoz.englishkidstalk.utils.LearningConstant;


import javax.inject.Inject;

public class MainMenuFragment extends BaseFragment implements
        MainMenuMvpView {

    private static final String TAG = "MainMenuFragment";

    private Difficulty mDifficulty;
    private int layouts[] = {R.layout.fragment_level_easy,
            R.layout.fragment_level_medium,
            R.layout.fragment_level_hard};



    @Inject
    MainMenuMvpPresenter<MainMenuMvpView> mPresenter;

    public static MainMenuFragment newInstance(Difficulty difficulty) {
        Bundle args = new Bundle();
        args.putSerializable("difficulty",difficulty);
        MainMenuFragment fragment = new MainMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (getArguments() != null){
            mDifficulty = (Difficulty) getArguments().getSerializable("difficulty");
        }
        View view = inflater.inflate(layouts[mDifficulty.getNumber()],container,false);


        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
            Log.d("Presenter","Not null");
        }
        setContentBinding(view);

        return view;
    }

    private void setContentBinding(View view) {
        if (mDifficulty == Difficulty.DIFFICULTY_EASY){
            FragmentLevelEasyBinding binding = DataBindingUtil.bind(view);
            binding.ivVocabEasy.setOnClickListener(v -> {
                Intent intent = LearningCategoryActivity.getStartIntent(getContext(), LearningConstant.CATEGORY_VOCAB_EASY,mDifficulty);
                startActivity(intent);
            });
            binding.ivChallengeEasy.setOnClickListener(v -> {
                Intent intent = ChallengeActivity.getStartIntent(getContext(),mDifficulty);
                startActivity(intent);
            });
        }else if (mDifficulty == Difficulty.DIFFICULTY_MEDIUM){
            FragmentLevelMediumBinding binding = DataBindingUtil.bind(view);
            binding.ivVocabMedium.setOnClickListener(v -> {
                Intent intent = LearningCategoryActivity.getStartIntent(getContext(), LearningConstant.CATEGORY_VOCAB_MEDIUM,mDifficulty);
                startActivity(intent);
            });
            binding.ivWritingMedium.setOnClickListener(v -> {
                Intent intent = LearningCategoryActivity.getStartIntent(getContext(), LearningConstant.CATEGORY_WRITING_MEDIUM,mDifficulty);
                startActivity(intent);
            });
            binding.ivChallengeMedium.setOnClickListener(v -> {
                Intent intent = ChallengeActivity.getStartIntent(getContext(),mDifficulty);
                startActivity(intent);
            });
        }else if (mDifficulty == Difficulty.DIFFICULTY_HARD){
            FragmentLevelHardBinding binding = DataBindingUtil.bind(view);
            binding.ivVocabHard.setOnClickListener(v -> {
                Intent intent = LearningCategoryActivity.getStartIntent(getContext(), LearningConstant.CATEGORY_VOCAB_HARD,mDifficulty);
                startActivity(intent);
            });
            binding.ivWritingHard.setOnClickListener(v -> {
                Intent intent = LearningCategoryActivity.getStartIntent(getContext(), LearningConstant.CATEGORY_WRITING_HARD,mDifficulty);
                startActivity(intent);
            });
            binding.ivSpeakingHard.setOnClickListener(v -> {
                Intent intent = LearningCategoryActivity.getStartIntent(getContext(), LearningConstant.CATEGORY_SPEAKING_HARD,mDifficulty);
                startActivity(intent);
            });
            binding.ivChallengeHard.setOnClickListener(v -> {
                Intent intent = ChallengeActivity.getStartIntent(getContext(),mDifficulty);
                startActivity(intent);
            });
        }
    }

    @Override
    protected void setUp(View view) {

    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}

