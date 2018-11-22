package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.ItemLearningItemBinding;
import com.squishydev.setoz.englishkidstalk.utils.MediaUtils;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.List;

/**
 * Created by miftahun on 9/29/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class LearningItemAdapter extends RecyclerView.Adapter<LearningItemAdapter.LearningItemVH> {

    private List<LearningItem> learningItems;
    ItemLearningItemBinding binding;
    OnItemClick onItemClick;
    private String userId;
    private Context context;

    public LearningItemAdapter(Context context, List<LearningItem> learningItems, OnItemClick onItemClick,String userId) {
        this.learningItems = learningItems;
        this.onItemClick = onItemClick;
        this.userId = userId;
        this.context = context;
    }

    @NonNull
    @Override
    public LearningItemVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = DataBindingUtil.inflate(inflater, R.layout.item_learning_item,parent,false);
        return new LearningItemVH(binding.getRoot(),binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningItemVH holder, int position) {
        holder.bind(position);
    }



    @Override
    public int getItemCount() {
        return learningItems.size();
    }

    public void addAll(List<LearningItem> list){
        learningItems.addAll(list);
        notifyDataSetChanged();
    }

    void updateLearned(int position, User user){
    }

    class LearningItemVH extends RecyclerView.ViewHolder {

        private ItemLearningItemBinding binding;

        public LearningItemVH(View itemView,ItemLearningItemBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        public void bind(int position) {
            LearningItem learningItem = learningItems.get(position);
            binding.setLearningItem(learningItem);
            if (learningItem.getUserCompleteStatus(userId)){
            }


            binding.cvIcon.setOnClickListener(view -> {
                binding.executePendingBindings();
                onItemClick.onClick(position);
            });

            binding.easyFlipView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    binding.easyFlipView.flipTheView();

                }
            });
            binding.easyFlipView.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
                @Override
                public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                    if (newCurrentSide == EasyFlipView.FlipState.BACK_SIDE) {
                        binding.easyFlipView.setFlipEnabled(false);
                        onItemClick.onFlipSound(position);
//                        onItemClick.onClick(position);
                    }
                }
            });
        }
    }

    interface OnItemClick{
        void onClick(int position);

        void answer(String answerUser, String correctAnswer, int position);

        void onFlipSound(int position);
    }
}
