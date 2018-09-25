package com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ProfilePresenter<V extends ProfileMvpView> extends BasePresenter<V>
        implements ProfileMvpPresenter<V> {

    private static final String TAG = "ProfilePresenter";

    @Inject
    public ProfilePresenter(DataManager dataManager,
                            CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
