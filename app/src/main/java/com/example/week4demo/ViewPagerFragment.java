package com.example.week4demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;
public class ViewPagerFragment extends Fragment{
    public static final String ARG_TITLE = "title";
    public static final String ARG_YEAR = "title";
    public static final String POSTER_ID = "poster";
    public static final String URL = "url";
    public static final String DESCRIPTION = "desc";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout

                .fragment_collection_object, container, false);
        ImageView poster = rootView.findViewById(R.id.movie_poster);
        Bundle args = getArguments();
        int resource_id = args.getInt(POSTER_ID, -1);
        if(resource_id != -1){
            poster.setImageResource(resource_id);
        } else {
            Picasso.get().load(args.getString(URL)).into(poster);
        }
        ((TextView) rootView.findViewById(R.id.movie_title)).setText(args.getString(ARG_TITLE));
        ((TextView) rootView.findViewById(R.id.movie_year)).setText(args.getString(ARG_YEAR));
        ((TextView) rootView.findViewById(R.id.descText)).setText(args.getString(DESCRIPTION));
        return rootView;
    }
}
