package ruzperalta.parkingui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserParkingFragment extends Fragment {

    FirebaseDatabase database;
    DatabaseReference myRef;
    Button btnFare;
    ImageView car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,car11,car12;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user, container, false);

        database = FirebaseDatabase.getInstance();
        car1 = view.findViewById(R.id.car1);
        car2 = view.findViewById(R.id.car2);
        car3 = view.findViewById(R.id.car3);
        car4 = view.findViewById(R.id.car4);
        car5 = view.findViewById(R.id.car5);
//        car6 = findViewById(R.id.car6);
        car7 = view.findViewById(R.id.car7);
        car8 = view.findViewById(R.id.car8);
        car9 = view.findViewById(R.id.car9);
        car10 = view.findViewById(R.id.car10);
        car11 = view.findViewById(R.id.car11);

        showSlots();
        btnFare = view.findViewById(R.id.btnFare);
        btnFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), FareFragment.class);
                startActivity(i);
            }
        });
        return view;
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
