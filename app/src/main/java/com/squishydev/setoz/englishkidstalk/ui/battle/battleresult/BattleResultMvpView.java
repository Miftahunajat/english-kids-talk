package com.squishydev.setoz.englishkidstalk.ui.battle.battleresult;

import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

public interface BattleResultMvpView extends MvpView {

    void setBattleResultView(User user, User user2);
}
