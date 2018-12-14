package ruzperalta.parkingui;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ParkingFragment extends Fragment {
    Button btnFare;
    ImageView car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,car11,car12;
    FirebaseDatabase database;
    DatabaseReference myRef;
    LinearLayout pSlot, pSlot2, pSlot3, pSlot4, pSlot5, pSlot6 ,pSlot7, pSlot8, pSlot9, pSlot10, pSlot11, pSlot12;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_parking, container, false);
        pSlot = view.findViewById(R.id.slot1);
        pSlot2 = view.findViewById(R.id.slot2);
        pSlot3 = view.findViewById(R.id.slot3);
        pSlot4 = view.findViewById(R.id.slot4);
        pSlot5 = view.findViewById(R.id.slot5);
        pSlot7 = view.findViewById(R.id.slot7);
        pSlot8 = view.findViewById(R.id.slot8);
        pSlot9 = view.findViewById(R.id.slot9);
        pSlot10 = view.findViewById(R.id.slot10);
        pSlot11 = view.findViewById(R.id.slot11);
        database = FirebaseDatabase.getInstance();
        showSlots();
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
//        car12 = findViewById(R.id.car12);
        pSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
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
        pSlot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot2");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            car2.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        pSlot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot3");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            car3.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        pSlot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot4");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            car4.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        pSlot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot5");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            car5.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
//        pSlot6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myRef = database.getReference("ParkingSlot6");
//                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        Boolean value = dataSnapshot.getValue(Boolean.class);
//                        if(value.equals(false)){
//                            dataSnapshot.getRef().setValue(true);
//                            car6.setVisibility(View.VISIBLE);
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
//            }
//        });
        pSlot7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot7");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            car7.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        pSlot8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot8");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            car8.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        pSlot9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot9");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            car9.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        pSlot10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot10");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            car10.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        pSlot11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference("ParkingSlot11");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(false)) {
                            dataSnapshot.getRef().setValue(true);
                            car11.setVisibility(View.VISIBLE);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        car1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAndShowToast(getContext(), " is clicked.");
                myRef = database.getReference("ParkingSlot");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(true)) {
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
        car2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAndShowToast(getContext(), " is clicked.");
                myRef = database.getReference("ParkingSlot2");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(true)) {
                            dataSnapshot.getRef().setValue(false);
                            car2.setVisibility(View.INVISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                showSlots();
            }
        });
        car3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAndShowToast(getContext(), " is clicked.");
                myRef = database.getReference("ParkingSlot3");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(true)) {
                            dataSnapshot.getRef().setValue(false);
                            car3.setVisibility(View.INVISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                showSlots();
            }
        });
        car4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAndShowToast(getContext(), " is clicked.");
                myRef = database.getReference("ParkingSlot4");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(true)) {
                            dataSnapshot.getRef().setValue(false);
                            car4.setVisibility(View.INVISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                showSlots();
            }
        });
        car5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAndShowToast(getContext(), " is clicked.");
                myRef = database.getReference("ParkingSlot5");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(true)) {
                            dataSnapshot.getRef().setValue(false);
                            car5.setVisibility(View.INVISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                showSlots();
            }
        });
        car7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAndShowToast(getContext(), " is clicked.");
                myRef = database.getReference("ParkingSlot7");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(true)) {
                            dataSnapshot.getRef().setValue(false);
                            car7.setVisibility(View.INVISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                showSlots();
            }
        });
        car8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAndShowToast(getContext(), " is clicked.");
                myRef = database.getReference("ParkingSlot8");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(true)) {
                            dataSnapshot.getRef().setValue(false);
                            car8.setVisibility(View.INVISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                showSlots();
            }
        });
        car9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAndShowToast(getContext(), " is clicked.");
                myRef = database.getReference("ParkingSlot9");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(true)) {
                            dataSnapshot.getRef().setValue(false);
                            car9.setVisibility(View.INVISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                showSlots();
            }
        });
        car10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAndShowToast(getContext(), " is clicked.");
                myRef = database.getReference("ParkingSlot10");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(true)) {
                            dataSnapshot.getRef().setValue(false);
                            car10.setVisibility(View.INVISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                showSlots();
            }
        });
        car11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createAndShowToast(getContext(), " is clicked.");
                myRef = database.getReference("ParkingSlot11");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.getValue(Boolean.class);
                        if (value.equals(true)) {
                            dataSnapshot.getRef().setValue(false);
                            car11.setVisibility(View.INVISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                showSlots();
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


        public static void createAndShowToast(Context context, String message) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }


}
