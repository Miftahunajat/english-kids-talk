package com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengeTimer;

/**
 * Created by miftahun on 10/13/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public abstract class BaseChallengeItemFragment extends BaseFragment implements ChallengeTimer.TimerCallback, MvpView {

    private ChallengeFragmentInteractionCallback callback;
    private ChallengeTimer challengeTimer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        callback = (ChallengeFragmentInteractionCallback) getActivity();

        return super.onCreateView(inflater, container, savedInstanceState);


    }

    protected void constructChallengeTimer(View fillLoading, TextView tvTimer) {
        challengeTimer = new ChallengeTimer(getBaseActivity(),
                fillLoading,
                this,
                tvTimer);
        challengeTimer.start();
    }

    public interface ChallengeFragmentInteractionCallback {
        void onTimeRunningOut();

        void onAnswersCorrect(int stars);

        void onAnswersWrong();
    }

    @Override
    public void onFinish() {
        callback.onTimeRunningOut();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        challengeTimer.stop();
    }

    void onUserAnswer(String userAnswer, String expectedAnswer, int stars) {
        if (userAnswer.toLowerCase().equals(expectedAnswer.toLowerCase())) {
            callback.onAnswersCorrect(stars);
        } else {
            callback.onAnswersWrong();
        }
    }

    protected void stopChallengeTimer(){
        challengeTimer.stop();
    }
}
