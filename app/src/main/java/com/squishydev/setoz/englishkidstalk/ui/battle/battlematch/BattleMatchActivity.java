package com.squishydev.setoz.englishkidstalk.ui.battle.battlematch;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityBattleMatchBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;

import javax.inject.Inject;

public class BattleMatchActivity extends BaseActivity implements BattleMatchMvpView {

    @Inject
    BattleMatchMvpPresenter<BattleMatchMvpView> mPresenter;

    ActivityBattleMatchBinding binding;

    public static Intent getStartIntent(Context context,String matchId) {
        Intent intent = new Intent(context, BattleMatchActivity.class);
        intent.putExtra("match",matchId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(BattleMatchActivity.this);
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
    }
}
