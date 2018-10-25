package com.squishydev.setoz.englishkidstalk.data.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miftahun on 9/29/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class LearningCategory {

    private int id;
    private String categoryName;
    private int categoryImageUrl;

    public LearningCategory() {
    }

    @BindingAdapter({"imageUrlss"})
    public static void loadImage(ImageView view, int imageUrl){
        Picasso.get().load(imageUrl).into(view);
    }

    public LearningCategory(int id, String categoryName, int categoryImageUrl) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryImageUrl = categoryImageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(int categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }
}
