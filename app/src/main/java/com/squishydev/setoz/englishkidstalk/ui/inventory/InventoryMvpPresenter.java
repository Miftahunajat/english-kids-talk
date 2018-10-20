package com.squishydev.setoz.englishkidstalk.ui.inventory;

import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface InventoryMvpPresenter<V extends InventoryMvpView> extends MvpPresenter<V> {

    void getMyInventory();

    void updateCategorySelection(int position);

    void getItemCategories();

    void updateItem(Item[] oldItem, Item[] newItem);
}

