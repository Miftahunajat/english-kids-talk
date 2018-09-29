package com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;

import javax.inject.Inject;

public class MainMenuFragment extends BaseFragment implements
        MainMenuMvpView {

    private static final String TAG = "MainMenuFragment";

    @Inject
    MainMenuMvpPresenter<MainMenuMvpView> mPresenter;

    public static MainMenuFragment newInstance() {
        Bundle args = new Bundle();
        MainMenuFragment fragment = new MainMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
            Log.d("Presenter","Not null");
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

