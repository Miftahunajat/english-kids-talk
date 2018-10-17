package com.squishydev.setoz.englishkidstalk.ui.inventory;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.squareup.picasso.Picasso;
import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.ItemCategory;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentBottomNavigationItemCategoryBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BottomNavigationInventoryCategory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomNavigationInventoryCategory extends BaseFragment implements OnBottomUpdateListener {

    FragmentBottomNavigationItemCategoryBinding binding;
    ImageButton imageButtons[] = new ImageButton[3] ;
    CategoryChangeListener callback;


    public static BottomNavigationInventoryCategory newInstance() {
        Bundle args = new Bundle();
        BottomNavigationInventoryCategory fragment = new BottomNavigationInventoryCategory();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_bottom_navigation_item_category,container,false);
        imageButtons[0] = binding.ivCategoryAtas;
        imageButtons[1] = binding.ivCategoryTengah;
        imageButtons[2] = binding.ivCategoryBawah;

        setOnClickListeners();

        callback = (CategoryChangeListener) getBaseActivity();

        return binding.getRoot();
    }

    private void setOnClickListeners() {
        imageButtons[0].setOnClickListener(view -> {
            setCurrentCategory(1);
        });

        imageButtons[1].setOnClickListener(view -> {
            setCurrentCategory(2);
        });

        imageButtons[2].setOnClickListener(view -> {
            setCurrentCategory(3);
        });
    }

    private void setCurrentCategory(Integer tag) {
        callback.onCategoryChange(tag);
        for (ImageButton imageButton : imageButtons) {
            imageButton.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.bg_bottom_category_item));
        }
        imageButtons[tag - 1].setBackground(ContextCompat.getDrawable(getContext(),R.drawable.bg_bottom_category_item_selected));
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onBottomUpdate(List<ItemCategory> itemCategories) {
        Log.d("DEbug",itemCategories.toString());
        Picasso.get().load(itemCategories.get(0).getItemCategoryImage()).into(imageButtons[0]);
        Picasso.get().load(itemCategories.get(1).getItemCategoryImage()).into(imageButtons[1]);
        Picasso.get().load(itemCategories.get(2).getItemCategoryImage()).into(imageButtons[2]);
    }

    interface CategoryChangeListener{
        void onCategoryChange(int position);
    }
}
