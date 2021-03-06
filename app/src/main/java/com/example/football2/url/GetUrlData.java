package com.example.football2.url;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.football2.R;
import com.example.football2.auxiliary.DataInfoTeam;
import com.example.football2.auxiliary.DataMatch;
import com.example.football2.auxiliary.DataActivity;
import com.example.football2.constants.TypeData;
import com.example.football2.recycler.AdapterListMatch;
import com.example.football2.recycler.AdapterListSquad;
import com.example.football2.recycler.AdapterListStandings;
import com.example.football2.recycler.ListMatch;
import com.example.football2.recycler.ListSquad;
import com.example.football2.recycler.ListStandings;
import com.example.football2.constants.GetRequest;

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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetUrlData extends AsyncTask<String, String, String> {

    private DataActivity dataActivity;
    private DataMatch dataMatch;
    private DataInfoTeam dataInfoTeam;

    private final AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            int matchDay = Integer.parseInt(((String)parent.getItemAtPosition(position)).split(" ")[0]);

            GetUrlData getUrlData = new GetUrlData(new DataActivity(dataActivity.getContext(), dataActivity.getRecyclerView(), TypeData.MATCH));
            GetRequest constRequest = new GetRequest();

            switch (dataMatch.getCountry()){
                case ENGLAND:
                    getUrlData.execute(constRequest.getMatchesEnglandByTour() + matchDay);
                    break;
                case GERMANY:
                    getUrlData.execute(constRequest.getMatchesGermanyByTour() + matchDay);
                    break;
                case SPAIN:
                    getUrlData.execute(constRequest.getMatchesSpainByTour() + matchDay);
                    break;
                case FRANCE:
                    getUrlData.execute(constRequest.getMatchesFranceByTour() + matchDay);
                    break;
                default:
                    getUrlData.execute(constRequest.getMatchesItalyByTour() + matchDay);
                    break;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    public GetUrlData(DataActivity dataActivity) {
        this.dataActivity = dataActivity;
    }

    public GetUrlData(DataActivity dataActivity, DataMatch dataMatch) {
        this.dataActivity = dataActivity;
        this.dataMatch = dataMatch;
    }

    public GetUrlData(DataActivity dataActivity, DataInfoTeam dataInfoTeam){
        this.dataActivity = dataActivity;
        this.dataInfoTeam = dataInfoTeam;
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(strings[0]);  // ?????????????? URL ????????????????????
            connection = (HttpURLConnection) url.openConnection(); // ?????????????? Http ????????????????????
            connection.setRequestProperty(new GetRequest().getKey(), new GetRequest().getValue());
            connection.connect();

            InputStream stream = connection.getInputStream(); // ?????????????? ??????????
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer(); // ?????????????? ????????????, ???? ?????????? ???????????????? ?????? ???????????? ?? BufferedReader
            String line;

            while ((line = reader.readLine()) != null) { // ?????????????????? ?????????? ??????????????????
                buffer.append(line).append("\n"); //???????????????????? ???????????? ?? ???????????????????? ?? ?????????????????? ?????????? ????????????
            }

            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // ?????????????????? ????????????
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

    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
        if (result == null){
            return;
        }
        try {
            if (dataActivity.getTypeData() != TypeData.SPINNER) {
                dataActivity.getRecyclerView().setHasFixedSize(true);
                dataActivity.getRecyclerView().setLayoutManager(new LinearLayoutManager(dataActivity.getContext()));
            }
            switch (dataActivity.getTypeData()) {
                case STANDINGS:
                    dataActivity.getRecyclerView().setAdapter(
                            new AdapterListStandings(dataActivity.getContext(), createTeams(new JSONObject(result))));
                    break;
                case MATCH:
                    dataActivity.getRecyclerView().setAdapter(
                            new AdapterListMatch(dataActivity.getContext(), createMatch(new JSONObject(result))));
                    break;
                case INFO:
                    dataActivity.getRecyclerView().setAdapter(
                            new AdapterListSquad(dataActivity.getContext(), setInfoTeam(new JSONObject(result))));
                    break;
                default:
                    setSpinner(new JSONObject(result));
                    break;
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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(dataActivity.getContext(),
                R.layout.spinner_item, array);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        dataMatch.getSpinner().setAdapter(adapter);
        dataMatch.getSpinner().setOnItemSelectedListener(itemSelectedListener);

    }

    private List<ListSquad> setInfoTeam(JSONObject jsonObject) throws JSONException{
        dataInfoTeam.getNameTeam().setText(jsonObject.getString("name")
                .replaceAll(new GetRequest().getRegexNameTeam(), "")
                .replace("1.", "")
                .trim().replaceAll("\\s{2,}", " "));

        Utils.fetchSvg(dataActivity.getContext(), jsonObject.getString("crestUrl"), dataInfoTeam.getImageView());
        dataInfoTeam.getVenue().setText(jsonObject.getString("venue"));
        dataInfoTeam.getFounded().setText(jsonObject.getString("founded"));
        dataInfoTeam.getWebsite().setOnClickListener(v -> {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(jsonObject.getString("website")));
                dataActivity.getContext().startActivity(browserIntent);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });

        List<ListSquad> squad = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("squad");
        for (int i = 0; i < jsonArray.length(); i++){
            squad.add(new ListSquad(jsonArray.getJSONObject(i)));
        }

        List<String> compare = Arrays.asList("COACH", "ASSISTANT_COACH", "Goalkeeper", "Defender", "Midfielder", "Attacker");
        Collections.sort(squad, (object1, object2) -> {
            Integer firstId = compare.indexOf(object1.getPosition());
            Integer secondId = compare.indexOf(object2.getPosition());
            if (firstId.compareTo(secondId) == 0) {
                return object1.getName().compareTo(object2.getName());
            } else {
                return firstId.compareTo(secondId);
            }
        });
        return squad;
    }
}
