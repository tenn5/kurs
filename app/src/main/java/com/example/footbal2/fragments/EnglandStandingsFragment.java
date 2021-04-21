package com.example.footbal2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.footbal2.url.GetUrlData;
import com.example.footbal2.R;
import com.example.footbal2.constants.GetRequest;

public class EnglandStandingsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_standings_england, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new GetUrlData(getContext(), view.findViewById(R.id.standings_england)).execute(new GetRequest().getStandingsEnglandUrl());

    }
}

