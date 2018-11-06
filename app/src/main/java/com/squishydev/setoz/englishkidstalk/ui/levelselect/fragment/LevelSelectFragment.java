package com.squishydev.setoz.englishkidstalk.ui.levelselect.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.q42.android.scrollingimageview.ScrollingImageView;
import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.MenuSelectActivity;

import javax.inject.Inject;

public class LevelSelectFragment extends BaseFragment implements
        LevelSelectMvpView {

    private static final String TAG = "LevelSelectFragment";
    private int mIndex = 0;

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int[] mLayouts = {R.layout.fragment_level_select_easy,
            R.layout.fragment_level_select_medium,
            R.layout.fragment_level_select_hard};

    @Inject
    LevelSelectMvpPresenter<LevelSelectMvpView> mPresenter;

    public static LevelSelectFragment newInstance(int sectionNumber) {
        LevelSelectFragment fragment = new LevelSelectFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mIndex = getArguments().getInt(ARG_SECTION_NUMBER);
        View view = inflater.inflate(mLayouts[mIndex], container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }


        return view;
    }

    @Override
    protected void setUp(View view) {
        Button btnPlay = view.findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(v -> {
            if (mIndex == 0) {
                Intent intent = MenuSelectActivity.getStartIntent(getContext(), Difficulty.DIFFICULTY_EASY);
                ((ScrollingImageView) view.findViewById(R.id.scroll_image_view)).start();
                getContext().startActivity(intent);
            }else if (mIndex == 1) {
                Intent intent = MenuSelectActivity.getStartIntent(getContext(), Difficulty.DIFFICULTY_MEDIUM);
                getContext().startActivity(intent);
            }else{
                Intent intent = MenuSelectActivity.getStartIntent(getContext(), Difficulty.DIFFICULTY_HARD);
                getContext().startActivity(intent);
            }

        });
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }



}

