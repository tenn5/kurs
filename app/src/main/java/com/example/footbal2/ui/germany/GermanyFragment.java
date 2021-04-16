package com.example.footbal2.ui.germany;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.footbal2.R;

public class GermanyFragment extends Fragment {

    private GermanyViewModel germanyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        germanyViewModel =
                new ViewModelProvider(this).get(GermanyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_germany, container, false);
        final TextView textView = root.findViewById(R.id.text_germany);
        germanyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}