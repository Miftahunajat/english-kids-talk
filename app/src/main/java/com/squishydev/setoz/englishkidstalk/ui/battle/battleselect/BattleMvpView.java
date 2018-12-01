package com.squishydev.setoz.englishkidstalk.ui.battle.battleselect;

import com.squishydev.setoz.englishkidstalk.data.firebase.model.Match;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

import java.util.List;

public interface BattleMvpView extends MvpView {

    void addLog(String key);

    void addMyScore(Integer score);

    void addEnemyScore(Integer score);

    void loadJoinFragment(User user);

    void loadJoinFragment(User ally, User enemy);

    void updateMatch(List<Match> matches);

    void updateJoinFragment(User user1);

    void loadBattleMatchActivity(String matchesId, String userId, String enemyId);
}
