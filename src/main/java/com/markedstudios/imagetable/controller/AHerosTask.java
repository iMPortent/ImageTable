package com.markedstudios.imagetable.controller;


import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.markedstudios.imagetable.model.HeroModel;

import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AHerosTask extends AsyncTask<String, Void, ArrayList<HeroModel>> {

    @Override
    protected ArrayList<HeroModel> doInBackground(String... strings) {
        try {
            return heroMaker(connectHttp(strings[0]));
        } catch (JSONException io){

        }
        return null;
    }

    private String connectHttp (String urlQuery){
        String inputLine;

        try {

            URL url = new URL(urlQuery);
            HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("content-type","application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();

            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while((inputLine = bufferedReader.readLine())!=null){
                stringBuilder.append(inputLine);
            }

            bufferedReader.close();
            inputStreamReader.close();
            return stringBuilder.toString();

        }
        catch(IOException io){
            return "FAIL!";
        }
    }

    private ArrayList<HeroModel> heroMaker(String jsonString) throws JSONException {
        //JSONArray jsonArray = new JSONArray(jsonString);
        //ArrayList<HeroModel> heroModelArrayList = new ArrayList<>();
        Gson gson = new Gson();

        Type heroListType = new TypeToken<ArrayList<HeroModel>>(){}.getType();
        ArrayList<HeroModel> heroList = gson.fromJson(jsonString, heroListType);

        return heroList;
    }

}
