package com.squishydev.setoz.englishkidstalk.data.firebase.model;

import java.util.List;
import java.util.Map;

public class Match {
    private boolean isPlaying;
    private Map<String,Integer> score;
    private String hostId;
    private String clientId;

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public Map<String, Integer> getScore() {
        return score;
    }

    public void setScore(Map<String, Integer> score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "Match{" +
                "isPlaying=" + isPlaying +
                ", score=" + score +
                ", hostId='" + hostId + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
