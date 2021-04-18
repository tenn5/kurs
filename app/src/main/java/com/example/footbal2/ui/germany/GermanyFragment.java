package com.example.footbal2.ui.germany;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.GetUrlData;
import com.example.footbal2.ListStandings;
import com.example.footbal2.R;
import com.example.footbal2.constants.GetRequest;

import java.util.List;

public class GermanyFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_germany, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new GetUrlData(getContext(), view.findViewById(R.id.standings_germany)).execute(new GetRequest().getStandingsGermanyUrl());

    }
}