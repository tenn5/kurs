package com.example.football2.recycler;

import org.json.JSONException;
import org.json.JSONObject;

public class ListSquad {
    private final String name;
    private final String position;
    private final String nationality;
    private final String dateOfBirth;

    public ListSquad(JSONObject object) throws JSONException {
        name = object.getString("name");

        if(!object.getString("role").equals("PLAYER")){
            position = object.getString("role");
        } else {
            position = object.getString("position");
        }
        nationality = object.getString("nationality");
        dateOfBirth = object.getString("dateOfBirth");
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
