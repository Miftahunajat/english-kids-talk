package com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityKonfirmasiAkunBinding;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.LevelSelectActivity;
import com.squishydev.setoz.englishkidstalk.ui.buatAkun.BuatAkunActivity;
public class KonfirmasiAkunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityKonfirmasiAkunBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_konfirmasi_akun);
        binding.tvTidak.setOnClickListener(v -> {
            startActivity(new Intent(KonfirmasiAkunActivity.this, LevelSelectActivity.class));
        });
        binding.btnIya.setOnClickListener(v -> {
            startActivity(new Intent(KonfirmasiAkunActivity.this, BuatAkunActivity.class));
        });
    }
}
