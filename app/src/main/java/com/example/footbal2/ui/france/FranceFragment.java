package com.example.footbal2.ui.france;

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

public class FranceFragment extends Fragment {

    private FranceViewModel franceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        franceViewModel =
                new ViewModelProvider(this).get(FranceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_france, container, false);
        final TextView textView = root.findViewById(R.id.text_france);
        franceViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}