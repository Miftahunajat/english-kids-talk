package com.squishydev.setoz.englishkidstalk.ui.battle.battleselect;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.firebase.model.Match;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentBattleSelectBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BattleSelectFragment extends BaseFragment implements BattleSelectAdapter.OnBattlePlayerClick, BattleSelectCallback {


    FragmentBattleSelectBinding binding;
    BattleSelectAdapter adapter;
    List<Match> matches;
    BattleSelectInteractor mCallback;
    public static final String TAG = "Bude";

    public BattleSelectFragment() {
        // Required empty public constructor
    }

    public static BattleSelectFragment newInstance() {
        BattleSelectFragment fragment = new BattleSelectFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_battle_select,container,false);

        mCallback = (BattleSelectInteractor) getBaseActivity();
        mCallback.getMatches();
        matches = new ArrayList<>();
        adapter = new BattleSelectAdapter(matches,this);
        binding.rvMatchBattle.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvMatchBattle.setAdapter(adapter);
        binding.fabCreate.setOnClickListener(v -> mCallback.createMatch());

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onClick(int position) {
        mCallback.joinMatch(matches.get(position));
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void setMatchesData(List<Match> matchesData) {
        matches = matchesData;
        adapter.swap(matchesData);
    }

    interface BattleSelectInteractor{
        void createMatch();
        void getMatches();
        void joinMatch(Match matchId);
    }
}
