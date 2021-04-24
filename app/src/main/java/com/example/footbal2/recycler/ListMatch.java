package com.example.footbal2.recycler;

import org.json.JSONException;
import org.json.JSONObject;

public class ListMatch {
    private String winner;
    private String nameTeam1;
    private String resultTeam1;
    private String resultTeam2;
    private String nameTeam2;

    public ListMatch(JSONObject object) throws JSONException {
        this.winner = object.getJSONObject("score").getString("winner");
        this.nameTeam1 = object.getJSONObject("homeTeam").getString("name");
        this.nameTeam2 = object.getJSONObject("awayTeam").getString("name");
        this.resultTeam1 = object.getJSONObject("score").getJSONObject("fullTime").getString("homeTeam");
        this.resultTeam2 = object.getJSONObject("score").getJSONObject("fullTime").getString("awayTeam");
    }

    public String getNameTeam1() {
        return nameTeam1;
    }

    public void setNameTeam1(String nameTeam1) {
        this.nameTeam1 = nameTeam1;
    }

    public String getResultTeam1() {
        return resultTeam1;
    }

    public void setResultTeam1(String resultTeam1) {
        this.resultTeam1 = resultTeam1;
    }

    public String getResultTeam2() {
        return resultTeam2;
    }

    public void setResultTeam2(String resultTeam2) {
        this.resultTeam2 = resultTeam2;
    }

    public String getNameTeam2() {
        return nameTeam2;
    }

    public void setNameTeam2(String nameTeam2) {
        this.nameTeam2 = nameTeam2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
