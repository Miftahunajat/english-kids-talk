package com.squishydev.setoz.englishkidstalk.ui.inventory;

import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.data.network.model.ItemCategory;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

import java.util.List;

public interface InventoryMvpView extends MvpView {

    void updateSidebarFragment(List<Item> items);

    void updateBottomBar(List<ItemCategory> itemCategories);
}
