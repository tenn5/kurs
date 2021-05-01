package com.example.football2.recycler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStandings {
    private final String id;
    private final String position;
    private final String urlEmblem;
    private final String nameTeam;
    private final List<String> form;
    private final String won;
    private final String draw;
    private final String lost;
    private final String playedGames;
    private final String points;

    public ListStandings(JSONObject object) throws JSONException {
        this.id = object.getJSONObject("team").getString("id");
        this.position = object.getString("position");
        this.urlEmblem = object.getJSONObject("team").getString("crestUrl");
        this.nameTeam = object.getJSONObject("team").getString("name");
        this.form = new ArrayList<>(Arrays.asList(object.getString("form").split(",")));
        this.won = object.getString("won");
        this.draw = object.getString("draw");
        this.lost = object.getString("lost");
        this.playedGames = object.getString("playedGames");
        this.points = object.getString("points");
    }

    public String getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getUrlEmblem() {
        return urlEmblem;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public List<String> getForm() {
        form.add("");
        form.add("");
        form.add("");
        form.add("");
        form.add("");
        return form;
    }

    public String getWon() {
        return won;
    }

    public String getDraw() {
        return draw;
    }

    public String getLost() {
        return lost;
    }

    public String getPlayedGames() {
        return playedGames;
    }

    public String getPoints() {
        return points;
    }
}
