package com.squishydev.setoz.englishkidstalk.ui.levelselect;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentLevelSelectEasyBinding;

/**
 * Created by miftahun on 9/18/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class LevelSelectFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private int[] mLayouts = {R.layout.fragment_level_select_easy,
            R.layout.fragment_level_select_medium,
            R.layout.fragment_level_select_hard};

    public LevelSelectFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static LevelSelectFragment newInstance(int sectionNumber) {
        LevelSelectFragment fragment = new LevelSelectFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int index = getArguments().getInt(ARG_SECTION_NUMBER);
        FragmentLevelSelectEasyBinding binding = DataBindingUtil.inflate(inflater,mLayouts[index - 1],container,false);
        View rootView = binding.getRoot();
        return rootView;
    }
}
