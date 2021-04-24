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

        switch (country){
            case ENGLAND:
                new GetUrlData(getContext(), spinner, TypeData.SPINNER, country, rv)
                        .execute(new GetRequest().getAllMatchesEngland());
                break;
            case GERMANY:
                new GetUrlData(getContext(), spinner, TypeData.SPINNER, country, rv)
                        .execute(new GetRequest().getAllMatchesGermany());
                break;
            case SPAIN:
                new GetUrlData(getContext(), spinner, TypeData.SPINNER, country, rv)
                        .execute(new GetRequest().getAllMatchesSpain());
                break;
            case FRANCE:
                new GetUrlData(getContext(), spinner, TypeData.SPINNER, country, rv)
                        .execute(new GetRequest().getAllMatchesFrance());
                break;
            default:
                new GetUrlData(getContext(), spinner, TypeData.SPINNER, country, rv)
                        .execute(new GetRequest().getAllMatchesItaly());
                break;
        }
    }


}


