package ruzperalta.parkingui;


import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.*;

public class MainActivity extends AppCompatActivity   {
    ViewPager mViewPager;
    private FirebaseAuth mAuth;
    Button btnLogin;
    EditText etEmail;
    EditText etPassword;
    Button btnSignup;

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
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                Task<AuthResult> authResultTask = mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(MainActivity.this, ParkingActivity.class);
                                    startActivity(i);
                                    finish();


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






}
