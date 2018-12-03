package com.squishydev.setoz.englishkidstalk.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityDashboardBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.homemenu.HomeFragment;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleselect.BattleActivity;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.itemstoremenu.ItemStoreFragment;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.profilemenu.ProfileFragment;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.MenuSelectActivity;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuFragment;
import com.squishydev.setoz.englishkidstalk.ui.pilihavatar.PilihAvatarActivity;
import com.squishydev.setoz.englishkidstalk.ui.splashscreen.SplashScreenActivity;

public class DashboardActivity extends BaseActivity {

    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        binding.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment profileFragment = new ProfileFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_dashboard,profileFragment)
                        .commit();
            }
        });

        setContentView(R.layout.activity_dashboard);


        HomeFragment homeFragment = HomeFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_dashboard,homeFragment)
                .commit();
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
