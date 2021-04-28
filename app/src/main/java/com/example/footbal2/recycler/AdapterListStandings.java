package com.example.footbal2.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.InfoTeam;
import com.example.footbal2.R;
import com.example.footbal2.constants.GetRequest;
import com.example.footbal2.url.Utils;

import java.util.List;

public class AdapterListStandings extends RecyclerView.Adapter<AdapterListStandings.ListStandingsViewHolder>{

    private final List<ListStandings> list;
    private final Context context;

    public AdapterListStandings(Context context, List<ListStandings> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ListStandingsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_standings_team, viewGroup, false);
        return new ListStandingsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListStandingsViewHolder holder, int i) {
        ListStandings listStandings = list.get(i);

        holder.position.setText(listStandings.getPosition());
        Utils.fetchSvg(context, listStandings.getUrlEmblem(), holder.emblem);
        holder.nameTeam.setText(listStandings.getNameTeam()
                .replaceAll(new GetRequest().getRegexNameTeam(), "")
                .replace("1.", "")
                .trim().replaceAll("\\s{2,}", " "));

        changeColor(holder.oneMatchesAgo, listStandings.getForm().get(0));
        changeColor(holder.twoMatchesAgo, listStandings.getForm().get(1));
        changeColor(holder.threeMatchesAgo, listStandings.getForm().get(2));
        changeColor(holder.fourMatchesAgo, listStandings.getForm().get(3));
        changeColor(holder.fiveMatchesAgo, listStandings.getForm().get(4));

        holder.won.setText(listStandings.getWon());
        holder.draw.setText(listStandings.getDraw());
        holder.lost.setText(listStandings.getLost());
        holder.playedGames.setText(listStandings.getPlayedGames());
        holder.points.setText(listStandings.getPoints());

        holder.nameTeam.setOnClickListener(v -> {
            Intent intent = new Intent(context, InfoTeam.class);
            intent.putExtra("id", listStandings.getId());
            context.startActivity(intent);
        });
    }
    private void changeColor(TextView form, String text){
        form.setText(text);
        switch (text) {
            case "L":
                form.setTextColor(context.getColor(R.color.red));
                break;
            case "D":
                form.setTextColor(context.getColor(R.color.yellow));
                break;
            case "W":
                form.setTextColor(context.getColor(R.color.green));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return Math.max(1, list.size());
    }

    public static class ListStandingsViewHolder extends RecyclerView.ViewHolder {

        private final TextView position;
        private final ImageView emblem;
        private final Button nameTeam;
        private final TextView fiveMatchesAgo;
        private final TextView fourMatchesAgo;
        private final TextView threeMatchesAgo;
        private final TextView twoMatchesAgo;
        private final TextView oneMatchesAgo;
        private final TextView won;
        private final TextView draw;
        private final TextView lost;
        private final TextView playedGames;
        private final TextView points;

        public ListStandingsViewHolder(@NonNull View itemView) {
            super(itemView);

            position = itemView.findViewById(R.id.positionTeam);
            emblem = itemView.findViewById(R.id.emblem);
            nameTeam = itemView.findViewById(R.id.name_team_btn);
            fiveMatchesAgo = itemView.findViewById(R.id.five_matches_ago);
            fourMatchesAgo = itemView.findViewById(R.id.four_matches_ago);
            threeMatchesAgo = itemView.findViewById(R.id.three_matches_ago);
            twoMatchesAgo = itemView.findViewById(R.id.two_matches_ago);
            oneMatchesAgo = itemView.findViewById(R.id.one_match_ago);
            won = itemView.findViewById(R.id.won);
            draw = itemView.findViewById(R.id.draw);
            lost = itemView.findViewById(R.id.lost);
            playedGames = itemView.findViewById(R.id.played_games);
            points = itemView.findViewById(R.id.points);

        }
    }
}
