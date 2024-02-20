package com.example.week4demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rooView=inflater.inflate(R.layout.detail_view, container, false);
        ImageView imageView=(ImageView) rooView.findViewById(R.id.img_poster);
        TextView title=(TextView) rooView.findViewById(R.id.title);
        TextView year=(TextView) rooView.findViewById(R.id.year);
        Bundle args=getArguments();
        int resource_id=args.getInt("img_id", -1);
        if (resource_id != -1){
            imageView.setImageResource(resource_id);
        }else {
            Picasso.get().load(args.getString("url")).into(imageView);
        }
        title.setText(args.getString("mtitle"));
        ViewCompat.setTransitionName(imageView,args.getString("mtitle"));
        year.setText(args.getString("myear"));
        return rooView;
    }
}
