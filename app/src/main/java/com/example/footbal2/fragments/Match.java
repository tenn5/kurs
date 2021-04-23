package com.example.footbal2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.footbal2.R;
import com.example.footbal2.constants.Country;
import com.example.footbal2.constants.GetRequest;
import com.example.footbal2.constants.TypeData;
import com.example.footbal2.url.GetUrlData;

public class Match extends Fragment {

    Country country;

    public Match(Country country) {
        this.country = country;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.matches, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        switch (country){
            case ENGLAND:
                new GetUrlData(getContext(), view.findViewById(R.id.standings), TypeData.MATCH).execute(new GetRequest().getStandingsEnglandUrl());
                break;
            case GERMANY:
                new GetUrlData(getContext(), view.findViewById(R.id.standings), TypeData.MATCH).execute(new GetRequest().getStandingsGermanyUrl());
                break;
            case SPAIN:
                new GetUrlData(getContext(), view.findViewById(R.id.standings), TypeData.MATCH).execute(new GetRequest().getStandingsSpainUrl());
                break;
            case FRANCE:
                new GetUrlData(getContext(), view.findViewById(R.id.standings), TypeData.MATCH).execute(new GetRequest().getStandingsFranceUrl());
                break;
            default:
                new GetUrlData(getContext(), view.findViewById(R.id.standings), TypeData.MATCH).execute(new GetRequest().getStandingsItalyUrl());
                break;
        }
    }
}


