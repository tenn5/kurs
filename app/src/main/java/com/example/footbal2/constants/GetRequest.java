package com.example.footbal2.constants;

public class GetRequest {
    private final String standingsEnglandUrl = "https://api.football-data.org/v2/competitions/PL/standings";
    private final String standingsGermanyUrl = "https://api.football-data.org/v2/competitions/BL1/standings";
    private final String standingsSpainUrl = "https://api.football-data.org/v2/competitions/PD/standings";
    private final String standingsFranceUrl = "https://api.football-data.org/v2/competitions/FL1/standings";
    private final String standingsItalyUrl = "https://api.football-data.org/v2/competitions/SA/standings";
    private final String key = "X-Auth-Token";
    private final String value = "5d2796cc4596438d8bc74101e237d3f4";

    public String getStandingsEnglandUrl() {
        return standingsEnglandUrl;
    }

    public String getStandingsGermanyUrl() {
        return standingsGermanyUrl;
    }

    public String getStandingsSpainUrl() {
        return standingsSpainUrl;
    }

    public String getStandingsFranceUrl() {
        return standingsFranceUrl;
    }

    public String getStandingsItalyUrl() {
        return standingsItalyUrl;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
