package com.example.footbal2;

public class ListStandings {
    private int position;
    private int drawableEmblem;
    private String nameTeam;
    private String form;
    private int won;
    private int draw;
    private int lost;
    private int playedGames;
    private int points;

    public ListStandings(int position, int drawableEmblem, String nameTeam, String form, int won, int draw, int lost, int playedGames, int points) {
        this.position = position;
        this.drawableEmblem = drawableEmblem;
        this.nameTeam = nameTeam;
        this.form = form;
        this.won = won;
        this.draw = draw;
        this.lost = lost;
        this.playedGames = playedGames;
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDrawableEmblem() {
        return drawableEmblem;
    }

    public void setDrawableEmblem(int drawableEmblem) {
        this.drawableEmblem = drawableEmblem;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
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
