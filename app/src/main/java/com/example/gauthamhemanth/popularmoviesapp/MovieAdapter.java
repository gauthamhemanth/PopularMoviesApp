package com.example.gauthamhemanth.popularmoviesapp;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by GauthamHemanth on 3/28/16.
 */
public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movieList;

    private int[] images = {R.drawable.interstellar, R.drawable.interstellar
                            ,R.drawable.interstellar, R.drawable.interstellar
                            , R.drawable.interstellar};

    public MovieAdapter (Context c, ArrayList<Movie> movieList){
        context =c;
        this.movieList = movieList;
    }



    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        /*if(convertView==null){
            imageView= new ImageView(context);

   //         imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
   //       imageView.setPadding(8,8,8,8);
        }
        else{
            imageView = (ImageView) convertView;
        }
        Picasso.with(context).load(images[position]).resize(300,300).into(imageView);
         return imageView;
*/


        Movie movieObj = new Movie();


        ImageView imageViewcustom = new ImageView(context);
        Picasso.with(context).load("https://image.tmdb.org/t/p/w185" + movieObj.getPoster_path())

                .into(imageViewcustom);

        return imageViewcustom;







    }

}
