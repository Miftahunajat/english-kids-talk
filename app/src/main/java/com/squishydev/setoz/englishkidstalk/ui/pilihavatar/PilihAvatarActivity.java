package com.squishydev.setoz.englishkidstalk.ui.pilihavatar;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityPilihAvatarBinding;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunActivity;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.LevelSelectActivity;

public class PilihAvatarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPilihAvatarBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_pilih_avatar);
        binding.btnMasuk.setOnClickListener(v ->{
            startActivity(new Intent(PilihAvatarActivity.this,KonfirmasiAkunActivity.class));
        });
    }

}
