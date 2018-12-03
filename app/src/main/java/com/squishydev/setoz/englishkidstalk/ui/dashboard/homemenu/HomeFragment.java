package com.squishydev.setoz.englishkidstalk.ui.dashboard.homemenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentProfileBinding;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.DashboardActivity;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleselect.BattleActivity;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.MenuSelectActivity;

import javax.inject.Inject;

public class HomeFragment extends BaseFragment implements HomeMvpView {

    private static final String TAG = "HomeFragment";

    @Inject
    HomeMvpPresenter<HomeMvpView> mPresenter;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }
        return view;
    }

    public void openBasic(View view) {
        Intent intent = MenuSelectActivity.getStartIntent(getContext(), Difficulty.DIFFICULTY_EASY);
        startActivity(intent);
    }

    public void openIntermediate(View view) {
        Intent intent = MenuSelectActivity.getStartIntent(getContext(), Difficulty.DIFFICULTY_MEDIUM);
        startActivity(intent);
    }

    public void openAdvance(View view) {
        Intent intent = MenuSelectActivity.getStartIntent(getContext(), Difficulty.DIFFICULTY_HARD);
        startActivity(intent);
    }

    public void openBattle(View view) {
        Intent intent = BattleActivity.getStartIntent(getContext());
        startActivity(intent);
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

