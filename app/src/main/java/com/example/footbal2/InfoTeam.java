package com.example.footbal2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class InfoTeam extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_team);

        Intent intent = getIntent();
        TextView textView = findViewById(R.id.textView2);
        textView.setText(intent.getStringExtra("id"));

    }
}
