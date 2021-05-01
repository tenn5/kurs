package com.example.football2.recycler;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.football2.InfoTeam;
import com.example.football2.R;
import com.example.football2.constants.GetRequest;

import java.util.List;

public class AdapterListMatch extends RecyclerView.Adapter<AdapterListMatch.ListMatchViewHolder>{

    private final List<ListMatch> list;
    private final Context context;

    public AdapterListMatch(Context context, List<ListMatch> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ListMatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_match, viewGroup, false);
        return new ListMatchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMatchViewHolder holder, int i) {
        ListMatch listStandings = list.get(i);

        holder.nameTeam1.setText(listStandings.getNameTeam1()
                .replaceAll(new GetRequest().getRegexNameTeam(), "")
                .replace("1.", "")
                .trim().replaceAll("\\s{2,}", " "));
        holder.nameTeam2.setText(listStandings.getNameTeam2()
                .replaceAll(new GetRequest().getRegexNameTeam(), "")
                .replace("1.", "")
                .trim().replaceAll("\\s{2,}", " "));

        if (listStandings.getWinner().equals("null")) {
            holder.result.setText("-:-");
        } else {
            holder.result.setBackgroundColor(context.getColor(R.color.primaryDark));
            holder.result.setTextColor(context.getColor(R.color.white));
            holder.result.setText(listStandings.getResultTeam1() + ":" + listStandings.getResultTeam2());
            changeColor(holder.nameTeam1, holder.nameTeam2, listStandings.getWinner());
        }

        holder.nameTeam1.setOnClickListener(v -> {
            Intent intent = new Intent(context, InfoTeam.class);
            intent.putExtra("id", listStandings.getIdTeam1());
            context.startActivity(intent);
        });

        holder.nameTeam2.setOnClickListener(v -> {
            Intent intent = new Intent(context, InfoTeam.class);
            intent.putExtra("id", listStandings.getIdTeam2());
            context.startActivity(intent);
        });
    }
    private void changeColor(Button team1, Button team2, String result){
        team1.setTextColor(context.getColor(R.color.onSecondary));
        team2.setTextColor(context.getColor(R.color.onSecondary));

        if (!result.equals("HOME_TEAM")) {
            if (result.equals("DRAW")){
                team1.setBackgroundColor(context.getColor(R.color.yellowBackground));
                team2.setBackgroundColor(context.getColor(R.color.yellowBackground));
            } else if (result.equals("AWAY_TEAM")){
                team1.setBackgroundColor(context.getColor(R.color.redBackground));
                team2.setBackgroundColor(context.getColor(R.color.primaryLight));
            }
        } else {
            team1.setBackgroundColor(context.getColor(R.color.primaryLight));
            team2.setBackgroundColor(context.getColor(R.color.redBackground));
        }
    }

    @Override
    public int getItemCount() {
        return Math.max(1, list.size());
    }

    public static class ListMatchViewHolder extends RecyclerView.ViewHolder {

        private final Button nameTeam1;
        private final TextView result;
        private final Button nameTeam2;

        public ListMatchViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTeam1 = itemView.findViewById(R.id.name_team_btn1);
            result = itemView.findViewById(R.id.result_text);
            nameTeam2 = itemView.findViewById(R.id.name_team_btn2);
        }
    }
}

