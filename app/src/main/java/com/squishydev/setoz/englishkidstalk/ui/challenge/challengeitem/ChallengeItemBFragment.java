package com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentChallengeItemBBinding;


public class ChallengeItemBFragment extends BaseChallengeItemFragment
{

    private static final String TAG = "ChallengeItemBFragment";
    FragmentChallengeItemBBinding binding;


    public static ChallengeItemBFragment newInstance(Challenge challenge) {
        Bundle args = new Bundle();
        args.putSerializable("challenge",challenge);
        ChallengeItemBFragment fragment = new ChallengeItemBFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_challenge_item_b, container, false);

        binding.setChallenge(mChallenge);

        constructChallengeTimer(binding.fillLoading,binding.tvTimer);

        return binding.getRoot();
    }

    @Override
    protected void setUp(View view) {
        binding.btnAnswer.setOnClickListener(view1 -> {
            stopChallengeTimer();
            binding.executePendingBindings();
            onUserAnswer(binding.etAnswer.getText().toString().toLowerCase(),
                    mChallenge.getAnswers().get(0).getAnswerText(),
                    mChallenge.getChallengeStar());
        });
    }

}

