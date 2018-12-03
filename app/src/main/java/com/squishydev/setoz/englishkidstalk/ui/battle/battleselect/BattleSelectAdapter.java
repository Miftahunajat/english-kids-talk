package com.squishydev.setoz.englishkidstalk.ui.battle.battleselect;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.firebase.model.Match;
import com.squishydev.setoz.englishkidstalk.databinding.ItemBattleSelectBinding;

import java.util.List;

public class BattleSelectAdapter extends RecyclerView.Adapter<BattleSelectAdapter.BattleSelectVH> {
    private static final String TAG = "bude";
    private List<Match> matches;
    private ItemBattleSelectBinding binding;
    private OnBattlePlayerClick onBattlePlayerClick;

    public BattleSelectAdapter(List<Match> matches, OnBattlePlayerClick onBattlePlayerClick) {
        this.matches = matches;
        this.onBattlePlayerClick = onBattlePlayerClick;
    }

    @NonNull
    @Override
    public BattleSelectVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = DataBindingUtil.inflate(inflater, R.layout.item_battle_select,parent,false);
        return new BattleSelectVH(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BattleSelectVH holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }


    public void swap(List<Match> matchesData) {
        matches = matchesData;
        notifyDataSetChanged();
    }

    class BattleSelectVH extends RecyclerView.ViewHolder {

        public BattleSelectVH(View itemView) {
            super(itemView);
        }

        public void bind(int position) {
            binding.setMatch(matches.get(position));
            binding.btnJoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    binding.executePendingBindings();
                    onBattlePlayerClick.onClick(position);
                }
            });
        }
    }

    interface OnBattlePlayerClick {
        void onClick(int position);
    }
}
