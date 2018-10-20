package com.squishydev.setoz.englishkidstalk.ui.inputnama;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

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
        ActivityInputNamaBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_input_nama);
        binding.btnNext.setOnClickListener(v ->{
            binding.executePendingBindings();
            if (binding.etName.getText().toString().trim().equals("")){
                showMessage("Maaf nama tidak boleh kosong");
                return;
            }
            mPresenter.saveNama(binding.etName.getText().toString());
            startActivity(new Intent(InputNamaActivity.this, PilihAvatarActivity.class));
        });
    }
}
