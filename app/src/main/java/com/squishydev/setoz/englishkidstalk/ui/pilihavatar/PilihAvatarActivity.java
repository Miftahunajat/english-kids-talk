package com.squishydev.setoz.englishkidstalk.ui.pilihavatar;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityPilihAvatarBinding;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunActivity;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.LevelSelectActivity;

public class PilihAvatarActivity extends AppCompatActivity {

    int indexAvatar = 0;
    int avatars[] = {R.drawable.cewek,R.drawable.cowok};
    String namaAvatar[] = {"Female","Male"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
