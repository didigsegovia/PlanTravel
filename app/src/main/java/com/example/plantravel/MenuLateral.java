package com.example.plantravel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MenuLateral extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lateral);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adicionar viagem", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                intent = new Intent(MenuLateral.this, AdicionarViagem.class);
                startActivity(intent);
            }
        });
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_new_travel, R.id.nav_friends,
                R.id.nav_account, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lateral, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home: {
                //Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show();
                Fragment fragmento = new Inicio();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();

                trans.replace(R.id.nav_host_fragment, fragmento);
                trans.addToBackStack(null);

                trans.commit();
                break;
            }
            case R.id.nav_new_travel: {
                //Toast.makeText(this, "Nova Viagem", Toast.LENGTH_SHORT).show();
                Fragment fragmento = new NewTravel();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();

                trans.replace(R.id.nav_host_fragment, fragmento);
                trans.addToBackStack(null);

                trans.commit();

                /*Intent it = new Intent(MenuLateral.this, NewTravel.class);
                startActivity(it);
                */
                break;
            }
            case R.id.nav_friends: {
                //Toast.makeText(this, "Amigos", Toast.LENGTH_SHORT).show();
                Fragment fragmento = new Perfil(this);
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();

                trans.replace(R.id.nav_host_fragment, fragmento);
                trans.addToBackStack(null);

                trans.commit();

                break;
            }
            case R.id.nav_account: {
                //Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show();
                /*Fragment fragmento = new Amigos(this);
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();

                trans.replace(R.id.nav_host_fragment, fragmento);
                trans.addToBackStack(null);

                trans.commit();
                */

                Intent it = new Intent(MenuLateral.this, AddAmigo.class);
                startActivity(it);
                break;
            }
            case R.id.nav_logout: {
                finish();
                Intent it = new Intent(MenuLateral.this, MainActivity.class);
                startActivity(it);
            }
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
