package com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityKonfirmasiAkunBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.LevelSelectActivity;

import javax.inject.Inject;

public class KonfirmasiAkunActivity extends BaseActivity implements KonfirmasiAkunMvpView {

    @Inject
    KonfirmasiAkunMvpPresenter<KonfirmasiAkunMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, KonfirmasiAkunActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(KonfirmasiAkunActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        ActivityKonfirmasiAkunBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_konfirmasi_akun);
        binding.tvTidak.setOnClickListener(v -> {
            startActivity(new Intent(KonfirmasiAkunActivity.this, LevelSelectActivity.class));
        });
        binding.btnIya.setOnClickListener(v -> {
            startActivity(new Intent(KonfirmasiAkunActivity.this, BuatAkunActivity.class));
        });
    }
}
