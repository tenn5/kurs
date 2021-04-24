package com.example.footbal2.recycler;


import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.R;
import com.example.footbal2.url.Utils;

import java.util.List;

public class AdapterListMatch extends RecyclerView.Adapter<AdapterListMatch.ListMatchViewHolder>{

    private List<ListMatch> list;
    private Context context;

    public AdapterListMatch(Context context, List<ListMatch> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ListMatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_match, viewGroup, false);
        ListMatchViewHolder holder = new ListMatchViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListMatchViewHolder holder, int i) {
        ListMatch listStandings = list.get(i);
        holder.nameTeam1.setText(listStandings.getNameTeam1());
        holder.nameTeam2.setText(listStandings.getNameTeam2());

        if (listStandings.getWinner().equals("null")) {
            holder.result.setText(":");
        } else {
            holder.result.setBackgroundColor(context.getColor(R.color.green));
            holder.result.setTextColor(context.getColor(R.color.white));
            holder.result.setText(listStandings.getResultTeam1() + ":" + listStandings.getResultTeam2());
            changeColor(holder.nameTeam1, holder.nameTeam2, listStandings.getWinner());
        }
    }
    private void changeColor(TextView team1, TextView team2, String result){
        if (result.equals("HOME_TEAM")){
            team1.setTextColor(context.getColor(R.color.green));
            team2.setTextColor(context.getColor(R.color.red));
        } else if (result.equals("DRAW")){
            team1.setTextColor(context.getColor(R.color.yellow));
            team2.setTextColor(context.getColor(R.color.yellow));
        } else if (result.equals("AWAY_TEAM")){
            team1.setTextColor(context.getColor(R.color.red));
            team2.setTextColor(context.getColor(R.color.green));
        }
    }

    @Override
    public int getItemCount() {
        return Math.max(1, list.size());
    }

    public static class ListMatchViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTeam1;
        private Button result;
        private TextView nameTeam2;

        public ListMatchViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTeam1 = itemView.findViewById(R.id.name_team1);
            result = itemView.findViewById(R.id.result_btn);
            nameTeam2 = itemView.findViewById(R.id.name_team2);
        }
    }
}

