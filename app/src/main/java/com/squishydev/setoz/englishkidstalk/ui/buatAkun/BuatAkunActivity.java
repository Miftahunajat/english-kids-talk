package com.squishydev.setoz.englishkidstalk.ui.buatAkun;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;

import javax.inject.Inject;

public class BuatAkunActivity extends BaseActivity implements BuatAkunMvpView {

    @Inject
    BuatAkunMvpPresenter<BuatAkunMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, BuatAkunActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_akun);

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
        ActivityBuatAkunBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_buat_akun);
    }
}
