package com.example.footbal2.recycler;

import android.content.Context;
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

        changeColor(holder.form1, listStandings.getForm().get(0));
        changeColor(holder.form2, listStandings.getForm().get(1));
        changeColor(holder.form3, listStandings.getForm().get(2));
        changeColor(holder.form4, listStandings.getForm().get(3));
        changeColor(holder.form5, listStandings.getForm().get(4));

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
        private TextView form1;
        private TextView form2;
        private TextView form3;
        private TextView form4;
        private TextView form5;
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
            form1 = itemView.findViewById(R.id.form1);
            form2 = itemView.findViewById(R.id.form2);
            form3 = itemView.findViewById(R.id.form3);
            form4 = itemView.findViewById(R.id.form4);
            form5 = itemView.findViewById(R.id.form5);
            won = itemView.findViewById(R.id.won);
            draw = itemView.findViewById(R.id.draw);
            lost = itemView.findViewById(R.id.lost);
            playedGames = itemView.findViewById(R.id.playedGames);
            points = itemView.findViewById(R.id.points);

        }
    }
}
