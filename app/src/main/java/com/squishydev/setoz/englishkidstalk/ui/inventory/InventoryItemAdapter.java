package com.squishydev.setoz.englishkidstalk.ui.inventory;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.databinding.ItemInventoryItemBinding;

import java.util.List;

/**
 * Created by miftahun on 10/15/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class InventoryItemAdapter extends RecyclerView.Adapter<InventoryItemAdapter.InventoryItemVH> {
    private List<Item> items;
    ItemInventoryItemBinding binding;
    OnItemClick onItemClick;

    public InventoryItemAdapter(List<Item> items, OnItemClick onItemClick) {
        this.items = items;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public InventoryItemVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = DataBindingUtil.inflate(inflater, R.layout.item_inventory_item,parent,false);
        return new InventoryItemVH(binding.getRoot(),binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryItemVH holder, int position) {
        holder.bind(position);
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addAll(List<Item> list){
        items.clear();
        items.addAll(list);
        notifyDataSetChanged();
    }

    class InventoryItemVH extends RecyclerView.ViewHolder {

        private ItemInventoryItemBinding binding;

        public InventoryItemVH(View itemView, ItemInventoryItemBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        public void bind(int position) {
            binding.setItem(items.get(position));


            binding.content.setOnClickListener(view -> {
                binding.executePendingBindings();
                onItemClick.onClick(items.get(position));
            });
        }
    }

    interface OnItemClick{
        void onClick(Item item);
    }
}
