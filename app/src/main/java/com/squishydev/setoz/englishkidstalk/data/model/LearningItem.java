package com.squishydev.setoz.englishkidstalk.data.model;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squishydev.setoz.englishkidstalk.utils.MediaUtils;

/**
 * Created by miftahun on 9/29/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class LearningItem {

    private String title;
    private int image;
    private int sound;

    public LearningItem(String title, int image, int sound) {
        this.title = title;
        this.image = image;
        this.sound = sound;
    }

    public void playSound(Context context){
        MediaUtils.playSound(context,sound);
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, int imageUrl){
        Picasso.get().load(imageUrl).into(view);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
