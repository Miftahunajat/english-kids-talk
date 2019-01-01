package com.squishydev.setoz.englishkidstalk.ui.battle.battleresult;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityBattleResultBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.utils.MediaUtils;

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
        MediaUtils.playSound(this,R.raw.whistle);
    }

    private void setDataLayar() {
        String userId = getIntent().getStringExtra("userid");
        String enemyId = getIntent().getStringExtra("enemyid");
        mPresenter.getUserData(userId,enemyId);

        Integer myscore = getIntent().getIntExtra("myscore",0);
        Integer enemyscore = getIntent().getIntExtra("enemyscore",0);
        boolean isWinning =  getIntent().getBooleanExtra("iswinning",false);

        binding.tvMyScore.setText(myscore.toString());
        binding.tvEnemyScore.setText(enemyscore.toString());

        String winningText = isWinning ? "Selamat anda menang" : "Maaf anda kalah";
        String bintangText = isWinning ? "Anda mendapatkan 100 bintang" : "Anda kehilangan 100 bintang";

        ((TextView) findViewById(R.id.tv_winning_status)).setText(winningText);
        ((TextView) findViewById(R.id.tv_my_score)).setText(myscore.toString());
        ((TextView) findViewById(R.id.tv_enemy_score)).setText(enemyscore.toString());
        binding.tvBintangTotal.setText(bintangText);
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
    public void setBattleResultView(String myName, String enemyName) {

        ((TextView) findViewById(R.id.tv_my_username)).setText(myName);
        ((TextView) findViewById(R.id.tv_enemy_username)).setText(enemyName);
    }

    public void backBattle (View view){
        finish();
    }
}
