package com.squishydev.setoz.englishkidstalk.ui.battle.battleselect;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.FragmentBattleJoinBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BattleJoinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BattleJoinFragment extends BaseFragment implements BattleJoinCallback {

    FragmentBattleJoinBinding binding;
    User user;
    private BattleJoinInteractor interactor;

    public BattleJoinFragment() {
        // Required empty public constructor
    }
    public static BattleJoinFragment newInstance(User user) {
        BattleJoinFragment fragment = new BattleJoinFragment();
        Bundle args = new Bundle();
        args.putSerializable("user",user);
        fragment.setArguments(args);
        return fragment;
    }

    public static BattleJoinFragment newInstance(User ally, User enemy) {
        BattleJoinFragment fragment = new BattleJoinFragment();
        Bundle args = new Bundle();
        args.putSerializable("ally",ally);
        args.putSerializable("enemy",enemy);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        interactor = (BattleJoinInteractor) getBaseActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_battle_join,container,false);
        if (getArguments().getSerializable("ally") != null ){
            setAlly((User) getArguments().getSerializable("ally"));
            setEnemy((User) getArguments().getSerializable("enemy"));
        }else{
            user = (User) getArguments().getSerializable("user");
            int profil = user.getGender() == 0 ? R.drawable.avatar_cowok_profile_bulat : R.drawable.avatar_cewek_profile_bulat;
            binding.ivUser.setVisibility(View.VISIBLE);
            binding.ivUser.setImageDrawable(ContextCompat.getDrawable(getContext(),profil));
            binding.setUser(user);
        }

        binding.button.setOnClickListener(v -> interactor.startMatch());
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }


    @Override
    public void setEnemy(User user) {
        binding.setMusuh(user);
        binding.ivMusuh.setVisibility(View.VISIBLE);
        int profil = user.getGender() == 0 ? R.drawable.avatar_cowok_profile_bulat : R.drawable.avatar_cewek_profile_bulat;
        binding.ivMusuh.setImageDrawable(ContextCompat.getDrawable(getContext(),profil));
    }

    void setAlly(User user){
        binding.setUser(user);
        binding.ivUser.setVisibility(View.VISIBLE);
        int profil = user.getGender() == 0 ? R.drawable.avatar_cowok_profile_bulat : R.drawable.avatar_cewek_profile_bulat;
        binding.ivUser.setImageDrawable(ContextCompat.getDrawable(getContext(),profil));
    }

    @Override
    protected void setUp(View view) {

    }

    interface BattleJoinInteractor{
        void startMatch();
    }
}
