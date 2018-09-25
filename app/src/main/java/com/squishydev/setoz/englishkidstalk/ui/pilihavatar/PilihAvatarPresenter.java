package com.squishydev.setoz.englishkidstalk.ui.pilihavatar;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class PilihAvatarPresenter<V extends PilihAvatarMvpView> extends BasePresenter<V>
        implements PilihAvatarMvpPresenter<V> {

    private static final String TAG = "PilihAvatarPresenter";

    @Inject
    public PilihAvatarPresenter(DataManager dataManager,
                                CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
