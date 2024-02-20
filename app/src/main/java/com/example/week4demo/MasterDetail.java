package com.example.week4demo;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.Fade;
import androidx.transition.Slide;
import java.util.Objects;
import androidx.transition.TransitionManager;

public class MasterDetail extends AppCompatActivity implements RecyclerItemClickListener {
    private boolean twoPane;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
        // If this is the first occurrence of opening the app
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new ListFragment()).commit();
        }
        twoPane=false;
        if(findViewById(R.id.detail_container)!=null){
            twoPane=true;
        }
    }

    @Override
    public void onItemClick(View sharedView, Movie selected_movie){
        Bundle args=new Bundle();
        args.putInt("ing_id",selected_movie.resource_id);
        args.putString("mtitle",selected_movie.name);
        args.putString("myear",selected_movie.year);
        args.putString("url",selected_movie.url);
        Fragment detailFragment = new DetailFragment();
        detailFragment.setArguments(args);
        if(twoPane){
            detailFragment.setEnterTransition(new Slide(Gravity.TOP));
            detailFragment.setExitTransition(new Slide(Gravity.BOTTOM));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container,detailFragment)
                    .addToBackStack(null).commit();
        } else {
            detailFragment.setSharedElementEnterTransition(new AutoTransition());
            detailFragment.setEnterTransition(new Fade());
            detailFragment.setExitTransition(new Fade());
            detailFragment.setSharedElementEnterTransition(new AutoTransition());
            getSupportFragmentManager().beginTransaction()
                    .addSharedElement(sharedView, Objects.requireNonNull(ViewCompat.getTransitionName(sharedView)))
                    .replace(R.id.main_container,detailFragment)
                    .addToBackStack(null).commit();
        }
    }
}
