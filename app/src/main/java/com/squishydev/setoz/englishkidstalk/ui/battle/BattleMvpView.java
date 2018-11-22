package com.squishydev.setoz.englishkidstalk.ui.battle;

import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

public interface BattleMvpView extends MvpView {

    void addLog(String key);

    void addMyScore(Integer score);

    void addEnemyScore(Integer score);
}
