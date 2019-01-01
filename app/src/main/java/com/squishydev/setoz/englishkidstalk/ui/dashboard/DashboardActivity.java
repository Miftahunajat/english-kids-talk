package com.squishydev.setoz.englishkidstalk.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityDashboardBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleselect.BattleActivity;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.homemenu.HomeFragment;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.itemstoremenu.ItemStoreFragment;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.profilemenu.ProfileFragment;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.MenuSelectActivity;

public class DashboardActivity extends BaseActivity {

    ActivityDashboardBinding binding;
    MediaPlayer tone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
//        binding.ivProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ProfileFragment profileFragment = new ProfileFragment();
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fl_dashboard,profileFragment)
//                        .commit();
//            }
//        });

        setContentView(R.layout.activity_dashboard);

        HomeFragment homeFragment = HomeFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_dashboard,homeFragment)
                .commit();
        setBottomNavigation();
    }

    private void setBottomNavigation() {
        AHBottomNavigationItem profile = new AHBottomNavigationItem("Profile", R.drawable.profil, R.color.categoryEasy);
        AHBottomNavigationItem home = new AHBottomNavigationItem("Home", R.drawable.home, R.color.categoryMedium);
        AHBottomNavigationItem store = new AHBottomNavigationItem("Store", R.drawable.store, R.color.brownVeryHard);

        binding.bottomNavigation.addItem(profile);
        binding.bottomNavigation.addItem(home);
        binding.bottomNavigation.addItem(store);

        binding.bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        // Disable the translation inside the CoordinatorLayout
        binding.bottomNavigation.setBehaviorTranslationEnabled(false);

// Enable the translation of the FloatingActionButton
//        binding.bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);

// Change colors
        binding.bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        binding.bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

// Force to tint the drawable (useful for font with icon for example)
        binding.bottomNavigation.setForceTint(true);

// Display color under navigation bar (API 21+)
// Don't forget these lines in your style-v21
// <item name="android:windowTranslucentNavigation">true</item>
// <item name="android:fitsSystemWindows">true</item>
        binding.bottomNavigation.setTranslucentNavigationEnabled(true);

// Manage titles
        binding.bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        binding.bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        binding.bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);

// Use colored navigation with circle reveal effect
        binding.bottomNavigation.setColored(true);

// Set current item programmatically
        binding.bottomNavigation.setCurrentItem(1);

// Customize notification (title, background, typeface)
        binding.bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

// Enable / disable item & set disable color
        binding.bottomNavigation.enableItemAtPosition(2);
        binding.bottomNavigation.disableItemAtPosition(2);
        binding.bottomNavigation.setItemDisableColor(Color.parseColor("#3A000000"));

// Set listeners
        binding.bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...
                return true;
            }
        });
        binding.bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                // Manage the new y position
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tone = MediaPlayer.create(DashboardActivity.this, R.raw.backsound);
        tone.setLooping(true);
        tone.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        tone.stop();
    }

    @Override
    protected void setUp() {

    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DashboardActivity.class);
        return intent;
    }

    public void openBasic(View view) {
        Intent intent = MenuSelectActivity.getStartIntent(this, Difficulty.DIFFICULTY_EASY);
        startActivity(intent);
    }

    public void openIntermediate(View view) {
        Intent intent = MenuSelectActivity.getStartIntent(this, Difficulty.DIFFICULTY_MEDIUM);
        startActivity(intent);
    }

    public void openAdvance(View view) {
        Intent intent = MenuSelectActivity.getStartIntent(this, Difficulty.DIFFICULTY_HARD);
        startActivity(intent);
    }

    public void openBattle(View view) {
        Intent intent = BattleActivity.getStartIntent(this);
        startActivity(intent);
    }

    public void openProfile(View view) {
        ProfileFragment profileFragment = new ProfileFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_dashboard,profileFragment)
                .commit();
    }

    public void openStore(View view) {
        ItemStoreFragment itemStoreFragment = new ItemStoreFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_dashboard,itemStoreFragment)
                .commit();
    }

    public void openHome(View view) {
        HomeFragment homeFragment = HomeFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_dashboard,homeFragment)
                .commit();
    }
}
