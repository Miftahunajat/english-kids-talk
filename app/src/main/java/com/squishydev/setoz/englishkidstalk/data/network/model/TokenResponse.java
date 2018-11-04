package com.squishydev.setoz.englishkidstalk.data.network.model;

import com.google.gson.annotations.SerializedName;

public class TokenResponse {

    @SerializedName("msg")
    private String msg;

    @SerializedName("token")
    private String token;

    public TokenResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenResponse{" +
                "msg='" + msg + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
