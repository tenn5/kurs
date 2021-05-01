package com.example.football2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.football2.R;
import com.example.football2.auxiliary.DataActivity;
import com.example.football2.constants.Country;
import com.example.football2.constants.GetRequest;
import com.example.football2.constants.TypeData;
import com.example.football2.url.GetUrlData;

public class Standings extends Fragment {

    private Country country;

    public Standings(Country country) {
        this.country = country;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.standings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataActivity data = new DataActivity(getContext(), view.findViewById(R.id.standings), TypeData.STANDINGS);
        GetUrlData getUrlData = new GetUrlData(data);
        GetRequest constRequest = new GetRequest();

        switch (country){
            case ENGLAND:
                getUrlData.execute(constRequest.getStandingsEnglandUrl());
                break;
            case GERMANY:
                getUrlData.execute(constRequest.getStandingsGermanyUrl());
                break;
            case SPAIN:
                getUrlData.execute(constRequest.getStandingsSpainUrl());
                break;
            case FRANCE:
                getUrlData.execute(constRequest.getStandingsFranceUrl());
                break;
            default:
                getUrlData.execute(constRequest.getStandingsItalyUrl());
                break;
        }
    }
}

