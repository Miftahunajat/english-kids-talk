package com.squishydev.setoz.englishkidstalk.ui.battle.battleselect;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.firebase.model.Match;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityBattleBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.battle.battlematch.BattleMatchActivity;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

import javax.inject.Inject;

public class BattleActivity extends BaseActivity implements BattleMvpView,
        BattleSelectFragment.BattleSelectInteractor,
        BattleJoinFragment.BattleJoinInteractor {

    private static final String TAG = "@@@";
    @Inject
    BattleMvpPresenter<BattleMvpView> mPresenter;
    ActivityBattleBinding binding;
    BattleSelectCallback battleSelectCallback;
    BattleJoinCallback battleJoinCallback;
    private boolean IS_JOINED = false;
    private boolean IS_HOST = false;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, BattleActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(BattleActivity.this);
        loadSelectFragment();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_battle);

        loadSelectFragment();
    }

    @Override
    public void addLog(String key) {
        showMessage(key);
    }

    @Override
    public void addMyScore(Integer score) {
    }

    @Override
    public void addEnemyScore(Integer score) {
    }

    void loadSelectFragment(){
        IS_JOINED = false;
        Fragment battleSelect = BattleSelectFragment.newInstance();
        battleSelectCallback = (BattleSelectCallback) battleSelect;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_content,battleSelect)
                .commit();
    }

    @Override
    public void loadJoinFragment(User user){
        IS_JOINED = true;
        Fragment battleJoin = BattleJoinFragment.newInstance(user);
        battleJoinCallback  = (BattleJoinCallback) battleJoin;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_content,battleJoin)
                .commit();
        IS_HOST = true;
    }

    @Override
    public void loadJoinFragment(User ally, User enemy){
        IS_JOINED = true;
        Log.d(TAG, "loadJoinFragment: " + ally + "||" + enemy);
        Fragment battleJoin = BattleJoinFragment.newInstance(ally,enemy);
        battleJoinCallback  = (BattleJoinCallback) battleJoin;
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content,battleJoin).commit();
    }

    @Override
    public void updateMatch(List<Match> matches) {
        Log.d(TAG, "updateMatch: " + matches.toString());
        battleSelectCallback.setMatchesData(matches);;
    }

    @Override
    public void updateJoinFragment(User user1) {
        battleJoinCallback.setEnemy(user1);
    }

    @Override
    public void loadBattleMatchActivity(String matchesId,String userId,String enemyId) {
        Intent intent = BattleMatchActivity.getStartIntent(this,matchesId,userId,enemyId);
        startActivity(intent);
        finish();
    }

    @Override
    public void createMatch() {
        mPresenter.postMatchOnline();
    }

    @Override
    public void getMatches() {
        mPresenter.getAllMatches();
    }

    @Override
    public void joinMatch(Match matchId) {
        Log.d(TAG, "pakde joinMatch: " + matchId.toString());
        mPresenter.joinMatch(matchId);
    }

    @Override
    public void onBackPressed() {
        if (IS_JOINED) {
            loadSelectFragment();
            if (IS_HOST)
                mPresenter.deleteMatch();
        }
        else
            super.onBackPressed();
    }

    @Override
    public void startMatch() {
        mPresenter.startMatch();
    }

}

interface BattleSelectCallback{
    void setMatchesData(List<Match> matchesData);
}

interface BattleJoinCallback{
    void setEnemy(User user);
}