package com.squishydev.setoz.englishkidstalk.ui.inventory;

import android.util.Log;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class InventoryPresenter<V extends InventoryMvpView> extends BasePresenter<V>
        implements InventoryMvpPresenter<V> {

    private static final String TAG = "InventoryPresenter";
    Subject<Integer> mCurrentCategorySelection = PublishSubject.create();
    List<Item> listAtas = new ArrayList<>();
    List<Item> listTengah = new ArrayList<>();
    List<Item> listBawah = new ArrayList<>();


    @Inject
    public InventoryPresenter(DataManager dataManager,
                              CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
        getItemCategories();
        mCurrentCategorySelection.onNext(1);
        getMyInventory();
    }



    void observeCurrentCategorySelection(){
        getCompositeDisposable().add(mCurrentCategorySelection
                .subscribe(integer -> {
                    if (integer == 1)
                        getMvpView().updateSidebarFragment(listAtas);
                    else if (integer == 2)
                        getMvpView().updateSidebarFragment(listTengah);
                    else if (integer == 3)
                        getMvpView().updateSidebarFragment(listBawah);
                },this::baseHandleError)
        );
    }


    @Override
    public void getMyInventory() {
        String id = getDataManager().getUserId();
        getCompositeDisposable().add(getDataManager().getInventory(id)
        .flatMap(inventory -> Observable.just(inventory.getItems()))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
                items -> {
                    for (Item item : items){
                        if (item.getItemCategoryId() == 1)
                            listAtas.add(item);
                        else if (item.getItemCategoryId() == 2)
                            listTengah.add(item);
                        else if (item.getItemCategoryId() == 3)
                            listBawah.add(item);
                    }
                    observeCurrentCategorySelection();
                },this::baseHandleError
        ));
    }

    @Override
    public void updateCategorySelection(int position) {
        mCurrentCategorySelection.onNext(position);
    }

    @Override
    public void activateSynchroSummon(Item item) {
        String id = getDataManager().getUserId();
        String itemId = String.valueOf(item.getId());
        getCompositeDisposable().add(getDataManager().activateItemInventory(id,itemId)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(
                inventory -> {

                },this::baseHandleError
        ));
    }

    @Override
    public void getItemCategories() {
        getCompositeDisposable().add(getDataManager().getItemCategory()
                .map(itemCategories -> {
                    Collections.reverse(itemCategories);
                    return itemCategories;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(itemCategories -> {
                    getMvpView().updateBottomBar(itemCategories);
                },this::baseHandleError
                        ));
    }
}
