package com.example.footbal2.recycler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStandings {
    private int position;
    private String urlEmblem;
    private String nameTeam;
    private List<String> form;
    private int won;
    private int draw;
    private int lost;
    private int playedGames;
    private int points;

    public ListStandings(JSONObject object) throws JSONException {
        this.position = object.getInt("position");
        this.urlEmblem = object.getJSONObject("team").getString("crestUrl");
        this.nameTeam = object.getJSONObject("team").getString("name");
        this.form = new ArrayList<>(Arrays.asList(object.getString("form").split(",")));
        this.won = object.getInt("won");
        this.draw = object.getInt("draw");
        this.lost = object.getInt("lost");
        this.playedGames = object.getInt("playedGames");
        this.points = object.getInt("points");
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUrlEmblem() {
        return urlEmblem;
    }

    public void setUrlEmblem(String urlEmblem) {
        this.urlEmblem = urlEmblem;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public List<String> getForm() {
        form.add("");
        form.add("");
        form.add("");
        form.add("");
        form.add("");
        return form;
    }

    public void setForm(List<String> form) {
        this.form = form;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
