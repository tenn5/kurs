package com.example.football2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.football2.auxiliary.DataActivity;
import com.example.football2.auxiliary.DataInfoTeam;
import com.example.football2.constants.GetRequest;
import com.example.football2.constants.TypeData;
import com.example.football2.url.GetUrlData;

public class InfoTeam extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_team);

        TextView nameTeam = findViewById(R.id.name_team);
        TextView venue = findViewById(R.id.venue);
        TextView founded = findViewById(R.id.founded);
        Button website_btn = findViewById(R.id.website_btn);
        RecyclerView rv = findViewById(R.id.squad_rv);
        ImageView imageView = findViewById(R.id.icon_team);

        DataActivity data = new DataActivity(this, rv, TypeData.INFO);
        DataInfoTeam dataInfoTeam = new DataInfoTeam(nameTeam, venue, founded, website_btn, imageView);

        GetUrlData getUrlData = new GetUrlData(data, dataInfoTeam);
        GetRequest constRequest = new GetRequest();
        getUrlData.execute(constRequest.getTeamById() + getIntent().getStringExtra("id"));
    }
}
