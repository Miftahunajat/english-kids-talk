package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.data.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.databinding.ItemLearningCategoryBinding;
import com.squishydev.setoz.englishkidstalk.databinding.ItemLearningItemBinding;

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

    public LearningItemAdapter(List<LearningItem> learningItems, OnItemClick onItemClick) {
        this.learningItems = learningItems;
        this.onItemClick = onItemClick;
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
    }

    class LearningItemVH extends RecyclerView.ViewHolder {

        private ItemLearningItemBinding binding;

        public LearningItemVH(View itemView,ItemLearningItemBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        public void bind(int position) {
            Log.d("Lala","lala");
            binding.setLearningItem(learningItems.get(position));


            binding.btnSubmit.setOnClickListener(view -> {
                binding.executePendingBindings();
                onItemClick.onClick(position);
            });
        }
    }

    interface OnItemClick{
        void onClick(int position);
    }
}
