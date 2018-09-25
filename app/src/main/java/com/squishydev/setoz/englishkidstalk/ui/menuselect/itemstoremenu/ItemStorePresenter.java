package com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ItemStorePresenter<V extends ItemStoreMvpView> extends BasePresenter<V>
        implements ItemStoreMvpPresenter<V> {

    private static final String TAG = "ItemStorePresenter";

    @Inject
    public ItemStorePresenter(DataManager dataManager,
                              CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

}
