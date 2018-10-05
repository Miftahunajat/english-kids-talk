package com.squishydev.setoz.englishkidstalk.ui.menuselect;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.MenuItem;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityMenuSelectBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu.ItemStoreFragment;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuFragment;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu.ProfileFragment;
import com.squishydev.setoz.englishkidstalk.ui.pilihavatar.PilihAvatarActivity;

public class MenuSelectActivity extends BaseActivity{

    private TextView mTextMessage;
    private FragmentManager fm;
    BottomNavigationView navigation;
    private Difficulty mDifficulty;
    ActivityMenuSelectBinding binding;



    public static Intent getStartIntent(Context context, Difficulty difficulty) {
        Intent intent = new Intent(context, MenuSelectActivity.class);
        intent.putExtra("difficulty",difficulty);
        return intent;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    navigation.setBackgroundColor(ContextCompat.getColor(MenuSelectActivity.this,R.color.bottomProfile));
                    ProfileFragment profileFragment = new ProfileFragment();
                    fm.beginTransaction()
                            .replace(R.id.fl_fragment,profileFragment)
                            .commit();
                    return true;
                case R.id.navigation_study:
                    navigation.setBackgroundColor(ContextCompat.getColor(MenuSelectActivity.this,R.color.bottomNavigation));
                    MainMenuFragment mainFragment = MainMenuFragment.newInstance(mDifficulty);
                    fm.beginTransaction()
                            .replace(R.id.fl_fragment,mainFragment)
                            .commit();
                    return true;
                case R.id.navigation_store:
                    navigation.setBackgroundColor(ContextCompat.getColor(MenuSelectActivity.this,R.color.bottomProfile));
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
        navigation = binding.navigation;
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setBackgroundColor(ContextCompat.getColor(this,R.color.bottomNavigation));
        navigation.setSelectedItemId(R.id.navigation_study);
    }

    @Override
    protected void setUp() {


    }
}
