package com.squishydev.setoz.englishkidstalk.ui.buatakun;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityBuatAkunBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.LevelSelectActivity;

import javax.inject.Inject;

public class BuatAkunActivity extends BaseActivity implements BuatAkunMvpView {

    @Inject
    BuatAkunMvpPresenter<BuatAkunMvpView> mPresenter;

    ActivityBuatAkunBinding binding;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, BuatAkunActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(BuatAkunActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_buat_akun);
        setOnClickListener();
    }

    void setOnClickListener(){
        binding.btnRegister.setOnClickListener(view -> {
            Intent intent = LevelSelectActivity.getStartIntent(BuatAkunActivity.this);
            startActivity(intent);
        });
    }
}
