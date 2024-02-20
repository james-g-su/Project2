package com.example.week4demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements RecyclerItemClickListener {
    private RecyclerView recycler_view;
    private SimpleRecyclerAdapter adapter_items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recycler_view = (RecyclerView)findViewById(R.id.recycler_view);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recycler_view.setLayoutManager(layoutManager);
        adapter_items = new SimpleRecyclerAdapter();
        adapter_items.setOnItemClickListener(this);
        recycler_view.setAdapter(adapter_items);
        //recycler_view.setItemAnimator(new DefaultItemAnimator());
    }
    public void AddNewMovie(View view) {
        EditText name=(EditText)findViewById(R.id.new_movie_name);
        EditText year=(EditText)findViewById(R.id.new_movie_year);
        adapter_items.addMovie(name.getText().toString(), year.getText().toString());
        recycler_view.smoothScrollToPosition(5);
    }

    @Override
    public void onItemClick(View v, Movie movie) {
        Toast t= Toast.makeText(getApplicationContext(),"Movie name: "+movie.name, Toast.LENGTH_SHORT);
        t.show();
    }
}