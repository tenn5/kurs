 package com.example.footbal2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.footbal2.fragments.Container;
import com.example.footbal2.fragments.Country;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::navigationItemSelected);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, Container.getInstance(Country.ENGLAND), null).commit();
        toolbar.setTitle(R.string.menu_england);
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