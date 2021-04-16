package com.example.footbal2.ui.england;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.AdapterListStandings;
import com.example.footbal2.GetTeams;
import com.example.footbal2.ListStandings;
import com.example.footbal2.R;
import com.example.footbal2.constants.GetRequest;
import com.example.footbal2.constants.TeamEngland;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
                teams = new GetTeams().getTeams(jsonObject, new TeamEngland().getTeamMap());

                rv = view.findViewById(R.id.standings_england);

                rv.setHasFixedSize(true);

                rv.setLayoutManager( new LinearLayoutManager(requireContext()));
                rv.setAdapter(new AdapterListStandings(requireContext(), teams));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }
}

