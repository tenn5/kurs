package com.example.football2.auxiliary;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DataInfoTeam {
    private final TextView nameTeam;
    private final TextView venue;
    private final TextView founded;
    private final Button website;
    private final ImageView imageView;

    public DataInfoTeam(TextView nameTeam, TextView venue, TextView founded, Button website, ImageView imageView) {
        this.nameTeam = nameTeam;
        this.venue = venue;
        this.founded = founded;
        this.website = website;
        this.imageView = imageView;
    }

    public TextView getNameTeam() {
        return nameTeam;
    }

    public TextView getVenue() {
        return venue;
    }

    public TextView getFounded() {
        return founded;
    }

    public Button getWebsite() {
        return website;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
