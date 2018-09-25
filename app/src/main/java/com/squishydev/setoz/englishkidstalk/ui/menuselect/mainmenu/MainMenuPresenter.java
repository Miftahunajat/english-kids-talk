package com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainMenuPresenter<V extends MainMenuMvpView> extends BasePresenter<V>
        implements MainMenuMvpPresenter<V> {

    private static final String TAG = "MainMenuPresenter";

    @Inject
    public MainMenuPresenter(DataManager dataManager,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
