package com.squishydev.setoz.englishkidstalk.ui.inputnama;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityInputNamaBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.pilihavatar.PilihAvatarActivity;

import javax.inject.Inject;

public class InputNamaActivity extends BaseActivity implements InputNamaMvpView {

    @Inject
    InputNamaMvpPresenter<InputNamaMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, InputNamaActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(InputNamaActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        final ActivityInputNamaBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_input_nama);
        binding.btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = binding.etNama;
                mPresenter.simpanNama(nama);
                startActivity(new Intent(InputNamaActivity.this, PilihAvatarActivity.class));
            }
        });
    }
}
