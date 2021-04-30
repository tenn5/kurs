package com.example.footbal2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.R;
import com.example.footbal2.auxiliary.DataActivity;
import com.example.footbal2.auxiliary.DataMatch;
import com.example.footbal2.constants.Country;
import com.example.footbal2.constants.GetRequest;
import com.example.footbal2.constants.TypeData;
import com.example.footbal2.url.GetUrlData;

public class Matches extends Fragment {

    private Country country;
    private Spinner spinner;
    private RecyclerView rv;

    public Matches(Country country) {
        this.country = country;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.matches, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = view.findViewById(R.id.spinner);
        rv = view.findViewById(R.id.matches_rv);

        DataActivity data = new DataActivity(getContext(), rv, TypeData.SPINNER);
        DataMatch dataMatch = new DataMatch(spinner, country);

        GetUrlData getUrlData = new GetUrlData(data, dataMatch);
        GetRequest constRequest = new GetRequest();

        switch (country){
            case ENGLAND:
                getUrlData.execute(constRequest.getAllMatchesEngland());
                break;
            case GERMANY:
                getUrlData.execute(constRequest.getAllMatchesGermany());
                break;
            case SPAIN:
                getUrlData.execute(constRequest.getAllMatchesSpain());
                break;
            case FRANCE:
                getUrlData.execute(constRequest.getAllMatchesFrance());
                break;
            default:
                getUrlData.execute(constRequest.getAllMatchesItaly());
                break;
        }
    }


}


