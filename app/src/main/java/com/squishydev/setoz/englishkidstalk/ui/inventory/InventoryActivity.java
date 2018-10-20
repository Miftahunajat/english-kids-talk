package com.squishydev.setoz.englishkidstalk.ui.inventory;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Inventory;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.data.network.model.ItemCategory;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityInventoryBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.utils.AvatarControl;

import java.util.List;

import javax.inject.Inject;


public class InventoryActivity extends BaseActivity implements InventoryMvpView,
        BottomNavigationInventoryCategory.CategoryChangeListener,
        InventoryItemAdapter.OnItemClick{

    @Inject
    InventoryMvpPresenter<InventoryMvpView> mPresenter;

    ActivityInventoryBinding binding;

    OnSidebarUpdateListener callback;

    OnBottomUpdateListener bottomCallback;

    AvatarControl avatarControl;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, InventoryActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(InventoryActivity.this);
    }

    @Override
    protected void onDestroy() {
        Item[] oldItem = avatarControl.getOldItem();
        Item[] newItem = avatarControl.getNewItem();
        if (newItem != null)
            mPresenter.updateItem(oldItem,newItem);
        else
            mPresenter.onDetach();

        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inventory);
        setupBottomMenu();
        setupSideMenu();
        avatarControl = new AvatarControl(this,binding.flContentAvatar);
    }

    private void setupSideMenu() {
        Fragment fragment = SideNavigationInvetoryItem.newInstance();
        callback = (OnSidebarUpdateListener) fragment;
        getSupportFragmentManager().beginTransaction()
                .replace(binding.flSide.getId(),fragment)
                .commit();
    }

    private void setupBottomMenu() {
        Fragment fragment = BottomNavigationInventoryCategory.newInstance();
        bottomCallback = (OnBottomUpdateListener) fragment;
        getSupportFragmentManager().beginTransaction()
                .replace(binding.flBottom.getId(),fragment)
                .commit();
    }

    @Override
    public void onCategoryChange(int position) {
        mPresenter.updateCategorySelection(position);
    }

    @Override
    public void updateSidebarFragment(List<Item> items) {
        callback.onSidebarUpdate(items);
    }

    @Override
    public void updateBottomBar(List<ItemCategory> itemCategories) {
        bottomCallback.onBottomUpdate(itemCategories);
    }

    @Override
    public void setAvatarFromInventory(int type, Inventory inventory) {
        if (type == 0)
            binding.ivAvatar.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.cowok));
        else
            binding.ivAvatar.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.cewek));
        Log.d("KEpanggil","Kepanggil");
        avatarControl.buildFromInventory(inventory);
    }

    @Override
    public void onClick(Item item) {
        if (item.getItemCategoryId() == 1) {
            avatarControl.changeTopi(item);
        }
        else if (item.getItemCategoryId() == 2) {
            avatarControl.changeBaju(item);
        }
        else if (item.getItemCategoryId() == 3) {
            avatarControl.changeCelana(item);
        }
        else if (item.getItemCategoryId() == 4) {
            avatarControl.changeSepatu(item);
        }


    }

    interface OnSidebarUpdateListener{
        void onSidebarUpdate(List<Item> items);
    }



}

interface OnBottomUpdateListener{
    void onBottomUpdate(List<ItemCategory> itemCategories);
}
