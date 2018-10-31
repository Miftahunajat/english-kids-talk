package com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningTopicsItem;
import com.squishydev.setoz.englishkidstalk.databinding.ItemLearningCategoryBinding;

import java.util.List;

public class LearningCategoryAdapter2 extends RecyclerView.Adapter<LearningCategoryAdapter2.LearningCategory2VH> {
    private List<LearningTopicsItem> learningTopicsItems;
    ItemLearningCategoryBinding binding;
    LearningCategoryAdapter.OnCategoryClick onCategoryClick;

    public LearningCategoryAdapter2(List<LearningTopicsItem> learningTopicsItems,LearningCategoryAdapter.OnCategoryClick onCategoryClick) {
        this.learningTopicsItems = learningTopicsItems;
        this.onCategoryClick = onCategoryClick;
    }

    @NonNull
    @Override
    public LearningCategoryAdapter2.LearningCategory2VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = DataBindingUtil.inflate(inflater, R.layout.item_learning_category,parent,false);
        return new LearningCategoryAdapter2.LearningCategory2VH(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull LearningCategoryAdapter2.LearningCategory2VH holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return learningTopicsItems.size();
    }

    public void addAll(List<LearningTopicsItem> list){
        learningTopicsItems.addAll(list);
        notifyDataSetChanged();
    }

    class LearningCategory2VH extends RecyclerView.ViewHolder {

        public LearningCategory2VH(View itemView) {
            super(itemView);
        }

        public void bind(int position) {
            binding.setLearningTopicsItem(learningTopicsItems.get(position));
            binding.ivIcon.setOnClickListener(view -> {
                onCategoryClick.onClick(position);
            });
        }
    }

    interface OnCategoryClick{
        void onClick(int position);
    }
}
