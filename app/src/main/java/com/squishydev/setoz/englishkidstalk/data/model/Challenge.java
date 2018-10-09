package com.squishydev.setoz.englishkidstalk.data.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

/**
 * Created by miftahun on 10/7/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class Challenge implements Serializable {
    private int id;
    private int stars;
    private int questionPict;
    private String questions;
    private String answers;

    public Challenge(int id, int stars, int questionPict, String questions, String answers) {
        this.id = id;
        this.stars = stars;
        this.questionPict = questionPict;
        this.questions = questions;
        this.answers = answers;
    }

    @BindingAdapter({"imageChallengeUrl"})
    public static void loadImage(ImageView view, int imageUrl){
        Picasso.get().load(imageUrl).into(view);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getQuestionPict() {
        return questionPict;
    }

    public void setQuestionPict(int questionPict) {
        this.questionPict = questionPict;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "id=" + id +
                ", stars=" + stars +
                ", questionPict=" + questionPict +
                ", questions='" + questions + '\'' +
                ", answers='" + answers + '\'' +
                '}';
    }
}
