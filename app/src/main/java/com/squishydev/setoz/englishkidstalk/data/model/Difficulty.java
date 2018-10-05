package com.squishydev.setoz.englishkidstalk.data.model;

/**
 * Created by miftahun on 9/29/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public enum  Difficulty {
    DIFFICULTY_EASY("easy",0),
    DIFFICULTY_MEDIUM("medium",1),
    DIFFICULTY_HARD("hard",2);

    String text;
    int number;

    Difficulty(String difficulty, int number){
        this.text = difficulty;
        this.number = number;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
