package com.example.week4demo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class RandomMovie extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_movie);

        MovieData movieList = new MovieData();
        int randNum = new Random().nextInt(movieList.getSize());
        Log.i("TROUBLESHOOTING","randNum is: " + randNum + " and movieList size is: " + movieList.getSize());

        Movie selected_movie = movieList.getItem(randNum);
        Log.i("TROUBLESHOOTING","selected_movie is: " + selected_movie.name);

        Bundle args=new Bundle();
        args.putInt("ing_id",selected_movie.resource_id);
        args.putString("mtitle",selected_movie.name);
        args.putString("myear",selected_movie.year);
        args.putString("url",selected_movie.url);
        Fragment detailFragment = new DetailFragment();
        detailFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.random_container,detailFragment)
                .addToBackStack(null).commit();
    }

}
