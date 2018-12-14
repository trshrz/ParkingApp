package ruzperalta.parkingui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserParkingActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    Button btnFare;
    ImageView car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,car11,car12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        database = FirebaseDatabase.getInstance();
        car1 = findViewById(R.id.car1);
        car2 = findViewById(R.id.car2);
        car3 = findViewById(R.id.car3);
        car4 = findViewById(R.id.car4);
        car5 = findViewById(R.id.car5);
//        car6 = findViewById(R.id.car6);
        car7 = findViewById(R.id.car7);
        car8 = findViewById(R.id.car8);
        car9 = findViewById(R.id.car9);
        car10 = findViewById(R.id.car10);
        car11 = findViewById(R.id.car11);

        showSlots();
        btnFare = findViewById(R.id.btnFare);
        btnFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserParkingActivity.this, FareActivity.class);
                startActivity(i);
                finish();
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
        myRef = database.getReference("ParkingSlot2");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)){
                    car2.setVisibility(View.VISIBLE);
                }else if(value.equals(false)){
                    car2.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef = database.getReference("ParkingSlot3");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)){
                    car3.setVisibility(View.VISIBLE);
                }else if(value.equals(false)){
                    car3.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef = database.getReference("ParkingSlot4");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)){
                    car4.setVisibility(View.VISIBLE);
                }else if(value.equals(false)){
                    car4.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef = database.getReference("ParkingSlot5");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)){
                    car5.setVisibility(View.VISIBLE);
                }else if(value.equals(false)){
                    car5.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        myRef = database.getReference("ParkingSlot6");
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Boolean value = dataSnapshot.getValue(Boolean.class);
//                if(value.equals(true)){
//                    car6.setVisibility(View.VISIBLE);
//                }else if(value.equals(false)){
//                    car6.setVisibility(View.INVISIBLE);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        myRef = database.getReference("ParkingSlot7");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)){
                    car7.setVisibility(View.VISIBLE);
                }else if(value.equals(false)){
                    car7.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef = database.getReference("ParkingSlot8");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)){
                    car8.setVisibility(View.VISIBLE);
                }else if(value.equals(false)){
                    car8.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef = database.getReference("ParkingSlot9");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)){
                    car9.setVisibility(View.VISIBLE);
                }else if(value.equals(false)){
                    car9.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef = database.getReference("ParkingSlot10");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)){
                    car10.setVisibility(View.VISIBLE);
                }else if(value.equals(false)){
                    car10.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRef = database.getReference("ParkingSlot11");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                if(value.equals(true)){
                    car11.setVisibility(View.VISIBLE);
                }else if(value.equals(false)){
                    car11.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
