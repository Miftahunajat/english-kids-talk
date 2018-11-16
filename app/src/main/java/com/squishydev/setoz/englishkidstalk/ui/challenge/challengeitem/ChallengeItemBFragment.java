package com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentChallengeItemBBinding;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting.LearningWritingFragment;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting.WritingControl;


public class ChallengeItemBFragment extends BaseChallengeItemFragment implements WritingControl.OnWritingSubmit
{

    private static final String TAG = "ChallengeItemBFragment";
    FragmentChallengeItemBBinding binding;
    private WritingControl writingControl;


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

//        binding.setChallenge(mChallenge);

        Challenge challenge = (Challenge) getArguments().getSerializable("challenge");

        constructChallengeTimer(binding.fillLoading,binding.tvTimer);
        writingControl = new WritingControl(binding.fbChallenge, challenge.getChallengeQuestion(),this );
        writingControl.buildLinearLayout();
        binding.btnAnswer.setOnClickListener(v -> {
            //checkAnswer(writingControl.getAnswer());
            Toast.makeText(getContext(),writingControl.getAnswer(), Toast.LENGTH_SHORT).show();
        });
        binding.setChallenge(challenge);
//        onWritingResponse = (LearningWritingFragment.OnWritingResponse) getBaseActivity();

        return binding.getRoot();
    }

    @Override
    protected void setUp(View view) {
        binding.btnAnswer.setOnClickListener(view1 -> {
            stopChallengeTimer();
            binding.executePendingBindings();
            onUserAnswer(writingControl.getAnswer().toLowerCase(),
                    mChallenge.getAnswers().get(0).getAnswerText(),
                    mChallenge.getChallengeStar());
        });
    }

    @Override
    public void onSubmit() {
        stopChallengeTimer();
        binding.executePendingBindings();
        onUserAnswer(writingControl.getAnswer().toLowerCase(),
                mChallenge.getAnswers().get(0).getAnswerText(),
                mChallenge.getChallengeStar());
    }
}

