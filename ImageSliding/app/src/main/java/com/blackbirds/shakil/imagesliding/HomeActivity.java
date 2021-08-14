package com.blackbirds.shakil.imagesliding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navView;
    AppBarConfiguration appBarConfiguration;
    NavController navController;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView = findViewById(R.id.bottomNav_view);

        //Pass the ID's of Different destinations
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_profile, R.id.navigation_exit)
                .build();

        //Initialize NavController.
        navController = Navigation.findNavController(this, R.id.navHostFragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_business:
                startActivity(new Intent(this, BusinessActivity.class));
                if (drawerLayout.isOpen()) {
                    drawerLayout.close();
                }
                break;

            case R.id.navigation_green:
                startActivity(new Intent(this, GreenActivity.class));
                if (drawerLayout.isOpen()) {
                    drawerLayout.close();
                }
                break;

            case R.id.navigation_our_story:
                startActivity(new Intent(this, OurStoryActivity.class));
                if (drawerLayout.isOpen()) {
                    drawerLayout.close();
                }
                break;

            case R.id.navigation_showcase:
                startActivity(new Intent(this, ShowcaseActivity.class));
                if (drawerLayout.isOpen()) {
                    drawerLayout.close();
                }
                break;

            case R.id.navigation_landowner:
                startActivity(new Intent(this, LandownerActivity.class));
                if (drawerLayout.isOpen()) {
                    drawerLayout.close();
                }
                break;

            case R.id.navigation_project:
                Toast.makeText(this, "Project", Toast.LENGTH_SHORT).show();
                if (drawerLayout.isOpen()) {
                    drawerLayout.close();
                }
                break;
        }
        return true;
    }
}