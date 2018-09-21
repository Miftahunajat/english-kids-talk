package com.squishydev.setoz.englishkidstalk.ui.menuselect;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityLevelSelectBinding;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityMenuSelectBinding;

public class MenuSelectActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private FragmentManager fm;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    fm.beginTransaction()
                            .replace(R.id.fl_fragment,null)
                            .commit();
                    return true;
                case R.id.navigation_study:
                    fm.beginTransaction()
                            .replace(R.id.fl_fragment,null)
                            .commit();
                    return true;
                case R.id.navigation_store:
                    fm.beginTransaction()
                            .replace(R.id.fl_fragment,null)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMenuSelectBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_menu_select);
        fm = getSupportFragmentManager();

        BottomNavigationView navigation = binding.navigation;
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
