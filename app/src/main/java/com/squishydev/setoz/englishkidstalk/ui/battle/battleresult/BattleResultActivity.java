package com.squishydev.setoz.englishkidstalk.ui.battle.battleresult;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityBattleResultBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;

import javax.inject.Inject;

public class BattleResultActivity extends BaseActivity implements BattleResultMvpView {

    @Inject
    BattleResultMvpPresenter<BattleResultMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, BattleResultActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(BattleResultActivity.this);
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
}
