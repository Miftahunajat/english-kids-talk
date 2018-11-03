package com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu;

import android.app.LauncherActivity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentItemStoreBinding;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ItemStoreFragment extends BaseFragment implements
        ItemStoreMvpView, ItemStoreAdapter.OnItemClick
{

    private static final String TAG = "ItemStoreFragment";

    FragmentItemStoreBinding binding;

    @Inject
    ItemStoreMvpPresenter<ItemStoreMvpView> mPresenter;
    ItemStoreAdapter itemStoreAdapter;
    List<Item> itemList;


    public static ItemStoreFragment newInstance() {
        Bundle args = new Bundle();
        ItemStoreFragment fragment = new ItemStoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_store,container, false);
        itemList = new ArrayList<>();
        Item item = new Item();
        item.setName("koonam");
        item.setSnippet("gdyu");
        item.setStar(100);
        item.setImage("asd");
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);
        itemList.add(item);

        itemStoreAdapter = new ItemStoreAdapter(itemList, this);

        binding.rvItem.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.rvItem.setAdapter(itemStoreAdapter);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }
        return binding.getRoot();
    }

    @Override
    protected void setUp(View view) {

    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onClick(int position) {

    }
}

