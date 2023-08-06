package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;

public class NavMenu extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ConstraintLayout constraintLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        constraintLayout = findViewById(R.id.constraintLayout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_Open,R.string.menu_Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Log.i("MENU_DRAWER_TAG", "MenuBar is called");
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i("MENU_DRAWER_TAG", "NavBar is clicked");
                if(item.getItemId() == R.id.nav_home){
                    Log.i("MENU_DRAWER_TAG", "Home item is clicked bla");
                    Intent intent2 = new Intent(NavMenu.this, MainActivity.class);
                    startActivity(intent2);
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.nav_uebungAnlegen){
                    Intent intent = new Intent(NavMenu.this, UebungAnlegen.class);
                    startActivity(intent);
                    Log.i("MENU_DRAWER_TAG", "Übung Anlegen item is clicked");

                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.nav_uebungTracken){
                    Intent intent = new Intent(NavMenu.this, UebungTracken.class);
                    startActivity(intent);
                    Log.i("MENU_DRAWER_TAG", "Home2 item is clicked Bla");
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.nav_workoutAnlegen){
                    Intent intent = new Intent(NavMenu.this, WorkoutAnlegen.class);
                    startActivity(intent);
                    Log.i("MENU_DRAWER_TAG", "Home3 item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.nav_workoutTracken){
                    Intent intent = new Intent(NavMenu.this, WorkoutTracken.class);
                    startActivity(intent);
                    Log.i("MENU_DRAWER_TAG", "Home4 item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.nav_dashboard){
                    Log.i("MENU_DRAWER_TAG", "Share item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.nav_search){
                    Intent intent = new Intent(NavMenu.this, Search.class);
                    startActivity(intent);
                    Log.i("MENU_DRAWER_TAG", "Search ** item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if(item.getItemId() == R.id.nav_overview){
                    Intent intent = new Intent(NavMenu.this, Overview.class);
                    startActivity(intent);
                    Log.i("MENU_DRAWER_TAG", "Overview item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if(item.getItemId() == R.id.nav_einstellungen){
                    Intent intent = new Intent(NavMenu.this, Settings.class);
                    startActivity(intent);
                    Log.i("MENU_DRAWER_TAG", "Settings item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                item.setChecked(true);

                return true;
            }
        });
    }

}