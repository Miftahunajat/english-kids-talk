package com.squishydev.setoz.englishkidstalk.ui.inventory;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentSideNavigationInvetoryItemBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChalengeItemAFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SideNavigationInvetoryItem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SideNavigationInvetoryItem extends BaseFragment implements InventoryActivity.OnSidebarUpdateListener {

    FragmentSideNavigationInvetoryItemBinding binding;
    InventoryItemAdapter adapter;
    List<Item> items = new ArrayList<>();

    public static SideNavigationInvetoryItem newInstance() {
        Bundle args = new Bundle();
        SideNavigationInvetoryItem fragment = new SideNavigationInvetoryItem();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_side_navigation_invetory_item, container, false);

        adapter = new InventoryItemAdapter(items, (InventoryItemAdapter.OnItemClick) getBaseActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        binding.rvItem.setLayoutManager(linearLayoutManager);
        binding.rvItem.setAdapter(adapter);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onSidebarUpdate(List<Item> items) {
        adapter.addAll(items);
    }

    @Override
    protected void setUp(View view) {

    }
}
