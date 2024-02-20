package com.example.week4demo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter{
    MovieData movieData;
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, MovieData _movieData){
        super(fragmentActivity);
        movieData = _movieData;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position){
        Fragment fragment = new ViewPagerFragment();
        Bundle args = new Bundle();
        args.putString(ViewPagerFragment.ARG_TITLE, movieData.getItem(position).name);
        args.putString(ViewPagerFragment.ARG_YEAR, movieData.getItem(position).year);
        args.putInt(ViewPagerFragment.POSTER_ID, movieData.getItem(position).resource_id);
        args.putString(ViewPagerFragment.DESCRIPTION, movieData.getItem(position).desc);
        args.putString(ViewPagerFragment.URL, movieData.getItem(position).url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return movieData.getSize();
    }
}
