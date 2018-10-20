package com.squishydev.setoz.englishkidstalk.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import com.squishydev.setoz.englishkidstalk.data.network.model.Inventory;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by miftahun on 10/19/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class AvatarControl {
    private Context mContext;
    private FrameLayout mFrameLayout;
    private ImageView ivTopi;
    private ImageView ivBody;
    private ImageView ivCelana;
    private ImageView ivSepatu;
    FrameLayout.LayoutParams layoutParams;
    private Item[] oldItem = new Item[4];
    private Item[] newItem = new Item[4];

    public AvatarControl(Context context, FrameLayout frameLayout){
        this.mContext = context;
        this.mFrameLayout = frameLayout;
        ivTopi = new ImageView(context);
        ivBody = new ImageView(context);
        ivCelana = new ImageView(context);
        ivSepatu = new ImageView(context);

        layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
        );
        frameLayout.addView(ivTopi,layoutParams);
        frameLayout.addView(ivBody,layoutParams);
        frameLayout.addView(ivCelana,layoutParams);
        frameLayout.addView(ivSepatu,layoutParams);
    }

    public void changeTopi(Item item){
        newItem[0] = item;
        Picasso.get().load(item.getImage()).into(ivTopi);
    }

    public void changeBaju(Item item){
        newItem[1] = item;
        Picasso.get().load(item.getImage()).into(ivBody);
    }

    public void changeCelana(Item item){
        newItem[2] = item;
        Picasso.get().load(item.getImage()).into(ivCelana);
    }

    public void changeSepatu(Item item){
        newItem[3] = item;
        Picasso.get().load(item.getImage()).into(ivSepatu);
    }

    public void changeTopi(int drawable){
        Picasso.get().load(drawable).into(ivTopi);
    }

    public void changeBaju(int drawable){
        ivBody.setImageDrawable(ContextCompat.getDrawable(mContext,drawable));
    }

    public void changeCelana(int drawable){
        ivCelana.setImageDrawable(ContextCompat.getDrawable(mContext,drawable));
    }

    public void changeSepatu(int drawable){
        ivSepatu.setImageDrawable(ContextCompat.getDrawable(mContext,drawable));
    }

    public void buildFromInventory(Inventory inventory){
        oldItem = inventory.getActiveItems().toArray(new Item[4]);
        wearOldItem();
    }



    public Item[] getOldItem(){
        List<Item> nonNull = new ArrayList<>();
        for (int i = 0; i < oldItem.length; i++) {
            if (oldItem[i] != null)
                nonNull.add(oldItem[i]);
        }
        return nonNull.toArray(new Item[nonNull.size()]);
    }

    public Item[] getNewItem(){
        List<Item> nonNull = new ArrayList<>();
        for (int i = 0; i < newItem.length; i++) {
            if (newItem[i] != null)
                nonNull.add(newItem[i]);
        }
        return nonNull.toArray(new Item[nonNull.size()]);
    }

    public void wearOldItem() {
        for (int i = 0; i < oldItem.length; i++) {
            int category = oldItem[i].getItemCategoryId();
            if (category == 1)
                changeTopi(oldItem[i]);
            else if (category == 2)
                changeBaju(oldItem[i]);
            else if (category == 3)
                changeCelana(oldItem[i]);
            else if (category == 4)
                changeSepatu(oldItem[i]);
        }
    }
}
