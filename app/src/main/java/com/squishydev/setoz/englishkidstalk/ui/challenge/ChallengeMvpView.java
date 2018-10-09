package com.squishydev.setoz.englishkidstalk.ui.challenge;

import com.squishydev.setoz.englishkidstalk.data.model.Challenge;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

import java.util.List;

public interface ChallengeMvpView extends MvpView {

    void setupChallenges(List<Challenge> challenges);
}
