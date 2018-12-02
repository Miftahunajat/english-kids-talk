package com.squishydev.setoz.englishkidstalk.ui.battle.battleresult;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityBattleResultBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;

import javax.inject.Inject;

public class BattleResultActivity extends BaseActivity implements BattleResultMvpView {

    @Inject
    BattleResultMvpPresenter<BattleResultMvpView> mPresenter;

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
        ActivityBattleResultBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_battle_result);
    }

    @Override
    public void setBattleResultView(User user, User user2) {

    }
}
