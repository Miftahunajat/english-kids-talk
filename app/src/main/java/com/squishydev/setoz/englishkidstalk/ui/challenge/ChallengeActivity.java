package com.squishydev.setoz.englishkidstalk.ui.challenge;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Challenge;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityChallengeBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChalengeItemFragment;
import com.squishydev.setoz.englishkidstalk.utils.MediaUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.inject.Inject;

import cn.refactor.lib.colordialog.PromptDialog;

public class ChallengeActivity extends BaseActivity implements
        ChallengeMvpView,
        ChalengeItemFragment.ChallengeFragmentInteractionCallback {

    @Inject
    ChallengeMvpPresenter<ChallengeMvpView> mPresenter;
    Queue<Challenge> challengeQueue;
    private int mChallengesNum = 1;
    ActivityChallengeBinding binding;
    private int totalStars = 0;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ChallengeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_challenge);
        binding.tvJumlahBintang.setText(String.valueOf(totalStars));

        challengeQueue = new LinkedList<>();

        getActivityComponent().inject(this);

        mPresenter.onAttach(ChallengeActivity.this);

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {


    }


    @Override
    public void setupChallenges(List<Challenge> challenges) {
        challengeQueue.addAll(challenges);
        loadChallegeGame();
    }

    void loadChallegeGame(){
        if (!challengeQueue.isEmpty()){
            binding.tvAngka.setText(String.valueOf(mChallengesNum));
            mChallengesNum++;

            ChalengeItemFragment fragment = ChalengeItemFragment.newInstance(challengeQueue.peek());
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout,fragment)
                    .commit();
        }else{
            showSuccessPrompt("Selamat !!", "Total bintang yang anda dapat " + totalStars,
                    promptDialog -> finish());
            mPresenter.updateUserStar(totalStars);
        }
        binding.tvJumlahBintang.setText(String.valueOf(totalStars));
    }

    @Override
    public void onTimeRunningOut() {
        showFailedPrompt("Waktu anda telah habis","Total bintang yang didapat " + totalStars,
                promptDialog -> {
                    finish();
                });
    }

    @Override
    public void onAnswersCorrect(int stars) {

        totalStars+=stars;
        challengeQueue.poll();
        if (! challengeQueue.isEmpty()){
            MediaUtils.playSound(this,R.raw.correct);
        }
        loadChallegeGame();
    }

    @Override
    public void onAnswersWrong() {
        showFailedPrompt("Jawaban anda salah","Total bintang yang didapat " + totalStars,
                promptDialog -> {
            finish();
                });

    }
}
