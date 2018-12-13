package ruzperalta.parkingui;


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
    EditText etSignupEmail;
    EditText etSignupPassword;
    EditText etSignupConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);
//        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        btnLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.userEmail);
        etPassword = findViewById(R.id.userPassword);
        etSignupEmail = findViewById(R.id.signEmail);
        etSignupPassword = findViewById(R.id.signPassword);
        etSignupConfirm = findViewById(R.id.signConfirm);
        mAuth = FirebaseAuth.getInstance();
//        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
//        mViewPager.setAdapter(swipeAdapter);
        btnSignup = findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etSignupEmail.getText().toString().trim();
                String password = etSignupPassword.getText().toString().trim();
                String confirm = etSignupConfirm.getText().toString().trim();
                if(password.equals(confirm)){
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(MainActivity.this, "User successfully created!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(MainActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();


                                    }

                                    // ...
                                }
                            });
                }else{
                    Toast.makeText(MainActivity.this, "Password do not match. Please try again.", Toast.LENGTH_SHORT).show();
                }

            }
        });
//        btnLogin.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = etEmail.getText().toString().trim();
//                String password = etPassword.getText().toString().trim();
//                mAuth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(MainActivity.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
//
//
//
//                                } else {
//                                    // If sign in fails, display a message to the user.
//                                    Toast.makeText(MainActivity.this, "Login Failed.", Toast.LENGTH_SHORT).show();
//
//
//                                }
//
//                                // ...
//                            }
//                        });
//            }
//        });
    }






}
