package com.squishydev.setoz.englishkidstalk.ui.challenge;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ChallengePresenter<V extends ChallengeMvpView> extends BasePresenter<V>
        implements ChallengeMvpPresenter<V> {

    private static final String TAG = "ChallengePresenter";

    @Inject
    public ChallengePresenter(DataManager dataManager,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }
    
}
