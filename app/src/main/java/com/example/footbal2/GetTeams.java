package com.example.footbal2;

import com.example.footbal2.constants.TeamEngland;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetTeams {
    public List<ListStandings> getTeams(JSONObject jsonObject, Map<Integer, Integer> team) throws JSONException {
        List<ListStandings> teams = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("standings").getJSONObject(0).getJSONArray("table");
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject object = jsonArray.getJSONObject(i);
            teams.add(new ListStandings(object.getInt("position"),
                    team.get(object.getJSONObject("team").getInt("id")),
                    object.getJSONObject("team").getString("name"), object.getString("form"),
                    object.getInt("won"), object.getInt("draw"), object.getInt("lost"),
                    object.getInt("playedGames"), object.getInt("points")
            ));
        }

        return teams;
    }
}
