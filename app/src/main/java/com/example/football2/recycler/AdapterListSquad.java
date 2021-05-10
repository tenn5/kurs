package com.example.football2.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.football2.R;

import java.util.List;

public class AdapterListSquad extends RecyclerView.Adapter<AdapterListSquad.ListStandingsViewHolder>{

    private final List<ListSquad> list;
    private final Context context;

    public AdapterListSquad(Context context, List<ListSquad> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ListStandingsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_squad, viewGroup, false);
        return new ListStandingsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListStandingsViewHolder holder, int i) {
        ListSquad listSquad = list.get(i);

        holder.name.setText(listSquad.getName());
        holder.position.setText(listSquad.getPosition());
        holder.nationality.setText(listSquad.getNationality());
        holder.dateOfBirth.setText(listSquad.getDateOfBirth().split("T")[0]);
    }

    @Override
    public int getItemCount() {
        return Math.max(1, list.size());
    }

    public static class ListStandingsViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView position;
        private final TextView nationality;
        private final TextView dateOfBirth;

        public ListStandingsViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_squad);
            position = itemView.findViewById(R.id.position_squad);
            nationality = itemView.findViewById(R.id.nationality_squad);
            dateOfBirth = itemView.findViewById(R.id.date_of_birth_squad);

        }
    }
}
