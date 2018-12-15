package ruzperalta.parkingui;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class AdminMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener   {


    private DrawerLayout main_drawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeViews();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {



        switch (menuItem.getItemId()) {
            case R.id.navParking:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container, new ParkingFragment()).addToBackStack(null).commit();
                break;
            case R.id.navFareCalculator:
//                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container, new FareFragment()).addToBackStack(null).commit();
                break;
            case R.id.navSettings:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,
                        new SettingsFragment()).addToBackStack(null).commit();
                break;
            case R.id.navLogout:
                try {
                    AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            FirebaseAuth.getInstance().signOut();

                            Intent logoutUser = new Intent(AdminMainActivity.this, LoginActivity.class);



                            startActivity(logoutUser);
                            finish();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

        main_drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.drawer_menu, menu);
        MenuItem fare = menu.findItem(R.id.navFareCalculator);
        fare.setVisible(false);
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().executePendingTransactions();
        if (main_drawer.isDrawerOpen(GravityCompat.START)) {
            main_drawer.closeDrawer(GravityCompat.START);
        } else {

        }
    }

    private void initializeViews() {
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        main_drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, main_drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        main_drawer.addDrawerListener(toggle);
        toggle.syncState();

        ParkingFragment parkingFragment = new ParkingFragment();

        getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container, parkingFragment)
                .commit();
        main_drawer.closeDrawer(GravityCompat.START);
    }
}
