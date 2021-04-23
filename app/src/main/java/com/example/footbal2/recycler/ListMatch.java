package com.example.footbal2.recycler;

import org.json.JSONException;
import org.json.JSONObject;

public class ListMatch {
    private String winner;
    private String urlEmblemTeam1;
    private String nameTeam1;
    private int resultTeam1;
    private int resultTeam2;
    private String nameTeam2;
    private String urlEmblemTeam2;


    public ListMatch(JSONObject object) throws JSONException {

    }

    public String getUrlEmblemTeam1() {
        return urlEmblemTeam1;
    }

    public void setUrlEmblemTeam1(String urlEmblemTeam1) {
        this.urlEmblemTeam1 = urlEmblemTeam1;
    }

    public String getNameTeam1() {
        return nameTeam1;
    }

    public void setNameTeam1(String nameTeam1) {
        this.nameTeam1 = nameTeam1;
    }

    public int getResultTeam1() {
        return resultTeam1;
    }

    public void setResultTeam1(int resultTeam1) {
        this.resultTeam1 = resultTeam1;
    }

    public int getResultTeam2() {
        return resultTeam2;
    }

    public void setResultTeam2(int resultTeam2) {
        this.resultTeam2 = resultTeam2;
    }

    public String getNameTeam2() {
        return nameTeam2;
    }

    public void setNameTeam2(String nameTeam2) {
        this.nameTeam2 = nameTeam2;
    }

    public String getUrlEmblemTeam2() {
        return urlEmblemTeam2;
    }

    public void setUrlEmblemTeam2(String urlEmblemTeam2) {
        this.urlEmblemTeam2 = urlEmblemTeam2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
