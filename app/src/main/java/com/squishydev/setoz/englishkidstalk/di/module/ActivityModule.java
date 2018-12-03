package com.squishydev.setoz.englishkidstalk.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.squishydev.setoz.englishkidstalk.di.ActivityContext;
import com.squishydev.setoz.englishkidstalk.ui.battle.battlematch.BattleMatchMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.battle.battlematch.BattleMatchMvpView;
import com.squishydev.setoz.englishkidstalk.ui.battle.battlematch.BattleMatchPresenter;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleresult.BattleResultMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleresult.BattleResultMvpView;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleresult.BattleResultPresenter;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleselect.BattleMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleselect.BattleMvpView;
import com.squishydev.setoz.englishkidstalk.ui.battle.battleselect.BattlePresenter;
import com.squishydev.setoz.englishkidstalk.ui.buatakun.BuatAkunMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.buatakun.BuatAkunMvpView;
import com.squishydev.setoz.englishkidstalk.ui.buatakun.BuatAkunPresenter;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengeMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengeMvpView;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengePresenter;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.homemenu.HomeMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.homemenu.HomeMvpView;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.homemenu.HomePresenter;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.itemstoremenu.ItemStoreMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.itemstoremenu.ItemStoreMvpView;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.itemstoremenu.ItemStorePresenter;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaMvpView;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaPresenter;
import com.squishydev.setoz.englishkidstalk.ui.inventory.InventoryMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.inventory.InventoryMvpView;
import com.squishydev.setoz.englishkidstalk.ui.inventory.InventoryPresenter;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunMvpView;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryMvpView;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.LearningItemMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.LearningItemMvpView;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.LearningItemPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking.LearningSpeakingMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking.LearningSpeakingMvpView;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking.LearningSpeakingPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting.LearningWritingMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting.LearningWritingMvpView;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting.LearningWritingPresenter;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.fragment.LevelSelectMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.fragment.LevelSelectMvpView;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.fragment.LevelSelectPresenter;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuMvpView;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuPresenter;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.profilemenu.ProfileMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.profilemenu.ProfileMvpView;
import com.squishydev.setoz.englishkidstalk.ui.dashboard.profilemenu.ProfilePresenter;
import com.squishydev.setoz.englishkidstalk.ui.pilihavatar.PilihAvatarMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.pilihavatar.PilihAvatarMvpView;
import com.squishydev.setoz.englishkidstalk.ui.pilihavatar.PilihAvatarPresenter;
import com.squishydev.setoz.englishkidstalk.ui.splashscreen.SplashScreenMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.splashscreen.SplashScreenMvpView;
import com.squishydev.setoz.englishkidstalk.ui.splashscreen.SplashScreenPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by miftahun on 6/11/18.
 * <p>
 * Author Miftahun Najat
 * Email miftahunajat@gmail.com
 * Github https://github.com/miftahunajat
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    LevelSelectMvpPresenter<LevelSelectMvpView> provideLevelSelectPresenter(LevelSelectPresenter<LevelSelectMvpView> presenter) {
        return presenter;
    }

    @Provides
    ProfileMvpPresenter<ProfileMvpView> provideProfilePresenter(ProfilePresenter<ProfileMvpView> presenter) {
        return presenter;
    }

    @Provides
    MainMenuMvpPresenter<MainMenuMvpView> provideMainMenuPresenter(MainMenuPresenter<MainMenuMvpView> presenter) {
        return presenter;
    }

    @Provides
    ItemStoreMvpPresenter<ItemStoreMvpView> provideItemStorePresenter(ItemStorePresenter<ItemStoreMvpView> presenter) {
        return presenter;
    }

    @Provides
    KonfirmasiAkunMvpPresenter<KonfirmasiAkunMvpView> provideKonfirmasiAkunPresenter(KonfirmasiAkunPresenter<KonfirmasiAkunMvpView> presenter) {
        return presenter;
    }

    @Provides
    InputNamaMvpPresenter<InputNamaMvpView> provideInputNamaPresenter(InputNamaPresenter<InputNamaMvpView> presenter) {
        return presenter;
    }

    @Provides
    PilihAvatarMvpPresenter<PilihAvatarMvpView> providePilihAvatarPresenter(PilihAvatarPresenter<PilihAvatarMvpView> presenter) {
        return presenter;
    }

    @Provides
    SplashScreenMvpPresenter<SplashScreenMvpView> provideSplashScreenPresenter(SplashScreenPresenter<SplashScreenMvpView> presenter) {
        return presenter;
    }

    @Provides
    LearningCategoryMvpPresenter<LearningCategoryMvpView> provideLearningCategoryPresenter(LearningCategoryPresenter<LearningCategoryMvpView> presenter) {
        return presenter;
    }

    @Provides
    LearningItemMvpPresenter<LearningItemMvpView> provideLearningItemPresenter(LearningItemPresenter<LearningItemMvpView> presenter) {
        return presenter;
    }

    @Provides
    ChallengeMvpPresenter<ChallengeMvpView> provideChallengePresenter(ChallengePresenter<ChallengeMvpView> presenter) {
        return presenter;
    }

    @Provides
    BuatAkunMvpPresenter<BuatAkunMvpView> provideBuatAkunPresenter(BuatAkunPresenter<BuatAkunMvpView> presenter) {
        return presenter;
    }

    @Provides
    InventoryMvpPresenter<InventoryMvpView> provideInventoryPresenter(InventoryPresenter<InventoryMvpView> presenter) {
        return presenter;
    }

    @Provides
    LearningSpeakingMvpPresenter<LearningSpeakingMvpView> provideLearningSpeakingPresenter(LearningSpeakingPresenter<LearningSpeakingMvpView> presenter) {
        return presenter;
    }

    @Provides
    LearningWritingMvpPresenter<LearningWritingMvpView> provideLearningWritingPresenter(LearningWritingPresenter<LearningWritingMvpView> presenter) {
        return presenter;
    }

    @Provides
    BattleMvpPresenter<BattleMvpView> provideBattlePresenter(BattlePresenter<BattleMvpView> presenter) {
        return presenter;
    }

    @Provides
    HomeMvpPresenter<HomeMvpView> provideHomePresenter(HomePresenter<HomeMvpView> presenter) {
        return presenter;
    }

    BattleMatchMvpPresenter<BattleMatchMvpView> provideBattleMatchPresenter(BattleMatchPresenter<BattleMatchMvpView> presenter) {
        return presenter;
    }

    @Provides
    BattleResultMvpPresenter<BattleResultMvpView> provideBattleResultPresenter(BattleResultPresenter<BattleResultMvpView> presenter) {
        return presenter;
    }
}
