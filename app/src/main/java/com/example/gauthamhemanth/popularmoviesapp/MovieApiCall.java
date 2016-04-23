package com.example.gauthamhemanth.popularmoviesapp;



import android.util.Log;

import com.google.common.io.ByteStreams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by GauthamHemanth on 4/18/16.
 */
public class MovieApiCall {
    public void URLResult(String string, ArrayList<Movie> movieList){
        try{
            URL url = new URL(string);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            String results = new String(ByteStreams.toByteArray(inputStream));
            jsonParser(results, movieList);
            inputStream.close();


        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void jsonParser(String results, ArrayList<Movie> movieList){
        try {
            JSONObject mainObject = new JSONObject(results);

            JSONArray resultsArray = mainObject.getJSONArray("results");
            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject indexObject = resultsArray.getJSONObject(i);
                Movie indexMovie = new Movie();
                indexMovie.setBackdrop_path(indexObject.getString("backdrop_path"));
                indexMovie.setId(indexObject.getInt("id"));
                indexMovie.setOriginal_title(indexObject.getString("original_title"));
                indexMovie.setOverview(indexObject.getString("overview"));
                indexMovie.setRelease_date(indexObject.getString("release_date"));
                indexMovie.setPoster_path(indexObject.getString("poster_path"));
                indexMovie.setPopularity(indexObject.getDouble("popularity"));
                indexMovie.setTitle(indexObject.getString("title"));
                indexMovie.setVote_average(indexObject.getInt("vote_average"));
                indexMovie.setVote_count(indexObject.getInt("vote_count"));

                movieList.add(indexMovie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("", "JSON Error", e);
        }
    }
}
