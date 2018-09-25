package com.squishydev.setoz.englishkidstalk.ui.inputnama;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class InputNamaPresenter<V extends InputNamaMvpView> extends BasePresenter<V>
        implements InputNamaMvpPresenter<V> {

    private static final String TAG = "InputNamaPresenter";

    @Inject
    public InputNamaPresenter(DataManager dataManager,
                              CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
