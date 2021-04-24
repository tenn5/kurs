package com.example.footbal2.url;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbal2.R;
import com.example.footbal2.constants.Country;
import com.example.footbal2.constants.TypeData;
import com.example.footbal2.recycler.AdapterListMatch;
import com.example.footbal2.recycler.AdapterListStandings;
import com.example.footbal2.recycler.ListMatch;
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
    private Spinner spinner;
    private int matchDay;
    private Country country;

    public GetUrlData(Context context, RecyclerView rv, TypeData typeData) {
        this.context = context;
        this.typeData = typeData;
        this.rv = rv;
    }

    public GetUrlData(Context context, Spinner spinner, TypeData typeData, Country country, RecyclerView rv) {
        this.context = context;
        this.spinner = spinner;
        this.typeData = typeData;
        this.country = country;
        this.rv = rv;
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
            if (typeData == TypeData.STANDINGS){
                rv.setHasFixedSize(true);
                rv.setLayoutManager( new LinearLayoutManager(context));
                rv.setAdapter(new AdapterListStandings(context, createTeams(new JSONObject(result))));
            } else if (typeData == TypeData.MATCH){
                rv.setHasFixedSize(true);
                rv.setLayoutManager( new LinearLayoutManager(context));
                rv.setAdapter(new AdapterListMatch(context, createMatch(new JSONObject(result))));
            } else if (typeData == TypeData.SPINNER){
                setSpinner(new JSONObject(result));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private List<ListStandings> createTeams(JSONObject jsonObject) throws JSONException {
        List<ListStandings> teams = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("standings").getJSONObject(0).getJSONArray("table");
        for (int i = 0; i < jsonArray.length(); i++){
            teams.add(new ListStandings(jsonArray.getJSONObject(i)));
        }
        return teams;
    }

    private List<ListMatch> createMatch(JSONObject jsonObject) throws JSONException {
        List<ListMatch> teams = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("matches");
        for (int i = 0; i < jsonArray.length(); i++){
            teams.add(new ListMatch(jsonArray.getJSONObject(i)));
        }
        return teams;
    }

    private void setSpinner(JSONObject jsonObject) throws JSONException {
        JSONArray jsonArray = jsonObject.getJSONArray("matches");
        int numberLastTour = jsonArray.getJSONObject(0).getJSONObject("season").getInt("currentMatchday");

        String[] array = new String[numberLastTour];
        for(int i = 0; i < numberLastTour; i++){
            array[i] = (numberLastTour - i) + " tour";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(itemSelectedListener);

    }

    private AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            matchDay = Integer.parseInt(((String)parent.getItemAtPosition(position)).split(" ")[0]);
            System.out.println(new GetRequest().getMatchesEnglandByTour() + matchDay);
            switch (country){
                case ENGLAND:
                    new GetUrlData(context, rv, TypeData.MATCH)
                            .execute(new GetRequest().getMatchesEnglandByTour() + matchDay);
                    break;
                case GERMANY:
                    new GetUrlData(context, rv, TypeData.MATCH)
                            .execute(new GetRequest().getMatchesGermanyByTour() + matchDay);
                    break;
                case SPAIN:
                    new GetUrlData(context, rv, TypeData.MATCH)
                            .execute(new GetRequest().getMatchesSpainByTour() + matchDay);
                    break;
                case FRANCE:
                    new GetUrlData(context, rv, TypeData.MATCH)
                            .execute(new GetRequest().getMatchesFranceByTour() + matchDay);
                    break;
                default:
                    new GetUrlData(context, rv, TypeData.MATCH)
                            .execute(new GetRequest().getMatchesItalyByTour() + matchDay);
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

}
