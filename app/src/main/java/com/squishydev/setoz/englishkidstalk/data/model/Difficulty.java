package com.squishydev.setoz.englishkidstalk.data.model;

/**
 * Created by miftahun on 9/29/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public enum  Difficulty {
    DIFFICULTY_EASY("easy"),
    DIFFICULTY_MEDIUM("medium"),
    DIFFICULTY_HARD("hard");

    String text;

    Difficulty(String difficulty){
        this.text = difficulty;
    }

    String getDifficulty(){
        return text;
    }
}
