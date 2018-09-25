package com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;

import javax.inject.Inject;

public class ItemStoreFragment extends BaseFragment implements
        ItemStoreMvpView {

    private static final String TAG = "ItemStoreFragment";

    @Inject
    ItemStoreMvpPresenter<ItemStoreMvpView> mPresenter;

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
        View view = inflater.inflate(R.layout.fragment_item_store, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {

    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}

