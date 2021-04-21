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
import com.example.footbal2.recycler.AdapterContainer;
import com.google.android.material.tabs.TabLayout;


public class EnglandContainer extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_england_container, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.container);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);

        AdapterContainer adapter = new AdapterContainer(view.getContext());
        adapter.addFragment(new EnglandStandingsFragment(), "Standings");
        adapter.addFragment(new FranceFragment(), "Match");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

}