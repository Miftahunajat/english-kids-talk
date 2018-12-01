package com.squishydev.setoz.englishkidstalk.di.componen;


import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.di.module.ActivityModule;
import com.squishydev.setoz.englishkidstalk.ui.battle.BattleActivity;
import com.squishydev.setoz.englishkidstalk.ui.buatakun.BuatAkunActivity;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengeActivity;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChalengeItemAFragment;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaActivity;
import com.squishydev.setoz.englishkidstalk.ui.inventory.InventoryActivity;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.LearningItemActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking.LearningSpeakingActivity;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting.LearningWritingActivity;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.fragment.LevelSelectFragment;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.itemstoremenu.ItemStoreFragment;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuFragment;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.profilemenu.ProfileFragment;
import com.squishydev.setoz.englishkidstalk.ui.pilihavatar.PilihAvatarActivity;
import com.squishydev.setoz.englishkidstalk.ui.splashscreen.SplashScreenActivity;

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

    void inject(SplashScreenActivity splashScreenActivity);

    void inject(PilihAvatarActivity pilihAvatarActivity);

    void inject(InputNamaActivity inputNamaActivity);

    void inject(KonfirmasiAkunActivity konfirmasiAkunActivity);

    void inject(ItemStoreFragment itemStoreFragment);

    void inject(MainMenuFragment mainMenuFragment);

    void inject(ProfileFragment profileFragment);

    void inject(LevelSelectFragment levelSelectFragmentFragment);

    void inject(LearningCategoryActivity learningCategoryActivity);

    void inject(LearningItemActivity learningItemActivity);

    void inject(ChallengeActivity challengeActivity);

    void inject(ChalengeItemAFragment chalengeItemFragment);

    void inject(BuatAkunActivity buatAkunActivity);

    void inject(InventoryActivity inventoryActivity);

    void inject(LearningSpeakingActivity learningSpeakingActivity);

    void inject(LearningWritingActivity learningWritingActivity);

    void inject(BattleActivity battleActivity);
}