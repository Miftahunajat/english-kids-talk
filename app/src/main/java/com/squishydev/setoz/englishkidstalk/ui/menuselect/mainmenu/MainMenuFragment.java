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
import com.squishydev.setoz.englishkidstalk.databinding.FragmentMainBinding;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengeActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryActivity;

import javax.inject.Inject;

public class MainMenuFragment extends BaseFragment implements
        MainMenuMvpView {

    private static final String TAG = "MainMenuFragment";

    FragmentMainBinding binding;

    @Inject
    MainMenuMvpPresenter<MainMenuMvpView> mPresenter;

    public static MainMenuFragment newInstance() {
        Bundle args = new Bundle();
        MainMenuFragment fragment = new MainMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
            Log.d("Presenter","Not null");
        }
        return binding.getRoot();
    }

    @Override
    protected void setUp(View view) {
        binding.btnNext.setOnClickListener(v ->{
            Intent intent = LearningCategoryActivity.getStartIntent(getContext());
            startActivity(intent);
        });

        binding.btnChalenge.setOnClickListener(v->{
            Intent intent = ChallengeActivity.getStartIntent(getContext());
            startActivity(intent);
        });
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}

