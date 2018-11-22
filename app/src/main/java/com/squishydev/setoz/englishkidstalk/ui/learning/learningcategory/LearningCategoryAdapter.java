package com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningTopicsItem;
import com.squishydev.setoz.englishkidstalk.databinding.ItemLearningCategory2Binding;

import java.util.List;

public class LearningCategoryAdapter extends RecyclerView.Adapter<LearningCategoryAdapter.LearningCategory2VH> {
    private List<LearningTopicsItem> learningTopicsItems;
    private ItemLearningCategory2Binding binding;
    private LearningCategoryAdapter.OnCategoryClick onCategoryClick;

    public LearningCategoryAdapter(List<LearningTopicsItem> learningTopicsItems, LearningCategoryAdapter.OnCategoryClick onCategoryClick) {
        this.learningTopicsItems = learningTopicsItems;
        this.onCategoryClick = onCategoryClick;
    }

    @NonNull
    @Override
    public LearningCategoryAdapter.LearningCategory2VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = DataBindingUtil.inflate(inflater, R.layout.item_learning_category_2,parent,false);
        return new LearningCategoryAdapter.LearningCategory2VH(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull LearningCategoryAdapter.LearningCategory2VH holder, int position) {
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
            binding.setLearningTopic(learningTopicsItems.get(position));
            binding.ivBgKayu.setOnClickListener(v -> onCategoryClick.onClick(position));
        }
    }

    interface OnCategoryClick{
        void onClick(int position);
    }
}
