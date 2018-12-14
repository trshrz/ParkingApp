package ruzperalta.parkingui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ParkingActivity extends AppCompatActivity {
    Button btnFare;
    ImageView car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,car11,car12;
    FirebaseDatabase database;
    DatabaseReference myRef;
    LinearLayout pSlot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        pSlot = findViewById(R.id.slot1);
        database = FirebaseDatabase.getInstance();
        showSlots();
        car1 = findViewById(R.id.car1);
//        car2 = findViewById(R.id.car2);
//        car3 = findViewById(R.id.car3);
//        car4 = findViewById(R.id.car4);
//        car5 = findViewById(R.id.car5);
//        car6 = findViewById(R.id.car6);
        car7 = findViewById(R.id.car7);
        car8 = findViewById(R.id.car8);
        car9 = findViewById(R.id.car9);
        car10 = findViewById(R.id.car10);
        car11 = findViewById(R.id.car11);
        car12 = findViewById(R.id.car12);
        pSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if(value.equals(false)){
                            dataSnapshot.getRef().setValue(true);
                            car1.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btnFare = findViewById(R.id.btnFare);
        btnFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ParkingActivity.this, FareActivity.class);
                startActivity(i);
                finish();
            }
        });
        car1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ParkingActivity.this, "is clicked", Toast.LENGTH_SHORT).show();
                myRef = database.getReference("ParkingSlot");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if(value.equals(true)){
                            dataSnapshot.getRef().setValue(false);
                            car1.setVisibility(View.INVISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                showSlots();
            }
        });

    }
    public void showSlots(){

        myRef = database.getReference("ParkingSlot");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)){
                    car1.setVisibility(View.VISIBLE);
                }else if(value.equals(false)){
                    car1.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
