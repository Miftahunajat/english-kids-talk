package com.squishydev.setoz.englishkidstalk.ui.battle.battlematch;

import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

import java.util.List;

public interface BattleMatchMvpView extends MvpView {

    void updateScore(String myUser, String enemyId);

    void setDataChallenges(List<Challenge> challenges);

}
