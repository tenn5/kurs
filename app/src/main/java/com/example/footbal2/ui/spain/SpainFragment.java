package com.example.footbal2.ui.spain;

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

public class SpainFragment extends Fragment {

    private SpainViewModel spainViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        spainViewModel =
                new ViewModelProvider(this).get(SpainViewModel.class);
        View root = inflater.inflate(R.layout.fragment_spain, container, false);
        final TextView textView = root.findViewById(R.id.text_spain);
        spainViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}