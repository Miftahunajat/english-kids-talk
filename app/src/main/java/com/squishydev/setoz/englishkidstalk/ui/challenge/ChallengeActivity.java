package com.squishydev.setoz.englishkidstalk.ui.challenge;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityChallengeBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChalengeItemFragment;

import javax.inject.Inject;

public class ChallengeActivity extends BaseActivity implements ChallengeMvpView {

    @Inject
    ChallengeMvpPresenter<ChallengeMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ChallengeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        ActivityChallengeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_challenge);
        ChalengeItemFragment fragment = ChalengeItemFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }
}
