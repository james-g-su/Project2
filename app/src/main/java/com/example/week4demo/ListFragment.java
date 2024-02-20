package com.example.week4demo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class ListFragment  extends Fragment {
    RecyclerItemClickListener clickListener;

    private final SimpleRecyclerAdapter myRecyclerAdapter=new SimpleRecyclerAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooView=inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView rv=rooView.findViewById(R.id.mainRecyclerView);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(myRecyclerAdapter);
        rv.setItemAnimator(new DefaultItemAnimator());
        return rooView;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            clickListener=(RecyclerItemClickListener)context;
            myRecyclerAdapter.setOnItemClickListener(clickListener);
        }
        catch(ClassCastException ex){
            throw new ClassCastException(context.toString()+" must implement EventTrack");
        }
    }
}
