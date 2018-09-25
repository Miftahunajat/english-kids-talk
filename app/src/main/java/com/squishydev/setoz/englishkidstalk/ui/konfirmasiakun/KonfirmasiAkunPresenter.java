package com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class KonfirmasiAkunPresenter<V extends KonfirmasiAkunMvpView> extends BasePresenter<V>
        implements KonfirmasiAkunMvpPresenter<V> {

    private static final String TAG = "KonfirmasiAkunPresenter";

    @Inject
    public KonfirmasiAkunPresenter(DataManager dataManager,
                                   CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
