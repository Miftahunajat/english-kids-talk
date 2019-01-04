package com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.AnswersItem;
import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentChallengeItemDBinding;

import java.util.ArrayList;
import java.util.List;

public class ChallengeItemDFragment extends BaseChallengeItemFragment implements ChallengeOptionsAdapter.OnItemClick {

    private static final String TAG = "ChallengeItemDFragment";
    FragmentChallengeItemDBinding binding;
    ChallengeOptionsAdapter challengeOptionsAdapter;
    List<AnswersItem> answersItems;

    public static ChallengeItemDFragment newInstance(Challenge challenge) {
        Bundle args = new Bundle();
        args.putSerializable("challenge", challenge);
        ChallengeItemDFragment fragment = new ChallengeItemDFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_challenge_item_d, container, false);
        binding.setChallenge(mChallenge);
        constructChallengeTimer(binding.fillLoading, binding.tvTimer);
        challengeOptionsAdapter = new ChallengeOptionsAdapter(new ArrayList<>(), this, getContext());
        binding.rvAnswerOptions.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAnswerOptions.setAdapter(challengeOptionsAdapter);
        setUpAnswerItem(mChallenge.getAnswers());
        return binding.getRoot();
    }

    @Override
    protected void setUp(View view) {}

    @Override
    public void onClick(int position) {
        onUserAnswer(answersItems.get(position).isIsCorrect(), mChallenge.getChallengeStar());
    }

    public void setUpAnswerItem(List<AnswersItem> answersItems) {
        challengeOptionsAdapter.addAll(answersItems);
        this.answersItems = answersItems;
    }
}
