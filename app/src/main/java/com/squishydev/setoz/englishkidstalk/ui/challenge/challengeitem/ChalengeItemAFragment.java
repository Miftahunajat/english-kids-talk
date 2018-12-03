package com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentChallengeItemABinding;


public class ChalengeItemAFragment extends BaseChallengeItemFragment {

    private static final String TAG = "ChalengeItemAFragment";
    FragmentChallengeItemABinding binding;


    public static ChalengeItemAFragment newInstance(Challenge challenge) {
        Bundle args = new Bundle();
        args.putSerializable("challenge",challenge);
        ChalengeItemAFragment fragment = new ChalengeItemAFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_challenge_item_a, container, false);

        binding.setChallenge(mChallenge);

        constructChallengeTimer(binding.fillLoading,binding.tvTimer);

        return binding.getRoot();
    }

    @Override
    protected void setUp(View view) {
        binding.etAnswer.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    stopChallengeTimer();
                    binding.executePendingBindings();
                    onUserAnswer(
                            binding.etAnswer.getText().toString().toLowerCase(),
                            mChallenge.getAnswers().get(0).getAnswerText(),
                            mChallenge.getChallengeStar()
                    );
                    hideKeyboard();
                    return true;
                }
                return false;
            }
        });
        binding.btnAnswer.setOnClickListener(view1 -> {
            stopChallengeTimer();
            binding.executePendingBindings();
            onUserAnswer(binding.etAnswer.getText().toString().toLowerCase(),
                    mChallenge.getAnswers().get(0).getAnswerText(),
                    mChallenge.getChallengeStar());
        });
    }

}

