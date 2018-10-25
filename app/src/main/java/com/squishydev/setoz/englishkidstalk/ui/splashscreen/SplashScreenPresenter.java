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

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

    }

    @Override
    public void checkUserLoggedInMode() {
        if (getDataManager().getLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER_LOGIN.getType()){
            getMvpView().openLevelSelectActivity();
        }else {
            getMvpView().openInputNamaActivity();
        }
    }
}
