package com.example.footbal2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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

        holder.emblem.setImageResource(listStandings.getDrawableEmblem());

        holder.nameTeam.setText(listStandings.getNameTeam());
        holder.form.setText(listStandings.getForm());
        holder.won.setText(Integer.toString(listStandings.getWon()));
        holder.draw.setText(Integer.toString(listStandings.getDraw()));
        holder.lost.setText(Integer.toString(listStandings.getLost()));
        holder.playedGames.setText(Integer.toString(listStandings.getPlayedGames()));
        holder.points.setText(Integer.toString(listStandings.getPoints()));
    }

    @Override
    public int getItemCount() {
        return Math.max(1, list.size());
    }

    public static class ListStandingsViewHolder extends RecyclerView.ViewHolder {

        private TextView position;
        private ImageView emblem;
        private TextView nameTeam;
        private TextView form;
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
            form = itemView.findViewById(R.id.form);
            won = itemView.findViewById(R.id.won);
            draw = itemView.findViewById(R.id.draw);
            lost = itemView.findViewById(R.id.lost);
            playedGames = itemView.findViewById(R.id.playedGames);
            points = itemView.findViewById(R.id.points);

        }
    }
}
