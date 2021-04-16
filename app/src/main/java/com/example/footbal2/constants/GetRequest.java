package com.example.footbal2.constants;

public class GetRequest {
    private final String standingsEnglandUrl = "https://api.football-data.org/v2/competitions/PL/standings";
    private final String key = "X-Auth-Token";
    private final String value = "5d2796cc4596438d8bc74101e237d3f4";

    public String getStandingsEnglandUrl() {
        return standingsEnglandUrl;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
