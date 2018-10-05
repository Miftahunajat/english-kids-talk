package com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ChalengeItemPresenter<V extends ChalengeItemMvpView> extends BasePresenter<V>
        implements ChalengeItemMvpPresenter<V> {

    private static final String TAG = "ChalengeItemPresenter";

    @Inject
    public ChalengeItemPresenter(DataManager dataManager,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
