package com.example.footbal2.url;

import android.content.Context;
import android.os.AsyncTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.constants.TypeData;
import com.example.footbal2.recycler.AdapterListStandings;
import com.example.footbal2.recycler.ListStandings;
import com.example.footbal2.constants.GetRequest;

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

public class GetUrlData extends AsyncTask<String, String, String> {

    private Context context;
    private TypeData typeData;
    private RecyclerView rv;
    int matchDay;

    public GetUrlData(Context context, RecyclerView rv, TypeData typeData) {
        this.context = context;
        this.typeData = typeData;
        this.rv = rv;
    }

    public GetUrlData(Context context, RecyclerView rv, TypeData typeData, int matchDay) {
        this.context = context;
        this.typeData = typeData;
        this.rv = rv;
        this.matchDay = matchDay;
    }

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
            rv.setHasFixedSize(true);
            rv.setLayoutManager( new LinearLayoutManager(context));
            if (typeData == TypeData.STANDINGS){
                rv.setAdapter(new AdapterListStandings(context, createTeams(new JSONObject(result))));
            } else {
                rv.setAdapter(new AdapterListStandings(context, createMatch(new JSONObject(result), matchDay)));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<ListStandings> createTeams(JSONObject jsonObject) throws JSONException {
        List<ListStandings> teams = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("standings").getJSONObject(0).getJSONArray("table");
        for (int i = 0; i < jsonArray.length(); i++){
            teams.add(new ListStandings(jsonArray.getJSONObject(i)));
        }
        return teams;
    }

    public List<ListStandings> createMatch(JSONObject jsonObject, int matchDay) throws JSONException {
        List<ListStandings> teams = new ArrayList<>();
        return teams;
    }
}
