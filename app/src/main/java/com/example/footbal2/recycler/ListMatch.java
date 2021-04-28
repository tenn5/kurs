package com.example.footbal2.recycler;

import org.json.JSONException;
import org.json.JSONObject;

public class ListMatch {
    private final String idTeam1;
    private final String idTeam2;
    private final String winner;
    private final String nameTeam1;
    private final String resultTeam1;
    private final String resultTeam2;
    private final String nameTeam2;

    public ListMatch(JSONObject object) throws JSONException {
        this.idTeam1 = object.getJSONObject("homeTeam").getString("id");
        this.idTeam2 = object.getJSONObject("awayTeam").getString("id");
        this.winner = object.getJSONObject("score").getString("winner");
        this.nameTeam1 = object.getJSONObject("homeTeam").getString("name");
        this.nameTeam2 = object.getJSONObject("awayTeam").getString("name");
        this.resultTeam1 = object.getJSONObject("score").getJSONObject("fullTime").getString("homeTeam");
        this.resultTeam2 = object.getJSONObject("score").getJSONObject("fullTime").getString("awayTeam");
    }

    public String getIdTeam1() {
        return idTeam1;
    }

    public String getIdTeam2() {
        return idTeam2;
    }

    public String getNameTeam1() {
        return nameTeam1;
    }

    public String getResultTeam1() {
        return resultTeam1;
    }

    public String getResultTeam2() {
        return resultTeam2;
    }

    public String getNameTeam2() {
        return nameTeam2;
    }

    public String getWinner() {
        return winner;
    }
}
