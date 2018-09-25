package com.squishydev.setoz.englishkidstalk.di.componen;


import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.di.module.ActivityModule;
<<<<<<< HEAD
import com.squishydev.setoz.englishkidstalk.ui.buatAkun.BuatAkunActivity;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaActivity;
=======
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaActivity;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunActivity;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.fragment.LevelSelectFragment;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu.ItemStoreFragment;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuFragment;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu.ProfileFragment;
import com.squishydev.setoz.englishkidstalk.ui.pilihavatar.PilihAvatarActivity;
import com.squishydev.setoz.englishkidstalk.ui.splashscreen.SplashScreenActivity;
>>>>>>> cedef8f54a54247d77537ea610273c5a91fb8cd7

import dagger.Component;

/**
 * Created by miftahun on 6/11/18.
 * <p>
 * Author Miftahun Najat
 * Email miftahunajat@gmail.com
 * Github https://github.com/miftahunajat
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(InputNamaActivity inputNamaActivity);

    void inject(BuatAkunActivity buatAkunActivity);

    void inject(SplashScreenActivity splashScreenActivity);

    void inject(PilihAvatarActivity pilihAvatarActivity);

    void inject(InputNamaActivity inputNamaActivity);

    void inject(KonfirmasiAkunActivity konfirmasiAkunActivity);

    void inject(ItemStoreFragment itemStoreFragment);

    void inject(MainMenuFragment mainMenuFragment);

    void inject(ProfileFragment profileFragment);

    void inject(LevelSelectFragment levelSelectFragmentFragment);
}
