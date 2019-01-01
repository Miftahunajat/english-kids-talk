package com.squishydev.setoz.englishkidstalk.ui.dashboard.homemenu;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V>
        implements HomeMvpPresenter<V> {

    private static final String TAG = "HomePresenter";

    @Inject
    public HomePresenter(DataManager dataManager,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        String id = getDataManager().getUserId();
        getCompositeDisposable().add(getDataManager().getUser(id)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(user -> {
            getMvpView().setUser(user);
        },this::baseHandleError));
    }

    @Override
    public void clearCache() {
        getDataManager().clearPreferenceData();
    }
}
