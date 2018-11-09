package com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu;

import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface ItemStoreMvpPresenter<V extends ItemStoreMvpView> extends MvpPresenter<V> {

    void getAllItem();

    void getItemPercategories(int categoryId);

    void getUser();

    void buyItem(Item item);
}

