package com.squishydev.setoz.englishkidstalk.ui.splashscreen;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashScreenPresenter<V extends SplashScreenMvpView> extends BasePresenter<V>
        implements SplashScreenMvpPresenter<V> {

    private static final String TAG = "SplashScreenPresenter";

    @Inject
    public SplashScreenPresenter(DataManager dataManager,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
