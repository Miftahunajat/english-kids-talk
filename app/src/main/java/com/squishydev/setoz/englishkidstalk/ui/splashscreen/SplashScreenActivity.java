package com.squishydev.setoz.englishkidstalk.ui.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
=======
>>>>>>> e37e61ee07b2796b98901c7299eb4ad98fdfa2fb

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.databinding.ActivitySplashScreenBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaActivity;

<<<<<<< HEAD
public class SplashScreenActivity extends AppCompatActivity {
//private TextView tv;
//private ImageView iv;
=======
import javax.inject.Inject;

public class SplashScreenActivity extends BaseActivity implements SplashScreenMvpView {

    @Inject
    SplashScreenMvpPresenter<SplashScreenMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashScreenActivity.class);
        return intent;
    }

>>>>>>> e37e61ee07b2796b98901c7299eb4ad98fdfa2fb
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_splash_screen);
<<<<<<< HEAD
       // binding.imageView16.setOnClickListener(view -> {
          //  startActivity(new Intent(SplashScreenActivity.this, InputNamaActivity.class));
//        });


=======
        binding.imageView16.setOnClickListener(view -> {
            startActivity(new Intent(SplashScreenActivity.this, InputNamaActivity.class));
        });
        binding.imageView14.setOnClickListener(view -> {
            startActivity(new Intent(SplashScreenActivity.this, InputNamaActivity.class));
        });

        getActivityComponent().inject(this);

        mPresenter.onAttach(SplashScreenActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
>>>>>>> e37e61ee07b2796b98901c7299eb4ad98fdfa2fb

    }

}
