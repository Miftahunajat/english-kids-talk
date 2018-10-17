package com.squishydev.setoz.englishkidstalk.ui.inventory;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.data.network.model.ItemCategory;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityInventoryBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;

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

    FrameLayout frameLayout;

    Item bagianTopi;
    Item bagianAtas;
    Item bagianCelana;
    Item bagianSepatu;

    ImageView ivTopi;
    ImageView ivAtas;
    ImageView ivCelana;
    ImageView ivSepatu;
    private FrameLayout.LayoutParams layoutParams;


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
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inventory);
        setupBottomMenu();
        setupSideMenu();
        setupAvatar();
    }

    private void setupAvatar() {
        frameLayout = binding.flContentAvatar;
        layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
        );
        ivTopi = new ImageView(this);
        ivAtas = new ImageView(this);
        ivCelana = new ImageView(this);
        ivSepatu = new ImageView(this);
        frameLayout.addView(ivTopi,layoutParams);
        frameLayout.addView(ivAtas,layoutParams);
        frameLayout.addView(ivCelana,layoutParams);
        frameLayout.addView(ivSepatu,layoutParams);
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
    public void onClick(Item item) {
        if (item.getItemCategoryId() == 1) {
            bagianTopi = item;
            Picasso.get().load(item.getImage()).into(loadPissacco(ivTopi));
        }
        else if (item.getItemCategoryId() == 2) {
            bagianAtas = item;
            Picasso.get().load(item.getImage()).into(loadPissacco(ivAtas));
        }
        else if (item.getItemCategoryId() == 3) {
            bagianCelana = item;
            Picasso.get().load(item.getImage()).into(loadPissacco(ivCelana));
        }
        else if (item.getItemCategoryId() == 4) {
            bagianSepatu = item;
            Picasso.get().load(item.getImage()).into(loadPissacco(ivSepatu));
        }


    }

    interface OnSidebarUpdateListener{
        void onSidebarUpdate(List<Item> items);
    }

    Target loadPissacco(ImageView view){
        return new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                view.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
    }

}

interface OnBottomUpdateListener{
    void onBottomUpdate(List<ItemCategory> itemCategories);
}
