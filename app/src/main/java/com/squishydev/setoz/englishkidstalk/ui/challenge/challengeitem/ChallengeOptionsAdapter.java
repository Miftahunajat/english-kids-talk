package com.squishydev.setoz.englishkidstalk.ui.challenge.challengeitem;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.AnswersItem;
import com.squishydev.setoz.englishkidstalk.databinding.ItemAnswerOptionBinding;

import java.util.ArrayList;
import java.util.List;

public class ChallengeOptionsAdapter extends RecyclerView.Adapter<ChallengeOptionsAdapter.ChallengeOptionVH> {

    private List<AnswersItem> answersItems;
    ItemAnswerOptionBinding binding;
    private OnItemClick onItemClick;
    private Context context;

    public ChallengeOptionsAdapter(List<AnswersItem> answersItems, OnItemClick onItemClick, Context context) {
        this.answersItems = answersItems;
        this.onItemClick = onItemClick;
        this.context = context;
    }

    @NonNull
    @Override
    public ChallengeOptionVH onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = DataBindingUtil.inflate(inflater, R.layout.item_answer_option, parent,false);
        return new ChallengeOptionVH(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeOptionVH challengeOptionVH, int i) {
        challengeOptionVH.bind(i);
    }

    @Override
    public int getItemCount() {
        return answersItems.size();
    }

    public void addAll(List<AnswersItem> list) {
        answersItems.addAll(list);
        notifyDataSetChanged();
    }

    class ChallengeOptionVH extends RecyclerView.ViewHolder {

        private ItemAnswerOptionBinding binding;

        public ChallengeOptionVH(View itemView, ItemAnswerOptionBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        public void bind(int position) {
            AnswersItem answersItem = answersItems.get(position);
            binding.setAnswerItem(answersItem);
            binding.btnAnswerItem.setOnClickListener(view -> {
                binding.executePendingBindings();
                onItemClick.onClick(position);
            });
        }
    }

    interface OnItemClick{
        void onClick(int position);
    }
}
