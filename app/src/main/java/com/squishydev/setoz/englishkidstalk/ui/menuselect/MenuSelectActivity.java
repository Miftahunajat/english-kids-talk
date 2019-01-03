package com.squishydev.setoz.englishkidstalk.ui.menuselect;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;


import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityMenuSelectBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.homemenu.HomeFragment;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.itemstoremenu.ItemStoreFragment;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuFragment;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.profilemenu.ProfileFragment;

public class MenuSelectActivity extends BaseActivity{

    private FragmentManager fm;
    private Difficulty mDifficulty;
    ActivityMenuSelectBinding binding;



    public static Intent getStartIntent(Context context, Difficulty difficulty) {
        Intent intent = new Intent(context, MenuSelectActivity.class);
        intent.putExtra("difficulty",difficulty);
        return intent;
    }

    private AHBottomNavigation.OnTabSelectedListener mOnNavigationItemSelectedListener
            = new AHBottomNavigation.OnTabSelectedListener() {
        @Override
        public boolean onTabSelected(int position, boolean wasSelected) {
            switch (position){
                case 0:
                    ProfileFragment profileFragment = new ProfileFragment();
                    fm.beginTransaction()
                            .replace(R.id.fl_fragment,profileFragment)
                            .commit();
                    return true;
                case 1:
                    MainMenuFragment mainFragment = MainMenuFragment.newInstance(mDifficulty);
                    fm.beginTransaction()
                            .replace(R.id.fl_fragment,mainFragment)
                            .commit();
                    return true;
                case 2:
                    ItemStoreFragment itemStoreFragment = new ItemStoreFragment();
                    fm.beginTransaction()
                            .replace(R.id.fl_fragment,itemStoreFragment)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_menu_select);

        fm = getSupportFragmentManager();

        mDifficulty = (Difficulty) getIntent().getSerializableExtra("difficulty");

        AHBottomNavigation ahBottomNavigation = binding.navigation;
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("asdasd",ContextCompat.getDrawable(this,R.drawable.home_2),ContextCompat.getColor(this,R.color.categoryEasy));
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("aaaaa",R.drawable.study);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("qweqwe",R.drawable.store);
        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                MainMenuFragment mainFragment = MainMenuFragment.newInstance(mDifficulty);
                fm.beginTransaction()
                        .replace(R.id.fl_fragment,mainFragment)
                        .commit();
                return true;
            }
        });

        // Manage titles
        ahBottomNavigation.setInactiveColor(ContextCompat.getColor(this,R.color.white));
        ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);

        ahBottomNavigation.setTranslucentNavigationEnabled(true);
//        ahBottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);
        ahBottomNavigation.setOnTabSelectedListener(mOnNavigationItemSelectedListener);
        ahBottomNavigation.setCurrentItem(1);
        ahBottomNavigation.setDefaultBackgroundColor(ContextCompat.getColor(this,R.color.black_transparent));
    }

    @Override
    protected void setUp() {

    }

    public void backHome(View view) {
        finish();
    }
}
