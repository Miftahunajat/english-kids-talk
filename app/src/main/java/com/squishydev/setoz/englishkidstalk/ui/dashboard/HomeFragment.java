package com.squishydev.setoz.englishkidstalk.ui.dashboard;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.ui.battle.BattleActivity;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.MenuSelectActivity;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getContext( fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DashboardActivity.class);
        return intent;
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

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
