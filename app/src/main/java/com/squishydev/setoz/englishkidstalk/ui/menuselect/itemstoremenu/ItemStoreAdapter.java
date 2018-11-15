package com.squishydev.setoz.englishkidstalk.ui.menuselect.itemstoremenu;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningTopicsItem;
import com.squishydev.setoz.englishkidstalk.databinding.ItemLearningCategoryBinding;
import com.squishydev.setoz.englishkidstalk.databinding.ItemViewStoreBinding;

import java.util.List;

/**
 * Created by miftahun on 9/29/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class ItemStoreAdapter extends RecyclerView.Adapter<ItemStoreAdapter.ItemStoreVH> {

    private List<Item> item;
    ItemViewStoreBinding binding;
    OnItemClick onItemClick;

    public ItemStoreAdapter(List<Item> item,OnItemClick onItemClick) {
        this.item = item;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ItemStoreVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = DataBindingUtil.inflate(inflater, R.layout.item_view_store,parent,false);
        return new ItemStoreVH(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ItemStoreVH holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public void addAll(List<Item> list){
        item.addAll(list);
        notifyDataSetChanged();
    }

    class ItemStoreVH extends RecyclerView.ViewHolder {

        public ItemStoreVH(View itemView) {
            super(itemView);
        }

        public void bind(int position) {
            binding.setItem(item.get(position));

        }
    }

    interface OnItemClick{
        void onClick(int position);
    }
}
