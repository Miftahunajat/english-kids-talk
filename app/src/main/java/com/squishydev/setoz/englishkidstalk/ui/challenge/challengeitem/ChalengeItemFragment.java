package com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;

import javax.inject.Inject;

public class ChalengeItemFragment extends BaseFragment implements
        ChalengeItemMvpView {

    private static final String TAG = "ChalengeItemFragment";

    @Inject
    ChalengeItemMvpPresenter<ChalengeItemMvpView> mPresenter;

    public static ChalengeItemFragment newInstance() {
        Bundle args = new Bundle();
        ChalengeItemFragment fragment = new ChalengeItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge_item, container, false);

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

