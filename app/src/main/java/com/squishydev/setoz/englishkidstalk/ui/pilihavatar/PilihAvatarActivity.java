package com.squishydev.setoz.englishkidstalk.ui.pilihavatar;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityPilihAvatarBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.buatakun.BuatAkunActivity;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunActivity;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.LevelSelectActivity;
import com.squishydev.setoz.englishkidstalk.utils.AnimationUtil;
import com.squishydev.setoz.englishkidstalk.utils.AvatarControl;

import javax.inject.Inject;

public class PilihAvatarActivity extends BaseActivity implements PilihAvatarMvpView {

    @Inject
    PilihAvatarMvpPresenter<PilihAvatarMvpView> mPresenter;
    AvatarControl avatarControl;

    ActivityPilihAvatarBinding binding;

    int avatars[] = {R.drawable.cowok,R.drawable.cewek};
    String avatarName[] = {"Male","Female"};
    int indexAvatar = 0;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, PilihAvatarActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(PilihAvatarActivity.this);

        animate();
    }

    private void animate() {
        binding.btnPrevAvatar.startAnimation(AnimationUtil.getInstance(this).getTranslationAnimation(100,AnimationUtil.LEFT));
        binding.btnNextAvatar.startAnimation(AnimationUtil.getInstance(this).getTranslationAnimation(100,AnimationUtil.RIGHT));
        binding.flAvatar.startAnimation(AnimationUtil.getInstance(this).getTranslationAnimation(100,AnimationUtil.UP));
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();

    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_pilih_avatar);

        avatarControl = new AvatarControl(this,binding.flAvatar);
        changeAvatarToCowok();

        binding.btnMasuk.setOnClickListener(view -> {
            mPresenter.saveAvatar(indexAvatar);
            Intent intent = new Intent(PilihAvatarActivity.this, BuatAkunActivity.class);
            startActivity(intent);
        });
    }

    public void gantiAvatar(View view) {
        indexAvatar++;
        indexAvatar%=2;
        binding.ivAvatar.setImageDrawable(ContextCompat.getDrawable(this,avatars[indexAvatar]));
        binding.tvNamaAvatar.setText(avatarName[indexAvatar]);
        if (indexAvatar == 0){
            changeAvatarToCowok();
        }else {
            changeAvatarToCewek();
        }
    }

    void changeAvatarToCowok(){
        binding.ivAvatar.setVisibility(View.INVISIBLE);
        avatarControl.changeBaju(R.drawable.baju_cowok);
        avatarControl.changeCelana(R.drawable.celana_cowok);
        avatarControl.changeSepatu(R.drawable.sepatu_cowok);
        binding.ivAvatar.setVisibility(View.VISIBLE);
    }

    void changeAvatarToCewek(){
        binding.ivAvatar.setVisibility(View.INVISIBLE);
        avatarControl.changeBaju(R.drawable.baju_cewek);
        avatarControl.changeCelana(R.drawable.celana_cewek);
        avatarControl.changeSepatu(R.drawable.sepatu_cewek);
        binding.ivAvatar.setVisibility(View.VISIBLE);
    }
}
