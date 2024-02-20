package com.example.week4demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NavDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        // Set up main toolbar
        toolbar=(Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        // Set up Navigation Drawer
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,
                drawerLayout,toolbar,
                // most likely the image display on the xml file
                R.string.opened,
                R.string.closed){
            @Override
            public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
                //Toast toast= Toast.makeText(NavDrawer.this,"NavigationDrawer closed",Toast.LENGTH_SHORT);
                //toast.show();
            }

            @Override
            public void onDrawerOpened(View drawerView){
                super.onDrawerClosed(drawerView);
                //Toast toast= Toast.makeText(NavDrawer.this,"NavigationDrawer opened",Toast.LENGTH_SHORT);
                //toast.show();
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        loadAboutMe();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        int id=item.getItemId();
        if (id == R.id.item1) {
            startActivity(new Intent(this, MasterDetail.class));
        } else if (id == R.id.item2) {
            startActivity(new Intent(this, ViewPager.class));
        } else if (id == R.id.item3) {
            startActivity(new Intent(this, NavDrawer.class));
        } else if (id == R.id.item4) {
            startActivity(new Intent(this, RandomMovie.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadAboutMe(){
        Bundle args=new Bundle();
        args.putString("mtitle","James Gillis");
        args.putString("myear",
                "Hello!  This is an about me section.  Here are some words" +
                        "\nand here are some more words! Aren't words great?");
        args.putString("url","https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/37b45cc0-364f-497c-9a38-fb1c5ba4cda0/dgx2yr5-94a26448-2a71-46dd-89fa-6c81c1341309.png/v1/fill/w_1920,h_1440,q_80,strp/undead_skeleton_hunter_on_boat_adoptable_7__by_dissunder_dgx2yr5-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzM3YjQ1Y2MwLTM2NGYtNDk3Yy05YTM4LWZiMWM1YmE0Y2RhMFwvZGd4MnlyNS05NGEyNjQ0OC0yYTcxLTQ2ZGQtODlmYS02YzgxYzEzNDEzMDkucG5nIiwiaGVpZ2h0IjoiPD0xNDQwIiwid2lkdGgiOiI8PTE5MjAifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uud2F0ZXJtYXJrIl0sIndtayI6eyJwYXRoIjoiXC93bVwvMzdiNDVjYzAtMzY0Zi00OTdjLTlhMzgtZmIxYzViYTRjZGEwXC9kaXNzdW5kZXItNC5wbmciLCJvcGFjaXR5Ijo5NSwicHJvcG9ydGlvbnMiOjAuNDUsImdyYXZpdHkiOiJjZW50ZXIifX0.qY-dYU-eNprYDGaXRFWpxGWegtzYqriEtsLX5VJdNXM");
        Fragment detailFragment = new DetailFragment();
        detailFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_activity_container,detailFragment)
                .addToBackStack(null).commit();
    }
 }
