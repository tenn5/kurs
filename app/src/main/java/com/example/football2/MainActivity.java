package com.example.football2;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.football2.fragments.Container;
import com.example.football2.constants.Country;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, Container.getInstance(Country.ENGLAND), null).commit();
        toolbar.setTitle(R.string.menu_england);


        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_menu_24, null);
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, Color.BLACK);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::navigationItemSelected);
    }

    private boolean navigationItemSelected(MenuItem item) {
        Container container;
        switch (item.getItemId()){
            case R.id.nav_england:
                container = Container.getInstance(Country.ENGLAND);
                toolbar.setTitle(R.string.menu_england);
                break;
            case R.id.nav_germany:
                container = Container.getInstance(Country.GERMANY);
                toolbar.setTitle(R.string.menu_germany);
                break;
            case R.id.nav_spain:
                container = Container.getInstance(Country.SPAIN);
                toolbar.setTitle(R.string.menu_spain);
                break;
            case R.id.nav_france:
                container = Container.getInstance(Country.FRANCE);
                toolbar.setTitle(R.string.menu_france);
                break;
            default:
                container = Container.getInstance(Country.ITALY);
                toolbar.setTitle(R.string.menu_italy);
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, container, null).commit();
        return true;
    }

}