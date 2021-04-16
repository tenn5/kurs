package com.example.footbal2.ui.england;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.AdapterListStandings;
import com.example.footbal2.ListStandings;
import com.example.footbal2.R;
import com.example.footbal2.constants.GetRequest;
import com.example.footbal2.constants.TeamEngland;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnglandFragment extends Fragment {

    private List<ListStandings> teams;
    private RecyclerView rv;
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_england, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        new GetUrlData().execute(new GetRequest().getStandingsEnglandUrl());

    }


    private class GetUrlData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(strings[0]);  // открыли URL соединение
                connection = (HttpURLConnection) url.openConnection(); // открыли Http соединение
                connection.setRequestProperty(new GetRequest().getKey(), new GetRequest().getValue());
                connection.connect();

                InputStream stream = connection.getInputStream(); // считали поток
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer(); // обычная строка, но лучше подходит для работы с BufferedReader
                String line;

                while ((line = reader.readLine()) != null) { // считываем текст построчно
                    buffer.append(line).append("\n"); //записываем строки в переменную и добавляем конец строки
                }

                return buffer.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally { // закрываем потоки
                if(connection != null) {
                    connection.disconnect();
                }
                try {
                    if(reader != null) {
                        reader.close();
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

            return null;
        }

        @SuppressWarnings("SetTextI18n")
        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);

            try {
                JSONObject jsonObject = new JSONObject(result);
                teams = getTeams(jsonObject);

                rv = view.findViewById(R.id.standings_england);

                rv.setHasFixedSize(true);

                rv.setLayoutManager( new LinearLayoutManager(requireContext()));
                rv.setAdapter(new AdapterListStandings(requireContext(), teams));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private List<ListStandings> getTeams(JSONObject jsonObject) throws JSONException {
            List<ListStandings> teams = new ArrayList<>();
            JSONArray jsonArray = jsonObject.getJSONArray("standings").getJSONObject(0).getJSONArray("table");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                teams.add(new ListStandings(object.getInt("position"),
                        new TeamEngland().getTeamMap().get(object.getJSONObject("team").getInt("id")),
                        object.getJSONObject("team").getString("name"), object.getString("form"),
                        object.getInt("won"), object.getInt("draw"), object.getInt("lost"),
                        object.getInt("playedGames"), object.getInt("points")
                ));
            }

            return teams;
        }
    }
}

