package com.example.footbal2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.auxiliary.DataActivity;
import com.example.footbal2.auxiliary.DataInfoTeam;
import com.example.footbal2.constants.GetRequest;
import com.example.footbal2.constants.TypeData;
import com.example.footbal2.url.GetUrlData;

public class InfoTeam extends Activity {

    private TextView nameTeam;
    private TextView venue;
    private TextView founded;
    private Button website_btn;
    private RecyclerView rv;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_team);

        nameTeam = findViewById(R.id.name_team);
        venue = findViewById(R.id.venue);
        founded = findViewById(R.id.founded);
        website_btn = findViewById(R.id.website);
        rv = findViewById(R.id.squad_rv);
        imageView = findViewById(R.id.icon_team);

        Intent intent = getIntent();

        DataActivity data = new DataActivity(this, rv, TypeData.INFO);
        DataInfoTeam dataInfoTeam = new DataInfoTeam(nameTeam, venue, founded, website_btn, imageView);

        GetUrlData getUrlData = new GetUrlData(data, dataInfoTeam);
        GetRequest constRequest = new GetRequest();
        getUrlData.execute(constRequest.getTeamById() + intent.getStringExtra("id"));
    }
}
