package com.squishydev.setoz.englishkidstalk.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.squishydev.setoz.englishkidstalk.di.ActivityContext;
import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.buatakun.BuatAkunMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.buatakun.BuatAkunMvpView;
import com.squishydev.setoz.englishkidstalk.ui.buatakun.BuatAkunPresenter;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengeMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengeMvpView;
import com.squishydev.setoz.englishkidstalk.ui.challenge.ChallengePresenter;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChalengeItemMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChalengeItemMvpView;
import com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem.ChalengeItemPresenter;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaMvpView;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaPresenter;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunMvpView;
import com.squishydev.setoz.englishkidstalk.ui.konfirmasiakun.KonfirmasiAkunPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryMvpView;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory.LearningCategoryPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.LearningItemMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.LearningItemMvpView;
import com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.LearningItemPresenter;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.fragment.LevelSelectMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.fragment.LevelSelectMvpView;
import com.squishydev.setoz.englishkidstalk.ui.levelselect.fragment.LevelSelectPresenter;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu.ItemStoreMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu.ItemStoreMvpView;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu.ItemStorePresenter;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuMvpView;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.mainmenu.MainMenuPresenter;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu.ProfileMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu.ProfileMvpView;
import com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu.ProfilePresenter;
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
    LevelSelectMvpPresenter<LevelSelectMvpView> provideLevelSelectPresenter(LevelSelectPresenter<LevelSelectMvpView> presenter){
        return presenter;
    }

    @Provides
    ProfileMvpPresenter<ProfileMvpView> provideProfilePresenter(ProfilePresenter<ProfileMvpView> presenter){
        return presenter;
    }

    @Provides
    MainMenuMvpPresenter<MainMenuMvpView> provideMainMenuPresenter(MainMenuPresenter<MainMenuMvpView> presenter){
        return presenter;
    }

    @Provides
    ItemStoreMvpPresenter<ItemStoreMvpView> provideItemStorePresenter(ItemStorePresenter<ItemStoreMvpView> presenter){
        return presenter;
    }

    @Provides
    KonfirmasiAkunMvpPresenter<KonfirmasiAkunMvpView> provideKonfirmasiAkunPresenter(KonfirmasiAkunPresenter<KonfirmasiAkunMvpView> presenter){
        return presenter;
    }

    @Provides
    InputNamaMvpPresenter<InputNamaMvpView> provideInputNamaPresenter(InputNamaPresenter<InputNamaMvpView> presenter){
        return presenter;
    }

    @Provides
    PilihAvatarMvpPresenter<PilihAvatarMvpView> providePilihAvatarPresenter(PilihAvatarPresenter<PilihAvatarMvpView> presenter){
        return presenter;
    }

    @Provides
    SplashScreenMvpPresenter<SplashScreenMvpView> provideSplashScreenPresenter(SplashScreenPresenter<SplashScreenMvpView> presenter){
        return presenter;
    }

    @Provides
    LearningCategoryMvpPresenter<LearningCategoryMvpView> provideLearningCategoryPresenter(LearningCategoryPresenter<LearningCategoryMvpView> presenter){
        return presenter;
    }

    @Provides
    LearningItemMvpPresenter<LearningItemMvpView> provideLearningItemPresenter(LearningItemPresenter<LearningItemMvpView> presenter){
        return presenter;
    }

    @Provides
    ChallengeMvpPresenter<ChallengeMvpView> provideChallengePresenter(ChallengePresenter<ChallengeMvpView> presenter){
        return presenter;
    }

    @Provides
    ChalengeItemMvpPresenter<ChalengeItemMvpView> provideChalengeItemPresenter(ChalengeItemPresenter<ChalengeItemMvpView> presenter){
        return presenter;
    }

    @Provides
    BuatAkunMvpPresenter<BuatAkunMvpView> provideBuatAkunPresenter(BuatAkunPresenter<BuatAkunMvpView> presenter){
        return presenter;
    }
}
