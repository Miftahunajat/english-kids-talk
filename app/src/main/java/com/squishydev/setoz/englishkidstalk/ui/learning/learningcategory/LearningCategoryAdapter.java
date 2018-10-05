package com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.databinding.ItemLearningCategoryBinding;

import java.util.List;

/**
 * Created by miftahun on 9/29/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class LearningCategoryAdapter extends RecyclerView.Adapter<LearningCategoryAdapter.LearningCategoryVH> {

    private List<LearningCategory> learningCategories;
    ItemLearningCategoryBinding binding;
    OnCategoryClick onCategoryClick;

    public LearningCategoryAdapter(List<LearningCategory> learningCategories,OnCategoryClick onCategoryClick) {
        this.learningCategories = learningCategories;
        this.onCategoryClick = onCategoryClick;
    }

    @NonNull
    @Override
    public LearningCategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = DataBindingUtil.inflate(inflater, R.layout.item_learning_category,parent,false);
        return new LearningCategoryVH(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull LearningCategoryVH holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return learningCategories.size();
    }

    public void addAll(List<LearningCategory> list){
        learningCategories.addAll(list);
    }

    class LearningCategoryVH extends RecyclerView.ViewHolder {

        public LearningCategoryVH(View itemView) {
            super(itemView);
        }

        public void bind(int position) {
            binding.setLearningCategory(learningCategories.get(position));
            binding.ivIcon.setOnClickListener(view -> {
                onCategoryClick.onClick(position);
            });
        }
    }

    interface OnCategoryClick{
        void onClick(int position);
    }
}
