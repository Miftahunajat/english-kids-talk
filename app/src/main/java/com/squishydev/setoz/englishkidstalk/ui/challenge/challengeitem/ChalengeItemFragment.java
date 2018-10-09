package com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Challenge;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentChallengeItemBinding;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengeTimer;

import javax.inject.Inject;

public class ChalengeItemFragment extends BaseFragment implements
        ChalengeItemMvpView,
        ChallengeTimer.TimerCallback{

    private static final String TAG = "ChalengeItemFragment";
    FragmentChallengeItemBinding binding;
    ChallengeFragmentInteractionCallback callback;

    @Inject
    ChalengeItemMvpPresenter<ChalengeItemMvpView> mPresenter;
    private ChallengeTimer challengeTimer;
    private Challenge mChallenge;

    public static ChalengeItemFragment newInstance(Challenge challenge) {
        Bundle args = new Bundle();
        args.putSerializable("challenge",challenge);
        ChalengeItemFragment fragment = new ChalengeItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_challenge_item,container,false);
        callback = (ChallengeFragmentInteractionCallback) getActivity();
        mChallenge = (Challenge) getArguments().getSerializable("challenge");

        binding.setChallenge(mChallenge);

        challengeTimer = new ChallengeTimer(getBaseActivity(),
                binding.fillLoading,
                this,
                binding.tvTimer);
        challengeTimer.start();


        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }
        return binding.getRoot();
    }

    @Override
    protected void setUp(View view) {
        binding.btnAnswer.setOnClickListener(view1 -> {
            challengeTimer.stop();
            binding.executePendingBindings();
            if (binding.etAnswer.getText().toString().toLowerCase().equals(mChallenge.getAnswers())){
                callback.onAnswersCorrect(mChallenge.getStars());
            }else{
                callback.onAnswersWrong();
            }
        });
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onFinish() {
        callback.onTimeRunningOut();
    }

    public interface ChallengeFragmentInteractionCallback{
        void onTimeRunningOut();
        void onAnswersCorrect(int stars);
        void onAnswersWrong();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        challengeTimer.stop();
    }
}

