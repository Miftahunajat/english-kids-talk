package com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu;

import android.util.Log;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ItemStorePresenter<V extends ItemStoreMvpView> extends BasePresenter<V>
        implements ItemStoreMvpPresenter<V> {

    private static final String TAG = "ItemStorePresenter";

    @Inject
    public ItemStorePresenter(DataManager dataManager,
                              CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getAllItem() {
        getCompositeDisposable().add(getDataManager().getAllItem()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(items -> getMvpView().setupItem(items),this::baseHandleError));
    }

    @Override
    public void getItemPercategories(int categoryId) {

    }

    @Override
    public void getUser() {
        String userId = getDataManager().getUserId();
        Log.d(TAG, "getUser: ");
        getCompositeDisposable().add(getDataManager().getUser(userId)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(
                user -> {
                    getMvpView().setUser(user);
                },this::baseHandleError
        ));
    }
}
