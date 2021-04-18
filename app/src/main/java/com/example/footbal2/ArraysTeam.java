package com.example.footbal2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArraysTeam {
    public List<ListStandings> createTeams(JSONObject jsonObject) throws JSONException {
        List<ListStandings> teams = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("standings").getJSONObject(0).getJSONArray("table");
        for (int i = 0; i < jsonArray.length(); i++){
            teams.add(new ListStandings(jsonArray.getJSONObject(i)));
        }
        return teams;
    }
}
