package com.squishydev.setoz.englishkidstalk.ui.buatAkun;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BuatAkunPresenter<V extends BuatAkunMvpView> extends BasePresenter<V>
        implements BuatAkunMvpPresenter<V> {

    private static final String TAG = "BuatAkunPresenter";

    @Inject
    public BuatAkunPresenter(DataManager dataManager,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
