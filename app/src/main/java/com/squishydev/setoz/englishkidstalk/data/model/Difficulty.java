package com.squishydev.setoz.englishkidstalk.data.model;

import static com.squishydev.setoz.englishkidstalk.utils.LearningConstant.DIFFICULTY_EASY_ID;
import static com.squishydev.setoz.englishkidstalk.utils.LearningConstant.DIFFICULTY_HARD_ID;
import static com.squishydev.setoz.englishkidstalk.utils.LearningConstant.DIFFICULTY_MEDIUM_ID;

/**
 * Created by miftahun on 9/29/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public enum  Difficulty {
    DIFFICULTY_EASY("easy",0,DIFFICULTY_EASY_ID),
    DIFFICULTY_MEDIUM("medium",1,DIFFICULTY_MEDIUM_ID),
    DIFFICULTY_HARD("hard",2,DIFFICULTY_HARD_ID);

    String text;
    int number;
    int id;

    Difficulty(String difficulty, int number, int id){
        this.text = difficulty;
        this.number = number;
        this.id = id;
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

    public int getId() {
        return id;
    }
}
