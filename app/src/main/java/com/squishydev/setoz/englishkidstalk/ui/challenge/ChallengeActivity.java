package com.squishydev.setoz.englishkidstalk.ui.challenge;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.WindowManager;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityChallengeBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.BaseChallengeItemFragment;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChalengeItemAFragment;
import com.squishydev.setoz.englishkidstalk.utils.MediaUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.inject.Inject;

public class ChallengeActivity extends BaseActivity implements
        ChallengeMvpView,
        BaseChallengeItemFragment.ChallengeFragmentInteractionCallback {

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

            int type = challengeQueue.peek().getChallengeType();

            Fragment fragment = getChallengeFragments(type,challengeQueue.peek());
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout,fragment)
                    .commit();
        }else{
            showSuccessPrompt("Selamat !!", "Total bintang yang anda dapat " + totalStars,
                    promptDialog -> {
                        mPresenter.updateUserStar(totalStars);
                    });

        }
        binding.tvJumlahBintang.setText(String.valueOf(totalStars));
    }

    @Override
    public void onTimeRunningOut() {
        showFailedPrompt("Waktu anda telah habis","Total bintang yang didapat " + totalStars,
                promptDialog -> {
                    mPresenter.updateUserStar(totalStars);
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
            mPresenter.updateUserStar(totalStars);
                });

    }

    Fragment getChallengeFragments(int type,Challenge challenge){
        switch (type){
            case 1:
                return ChalengeItemAFragment.newInstance(challenge);
            default:
                return ChalengeItemAFragment.newInstance(challenge);
        }
    }
}
