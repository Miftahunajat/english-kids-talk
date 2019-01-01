package com.squishydev.setoz.englishkidstalk.ui.dashboard.homemenu;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentHomeBinding;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleselect.BattleActivity;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.MenuSelectActivity;
import com.squishydev.setoz.englishkidstalk.ui.splashscreen.SplashScreenActivity;

import javax.inject.Inject;

public class HomeFragment extends BaseFragment implements HomeMvpView {

    private static final String TAG = "HomeFragment";

    @Inject
    HomeMvpPresenter<HomeMvpView> mPresenter;

    FragmentHomeBinding binding;

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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }
        return binding.getRoot();
    }


    @Override
    protected void setUp(View view) {
        binding.btnExit.setOnClickListener(v ->{
            mPresenter.clearCache();
            Intent intent = SplashScreenActivity.getStartIntent(getContext());
            startActivity(intent);
            finish();
        });

        binding.ivEasy.setOnClickListener(v ->{
            Intent intent = MenuSelectActivity.getStartIntent(getContext(), Difficulty.DIFFICULTY_EASY);
            startActivity(intent);
        });

        binding.ivIntermediate.setOnClickListener(v -> {
            Intent intent = MenuSelectActivity.getStartIntent(getContext(), Difficulty.DIFFICULTY_MEDIUM);
            startActivity(intent);
        });

        binding.ivAdvanced.setOnClickListener(v -> {
            Intent intent = MenuSelectActivity.getStartIntent(getContext(), Difficulty.DIFFICULTY_HARD);
            startActivity(intent);
        });

        binding.ivBattle.setOnClickListener(v -> {
            Intent intent = BattleActivity.getStartIntent(getContext());
            startActivity(intent);
        });
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void setUser(User user) {
        if (user.getGender() == 0){
            binding.ivProfile.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.avatar_cowok_profile_bulat));
        }
        binding.setUser(user);
    }
}

