package com.squishydev.setoz.englishkidstalk.ui.battle.battlematch;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityBattleMatchBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleresult.BattleResultActivity;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.BaseChallengeItemFragment;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChalengeItemAFragment;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChallengeItemBFragment;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChallengeItemCFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class BattleMatchActivity extends BaseActivity implements BattleMatchMvpView,
        BaseChallengeItemFragment.ChallengeFragmentInteractionCallback {

    User user;

    @Inject
    BattleMatchMvpPresenter<BattleMatchMvpView> mPresenter;

    ActivityBattleMatchBinding binding;

    List<Challenge> challenges = new ArrayList<>();
    int currentQuestion = 0;
    private int myScore = 0;
    private int enemyScore = 0;
    private String TAG = getClass().getSimpleName();

    public static Intent getStartIntent(Context context, String matchId, String userId, String enemyId) {
        Intent intent = new Intent(context, BattleMatchActivity.class);
        intent.putExtra("match",matchId);
        intent.putExtra("userid",userId);
        intent.putExtra("enemyid",enemyId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(BattleMatchActivity.this);
        mPresenter.setUserData(getIntent().getStringExtra("userid"), getIntent().getStringExtra("enemyid"));

        int profil = user.getGender() == 0 ? R.drawable.avatar_cowok_profile_bulat : R.drawable.avatar_cewek_profile_bulat;

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();

        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_battle_match);
    }

    @Override
    public void updateScore(String myUser, String enemyId) {
        binding.tvMyScore.setText(myUser);
        binding.tvEnemyScore.setText(enemyId);

        myScore = Integer.valueOf(myUser);
        enemyScore = Integer.valueOf(enemyId);
        observeCurrentScore();
    }

    @Override
    public void updateScoreMyScore(String myUser) {
        binding.tvMyScore.setText(myUser);
        myScore = Integer.valueOf(myUser);
        observeCurrentScore();
    }

    @Override
    public void updateScoreEnemyScore(String enemyId) {
        binding.tvEnemyScore.setText(enemyId);
        enemyScore = Integer.valueOf(enemyId);
        observeCurrentScore();
    }

    private void observeCurrentScore() {
        Log.d(TAG, "observeCurrentScore: ");
        if (myScore > 3 || enemyScore > 3){
            mPresenter.endMatchGame();
        }
    }

    @Override
    public void setDataChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
        loadChallenge();
    }

    private void loadChallenge() {
        Fragment fragment = getChallengeFragments(challenges.get(currentQuestion).getChallengeType(),challenges.get(currentQuestion));
        getSupportFragmentManager().beginTransaction().replace(binding.flFragment.getId(),fragment).commit();
    }

    @Override
    public void nextChallenge() {
        currentQuestion = ( currentQuestion + 1 ) % challenges.size();
        loadChallenge();
    }

    @Override
    public String getMatchId() {
        return getIntent().getStringExtra("match");
    }

    @Override
    public void setUser(User user, User user2) {
        binding.setUser(user);
        binding.setMusuh(user2);
    }

    Fragment getChallengeFragments(int type, Challenge challenge){
        switch (type){
            case 1:
                return ChalengeItemAFragment.newInstance(challenge);
            case 2:
                return ChallengeItemBFragment.newInstance(challenge);
            case 3:
                return ChallengeItemCFragment.newInstance(challenge);
//            case 4:
//                return ChallengeItemDFragment.newInstance(challenge);
            default:
                return ChalengeItemAFragment.newInstance(challenge);
        }
    }

    @Override
    public String getCurrentUserId() {
        return getIntent().getStringExtra("userid");
    }

    @Override
    public String getEnemyId() {
        return getIntent().getStringExtra("enemyid");
    }

    @Override
    public void openBattleResult() {
        mPresenter.setUserData(getIntent().getStringExtra("userid"), getIntent().getStringExtra("enemyid"));
        String myUserId = getIntent().getStringExtra("userid");
        String enemyId = getIntent().getStringExtra("enemyid");
        boolean isWinning = myScore >= enemyScore;
        Log.d(TAG, "openBattleResult: " + String.format("%s || %s || %d || %d || %s",myUserId,enemyId,myScore,enemyScore,isWinning));
        Intent intent = BattleResultActivity.getStartIntent(this,myUserId, enemyId,myScore,enemyScore,isWinning);
        startActivity(intent);
        finish();
    }

    @Override
    public void onTimeRunningOut() {
        nextChallenge();
    }

    @Override
    public void onAnswersCorrect(int stars) {
        mPresenter.updateUserScore(2);
    }

    @Override
    public void onAnswersWrong() {
        showMessage("Jawaban salah");
    }


}
