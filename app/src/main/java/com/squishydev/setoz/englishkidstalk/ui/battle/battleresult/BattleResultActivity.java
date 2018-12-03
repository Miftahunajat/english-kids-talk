package com.squishydev.setoz.englishkidstalk.ui.battle.battleresult;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityBattleResultBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;

import javax.inject.Inject;

public class BattleResultActivity extends BaseActivity implements BattleResultMvpView {

    @Inject
    BattleResultMvpPresenter<BattleResultMvpView> mPresenter;

    ActivityBattleResultBinding binding;
    private String TAG = getClass().getSimpleName();

    public static Intent getStartIntent(Context context,
                                        String myUserId,
                                        String enemyId,
                                        int myScore,
                                        int enemyScore,
                                        boolean isWinning) {
        Intent intent = new Intent(context, BattleResultActivity.class);
        intent.putExtra("userid",myUserId);
        intent.putExtra("enemyid",enemyId);
        intent.putExtra("myscore",myScore);
        intent.putExtra("enemyscore",enemyScore);
        intent.putExtra("iswinning",isWinning);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(BattleResultActivity.this);
        setDataLayar();
    }

    private void setDataLayar() {
        String userId = getIntent().getStringExtra("userid");
        String enemyId = getIntent().getStringExtra("enemyid");
        mPresenter.getUserData(userId,enemyId);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_battle_result);
    }

    @Override
    public void setBattleResultView(User user, User user2) {
        Log.d(TAG, "setBattleResultView: " + user.toString() + "||" + user2.toString());
//        binding.setMyUser(user);
//        binding.setEnemyUser(user2);


        Integer myscore = getIntent().getIntExtra("myscore",0);
        Integer enemyscore = getIntent().getIntExtra("enemyscore",0);
        boolean isWinning =  getIntent().getBooleanExtra("iswinning",false);

//        binding.tvMyScore.setText(myscore.toString());
//        binding.tvEnemyScore.setText(enemyscore.toString());

        Log.d(TAG, "setBattleResultView: " + String.format("%d || %d || %d || %d || %s",user.getId(),user2.getId(),myscore,enemyscore,isWinning));

        String winningText = isWinning ? "Selamat anda menang" : "Maaf anda kalah";
//        binding.tvWinningStatus.setText(winningText);
        ((TextView) findViewById(R.id.tv_winning_status)).setText(winningText);

    }
}
