package com.squishydev.setoz.englishkidstalk.data.network.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("msg")
    private String msg;

    @SerializedName("user")
    private User user;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
