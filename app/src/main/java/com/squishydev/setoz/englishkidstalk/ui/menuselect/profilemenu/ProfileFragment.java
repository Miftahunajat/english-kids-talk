package com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.data.network.model.Inventory;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentProfileBinding;
import com.squishydev.setoz.englishkidstalk.di.componen.ActivityComponent;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;
import com.squishydev.setoz.englishkidstalk.ui.inventory.InventoryActivity;
import com.squishydev.setoz.englishkidstalk.utils.AvatarControl;

import javax.inject.Inject;

public class ProfileFragment extends BaseFragment implements
        ProfileMvpView {

    private static final String TAG = "ProfileFragment";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private int[] profiles = {R.drawable.cowok,R.drawable.cewek};

    FragmentProfileBinding binding;
    AvatarControl mAvatarControl;

    @Inject
    ProfileMvpPresenter<ProfileMvpView> mPresenter;

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false);


        mAvatarControl = new AvatarControl(getContext(),binding.flContentAvatar);



        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }

        int gender = mPresenter.getGender();
        if (gender == 0){
            binding.ivAvatarCircle.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.avatar_cowok_profile_bulat));
        }else{
            binding.ivAvatarCircle.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.avatar_cewek_profile_bulat));
        }

        return binding.getRoot();
    }

    @Override
    protected void setUp(View view) {

        binding.tvLihatAvatar.setOnClickListener(view1 -> {
            Intent intent = InventoryActivity.getStartIntent(getContext());
            startActivity(intent);
        });
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void updateProfile(User user) {
        binding.setUser(user);

        String xpGained = String.valueOf(user.getXpGained()%1000) + "/1000";
        binding.tvXpBar.setText(xpGained);
        adjustXpBar(user.getXpGained()%1000);

        //set jumlah level pada tv
        binding.tvJumlahLevel.setText(String.valueOf(user.getXpGained()/1000));
//        mAvatarControl.buildFromInventory(user.getInventory());
//        binding.ivAvatarPreview.setImageResource(profiles[user.getGender()]);
    }

    private void adjustXpBar(int xpGained) {
        if (xpGained != 0) {
            ViewGroup.LayoutParams params = binding.xpEmpty.getLayoutParams();
            ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(
                    (int) ((float) xpGained / 1000.f * (float) params.width),
                    (int) (params.height));
//        lp.leftMargin = (int) (14f * getBaseActivity().getResources().getDisplayMetrics().density);
            lp.bottomToBottom = R.id.xp_empty;
            lp.leftToLeft = R.id.xp_empty;
            lp.topToTop = R.id.xp_empty;

            binding.xpFill.setLayoutParams(lp);
        }else{
            binding.xpFill.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setAvatarFromInventory(int type, Inventory inventory) {
        if (type == 0)
            binding.ivAvatar.setImageDrawable(ContextCompat.getDrawable(getContext()
                    ,R.drawable.cowok));
        else
            binding.ivAvatar.setImageDrawable(ContextCompat.getDrawable(getContext()
                    ,R.drawable.cewek));
        mAvatarControl.buildFromInventory(inventory);
    }

    @Override
    public void updateRank(int position) {
        binding.tvJumlahPiala.setText(String.valueOf(position));
    }
}

