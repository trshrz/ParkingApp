package ruzperalta.parkingui;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener   {
    ViewPager mViewPager;
    private FirebaseAuth mAuth;
    Button btnLogin;
    EditText etEmail;
    EditText etPassword;
    Button btnSignup;
    private DrawerLayout main_drawer;

    TextView btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        btnLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.userEmail);
        etPassword = findViewById(R.id.userPassword);

        mAuth = FirebaseAuth.getInstance();
//        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
//        mViewPager.setAdapter(swipeAdapter);
        btnCreate = findViewById(R.id.createAccount);
        btnCreate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                final String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                Task<AuthResult> authResultTask = mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
                                    if(email.equals("admin@gmail.com")){
                                        Intent i = new Intent(MainActivity.this, ParkingFragment.class);
                                        startActivity(i);
                                        finish();
                                    }else{
                                        Intent i = new Intent(MainActivity.this, UserParkingFragment.class);
                                        startActivity(i);
                                        finish();
                                    }


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity.this, "Login Failed.", Toast.LENGTH_SHORT).show();



                                }

                                // ...
                            }
                        });
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navParking:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container, new UserParkingFragment()).addToBackStack(null).commit();
                break;
            case R.id.navFareCalculator:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container, new FareFragment()).addToBackStack(null).commit();
                break;
            case R.id.navSettings:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,
                        new SettingsFragment()).addToBackStack(null).commit();
                break;
            case R.id.navLogout:
//                try {
//                    AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            Intent logoutUser = new Intent(MainActivity.this, MainActivity.class);
//
//                            createAndShowToast(MainActivity.this, "Successfully logged out");
//
//                            startActivity(logoutUser);
//                        }
//                    });
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
        }

        main_drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        getSupportFragmentManager().executePendingTransactions();
        if (main_drawer.isDrawerOpen(GravityCompat.START)) {
            main_drawer.closeDrawer(GravityCompat.START);
        } else {

        }
    }



    public static void createAndShowToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }




}
