package com.squishydev.setoz.englishkidstalk.ui.battle;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityBattleBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;

import javax.inject.Inject;

public class BattleActivity extends BaseActivity implements BattleMvpView {

    @Inject
    BattleMvpPresenter<BattleMvpView> mPresenter;
    ActivityBattleBinding binding;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, BattleActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(BattleActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_battle);
        binding.btnHost.setOnClickListener(v-> mPresenter.postMatchOnline());
        binding.btnJoin.setOnClickListener(v -> mPresenter.joinRandomMatch());
        binding.btnJoinNow.setOnClickListener(v -> mPresenter.joinMatch());
        binding.btnAddScore.setOnClickListener(v -> mPresenter.addMyScore(1));
    }

    @Override
    public void addLog(String key) {
        binding.tvLog.setText(binding.tvLog.getText() + "\n" + key);
    }

    @Override
    public void addMyScore(Integer score) {
        binding.tvMine.setText("My Score : " + score.toString());
    }

    @Override
    public void addEnemyScore(Integer score) {
        binding.tvEnemy.setText("Enemy Score : " + score.toString());
    }
}
