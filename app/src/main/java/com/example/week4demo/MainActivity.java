package com.example.week4demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding the toolbar
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(mainToolbar);
    }

    public void GoToViewPager(View view) {
        startActivity(new Intent(this, ViewPager.class));

    }

    public void GoToMasterDetail(View view) {
        startActivity(new Intent(this, MasterDetail.class));
    }

    public void GoToNavigationDrawer(View view) {
        startActivity(new Intent(this, NavDrawer.class));
    }

    public void GoToRandomMovie(View view) {
        startActivity(new Intent(this, RandomMovie.class));
    }
}