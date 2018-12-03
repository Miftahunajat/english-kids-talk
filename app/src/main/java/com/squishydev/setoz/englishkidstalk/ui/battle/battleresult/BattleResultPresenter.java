package com.squishydev.setoz.englishkidstalk.ui.battle.battleresult;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BattleResultPresenter<V extends BattleResultMvpView> extends BasePresenter<V>
        implements BattleResultMvpPresenter<V> {

    private static final String TAG = "BattleResultPresenter";

    @Inject
    public BattleResultPresenter(DataManager dataManager,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
