package com.squishydev.setoz.englishkidstalk.data.firebase.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Match implements Serializable {
    private boolean isPlaying;
    private boolean isStarting;
    private String hostId;
    private String clientId;
//    private int hostScore;
//    private int clientScore;
    private Map<String,Integer> score;

    public Map<String, Integer> getScore() {
        return score;
    }

    public void setScore(Map<String, Integer> score) {
        this.score = score;
    }

//    public int getHostScore() {
//        return hostScore;
//    }

//    public void setHostScore(int hostScore) {
//        this.hostScore = hostScore;
//    }

//    public int getClientScore() {
//        return clientScore;
//    }

//    public void setClientScore(int clientScore) {
//        this.clientScore = clientScore;
//    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }


    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public boolean isStarting() {
        return isStarting;
    }

    public void setStarting(boolean starting) {
        isStarting = starting;
    }

    @Override
    public String toString() {
        return "Match{" +
                "isPlaying=" + isPlaying +
                ", isStarting=" + isStarting +
                ", hostId='" + hostId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", score=" + score +
                '}';
    }
}
