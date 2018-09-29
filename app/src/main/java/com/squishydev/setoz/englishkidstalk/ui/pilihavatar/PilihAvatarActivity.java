package com.squishydev.setoz.englishkidstalk.ui.pilihavatar;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityPilihAvatarBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunActivity;

import javax.inject.Inject;

public class PilihAvatarActivity extends BaseActivity implements PilihAvatarMvpView {

    @Inject
    PilihAvatarMvpPresenter<PilihAvatarMvpView> mPresenter;

    int indexAvatar = 0;
    int avatars[] = {R.drawable.cewek,R.drawable.cowok};
    String namaAvatar[] = {"Female","Male"};

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, PilihAvatarActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(PilihAvatarActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        ActivityPilihAvatarBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_pilih_avatar);

        binding.btnNextAvatar.setOnClickListener(v ->{
            indexAvatar++;
            indexAvatar%=2;
            binding.avatar.setImageDrawable(ContextCompat.getDrawable(PilihAvatarActivity.this,avatars[indexAvatar]));
            binding.tvNamaAvatar.setText(namaAvatar[indexAvatar]);
        });

        binding.btnPrevAvatar.setOnClickListener(view -> {
            indexAvatar++;
            indexAvatar%=2;
            binding.avatar.setImageDrawable(ContextCompat.getDrawable(PilihAvatarActivity.this,avatars[indexAvatar]));
            binding.tvNamaAvatar.setText(namaAvatar[indexAvatar]);
        });

        binding.btnMasuk.setOnClickListener(v ->{
            startActivity(new Intent(PilihAvatarActivity.this,KonfirmasiAkunActivity.class));
        });
    }
}
