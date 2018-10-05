package com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu;

import android.content.Context;
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
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentMainBinding;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengeActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryActivity;

import java.util.List;

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
            //MOCK
            mDifficulty = Difficulty.DIFFICULTY_EASY;
            //REAL
//            mDifficulty = (Difficulty) getArguments().getSerializable("difficulty");
        }
        View view = inflater.inflate(layouts[mDifficulty.getNumber()],container,false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
            Log.d("Presenter","Not null");
        }
        if (mDifficulty == Difficulty.DIFFICULTY_EASY){
            view.findViewById(R.id.iv_vocab_easy).setOnClickListener(view1 -> {
                Intent intent = LearningCategoryActivity.getStartIntent(getContext());
                startActivity(intent);
            });
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
//        // TODO : Diilangi cuman dummy
//        binding.btnNext.setOnClickListener(v ->{
//            Intent intent = LearningCategoryActivity.getStartIntent(getContext());
//            startActivity(intent);
//        });
//
//        // TODO : Diilangi cuman dummy
//        binding.btnChalenge.setOnClickListener(v->{
//            Intent intent = ChallengeActivity.getStartIntent(getContext());
//            startActivity(intent);
//        });


    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}

