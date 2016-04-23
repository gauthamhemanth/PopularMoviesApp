package com.example.gauthamhemanth.popularmoviesapp;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
ArrayList<Movie> mPopularList;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.gridview_movies);
        new ServiceSync().execute();

    }
    public class ServiceSync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            String WebAddress;
            String WebAddressVote;


            WebAddress = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=dde384572ac925002b885348b50244c7"
            ;

            WebAddressVote = "http://api.themoviedb.org/3/discover/movie?sort_by=vote_average.desc&api_key=dde384572ac925002b885348b50244c7"
            ;

            mPopularList = new ArrayList<>();
            ArrayList<Movie> mTopVotedList = new ArrayList<>();
            MovieApiCall mService = new MovieApiCall();

            mService.URLResult(WebAddress, mPopularList);
            mService.URLResult(WebAddressVote, mTopVotedList);

            mPopularList.toString();
            loadMovieAdapter(mPopularList);


            return null;
        }
    }

    private void loadMovieAdapter(ArrayList<Movie> mPopularList) {
        MovieAdapter adapter = new MovieAdapter(MainActivity.this,mPopularList);
        gridView.setAdapter(adapter);
    }
}
