package com.squishydev.setoz.englishkidstalk.ui.levelselect.fragment;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LevelSelectPresenter<V extends LevelSelectMvpView> extends BasePresenter<V>
        implements LevelSelectMvpPresenter<V> {

    private static final String TAG = "LevelSelectPresenter";

    @Inject
    public LevelSelectPresenter(DataManager dataManager,
                                CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
