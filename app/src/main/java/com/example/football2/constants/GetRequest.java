package com.example.football2.constants;

public class GetRequest {
    private final String standingsEnglandUrl = "https://api.football-data.org/v2/competitions/PL/standings";
    private final String standingsGermanyUrl = "https://api.football-data.org/v2/competitions/BL1/standings";
    private final String standingsSpainUrl = "https://api.football-data.org/v2/competitions/PD/standings";
    private final String standingsFranceUrl = "https://api.football-data.org/v2/competitions/FL1/standings";
    private final String standingsItalyUrl = "https://api.football-data.org/v2/competitions/SA/standings";

    private final String allMatchesEngland = "https://api.football-data.org/v2/competitions/PL/matches";
    private final String allMatchesGermany = "https://api.football-data.org/v2/competitions/BL1/matches";
    private final String allMatchesSpain = "https://api.football-data.org/v2/competitions/PD/matches";
    private final String allMatchesFrance = "https://api.football-data.org/v2/competitions/FL1/matches";
    private final String allMatchesItaly = "https://api.football-data.org/v2/competitions/SA/matches";

    private final String matchesEnglandByTour = "https://api.football-data.org/v2/competitions/PL/matches?matchday=";
    private final String matchesGermanyByTour = "https://api.football-data.org/v2/competitions/BL1/matches?matchday=";
    private final String matchesSpainByTour = "https://api.football-data.org/v2/competitions/PD/matches?matchday=";
    private final String matchesFranceByTour = "https://api.football-data.org/v2/competitions/FL1/matches?matchday=";
    private final String matchesItalyByTour = "https://api.football-data.org/v2/competitions/SA/matches?matchday=";

    private final String teamById = "https://api.football-data.org/v2/teams/";

    private final String key = "X-Auth-Token";
    private final String value = "5d2796cc4596438d8bc74101e237d3f4";

    private final String regexNameTeam =
            "\\b( ?'s|29|1899|1901|1909|1913|AC|AS|ACF|BC|BSC|CA|CF|CFC|FC|FSV|HSC|OGC|OSC|RC" +
                    "|SC|SCO|SD|SS|SSC|SV|TSG|UC|UD|US|VfB|VfL)\\b";


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

    public String getAllMatchesEngland() {
        return allMatchesEngland;
    }

    public String getAllMatchesGermany() {
        return allMatchesGermany;
    }

    public String getAllMatchesSpain() {
        return allMatchesSpain;
    }

    public String getAllMatchesFrance() {
        return allMatchesFrance;
    }

    public String getAllMatchesItaly() {
        return allMatchesItaly;
    }

    public String getMatchesEnglandByTour() {
        return matchesEnglandByTour;
    }

    public String getMatchesGermanyByTour() {
        return matchesGermanyByTour;
    }

    public String getMatchesSpainByTour() {
        return matchesSpainByTour;
    }

    public String getMatchesFranceByTour() {
        return matchesFranceByTour;
    }

    public String getMatchesItalyByTour() {
        return matchesItalyByTour;
    }

    public String getTeamById() {
        return teamById;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getRegexNameTeam() {
        return regexNameTeam;
    }
}
