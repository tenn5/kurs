package com.example.footbal2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.footbal2.R;
import com.example.footbal2.constants.Country;
import com.example.footbal2.recycler.AdapterContainer;
import com.google.android.material.tabs.TabLayout;


public class Container extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.container, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = view.findViewById(R.id.container);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        Country country = Country.valueOf(getArguments().getString("country", ""));

        AdapterContainer adapter = new AdapterContainer(view.getContext());
        switch (country){
            case ENGLAND:
                adapter.addFragment(new Standings(Country.ENGLAND), "Standings");
                adapter.addFragment(new Standings(Country.ITALY), "Match");
                break;
            case GERMANY:
                adapter.addFragment(new Standings(Country.GERMANY), "Standings");
                adapter.addFragment(new Standings(Country.ITALY), "Match");
                break;
            case SPAIN:
                adapter.addFragment(new Standings(Country.SPAIN), "Standings");
                adapter.addFragment(new Standings(Country.ITALY), "Match");
                break;
            case FRANCE:
                adapter.addFragment(new Standings(Country.FRANCE), "Standings");
                adapter.addFragment(new Standings(Country.ITALY), "Match");
                break;
            default:
                adapter.addFragment(new Standings(Country.ITALY), "Standings");
                adapter.addFragment(new Standings(Country.ITALY), "Match");
                break;
        }

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    public static Container getInstance(Country country){
        Bundle bundle = new Bundle();
        bundle.putString("country", String.valueOf(country));
        Container container = new Container();
        container.setArguments(bundle);
        return container;
    }

}