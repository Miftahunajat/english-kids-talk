package com.squishydev.setoz.englishkidstalk.ui.battle;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BattlePresenter<V extends BattleMvpView> extends BasePresenter<V>
        implements BattleMvpPresenter<V> {

    private static final String TAG = "BattlePresenter";

    @Inject
    public BattlePresenter(DataManager dataManager,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
