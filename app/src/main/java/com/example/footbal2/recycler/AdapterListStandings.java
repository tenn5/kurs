package com.example.footbal2.recycler;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.R;
import com.example.footbal2.url.Utils;

import java.util.List;

public class AdapterListStandings extends RecyclerView.Adapter<AdapterListStandings.ListStandingsViewHolder>{

    private List<ListStandings> list;
    private Context context;
    private FragmentManager fragmentManager;

    public AdapterListStandings(Context context, List<ListStandings> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ListStandingsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_standings_team, viewGroup, false);
        ListStandingsViewHolder holder = new ListStandingsViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListStandingsViewHolder holder, int i) {
        ListStandings listStandings = list.get(i);

        holder.position.setText(Integer.toString(listStandings.getPosition()));

        Utils.fetchSvg(context, listStandings.getUrlEmblem(), holder.emblem);

        holder.nameTeam.setText(listStandings.getNameTeam());

        changeColor(holder.oneMatchesAgo, listStandings.getForm().get(0));
        changeColor(holder.twoMatchesAgo, listStandings.getForm().get(1));
        changeColor(holder.threeMatchesAgo, listStandings.getForm().get(2));
        changeColor(holder.fourMatchesAgo, listStandings.getForm().get(3));
        changeColor(holder.fiveMatchesAgo, listStandings.getForm().get(4));

        holder.won.setText(Integer.toString(listStandings.getWon()));
        holder.draw.setText(Integer.toString(listStandings.getDraw()));
        holder.lost.setText(Integer.toString(listStandings.getLost()));

        holder.playedGames.setText(Integer.toString(listStandings.getPlayedGames()));

        holder.points.setText(Integer.toString(listStandings.getPoints()));
    }
    private void changeColor(TextView form, String text){
        form.setText(text);
        if (text.equals("L")){
            form.setTextColor(context.getColor(R.color.red));
        } else if (text.equals("D")){
            form.setTextColor(context.getColor(R.color.yellow));
        } else if (text.equals("W")){
            form.setTextColor(context.getColor(R.color.green));
        }
    }

    @Override
    public int getItemCount() {
        return Math.max(1, list.size());
    }

    public static class ListStandingsViewHolder extends RecyclerView.ViewHolder {

        private TextView position;
        private ImageView emblem;
        private TextView nameTeam;
        private TextView fiveMatchesAgo;
        private TextView fourMatchesAgo;
        private TextView threeMatchesAgo;
        private TextView twoMatchesAgo;
        private TextView oneMatchesAgo;
        private TextView won;
        private TextView draw;
        private TextView lost;
        private TextView playedGames;
        private TextView points;

        public ListStandingsViewHolder(@NonNull View itemView) {
            super(itemView);

            position = itemView.findViewById(R.id.positionTeam);
            emblem = itemView.findViewById(R.id.emblem);
            nameTeam = itemView.findViewById(R.id.nameTeam);
            fiveMatchesAgo = itemView.findViewById(R.id.five_matches_ago);
            fourMatchesAgo = itemView.findViewById(R.id.four_matches_ago);
            threeMatchesAgo = itemView.findViewById(R.id.three_matches_ago);
            twoMatchesAgo = itemView.findViewById(R.id.two_matches_ago);
            oneMatchesAgo = itemView.findViewById(R.id.one_match_ago);
            won = itemView.findViewById(R.id.won);
            draw = itemView.findViewById(R.id.draw);
            lost = itemView.findViewById(R.id.lost);
            playedGames = itemView.findViewById(R.id.playedGames);
            points = itemView.findViewById(R.id.points);

        }
    }
}
