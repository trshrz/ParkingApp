package ruzperalta.parkingui;

import android.app.Activity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class FareFragment extends Fragment {

    TextView startTime;
    TextView endTime;
    Button btnParking;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;
    int hr, endhr;
    Button btnCalculate;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fare, container, false);
        startTime = view.findViewById(R.id.startTime);
        endTime = view.findViewById(R.id.endTime);
        btnParking = view.findViewById(R.id.btnParking);
        btnCalculate = view.findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fare,calculate;
                Log.e("Raffy", hr + "");
                Log.e("Raffy", endhr + "");
                if(hr > endhr){
                    endhr = endhr + 24;
                }
                calculate = endhr - hr;

                if(calculate > 3){
                    calculate = calculate - 3;
                    fare = 50 + (calculate*10);
                }else if(calculate == 0){
                    fare = 150;
                }else{
                    fare = 50;
                }

                createAndShowToast(getContext(), "Fare is " + fare + " pesos.");
            }
        });
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                            if(hourOfDay > 12){

                                hourOfDay = hourOfDay - 12;
                            }
                        } else {
                            amPm = "AM";
                        }
                        hr = hourOfDay + 12;
                        startTime.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();



            }
        });

        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                            if(hourOfDay > 12){

                                hourOfDay = hourOfDay - 12;
                            }
                        } else {
                            amPm = "AM";
                        }
                        endhr = hourOfDay + 12;
                        endTime.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();

            }
        });

        btnParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UserParkingFragment.class);
                startActivity(i);
            }
        });
        return view;
    }
    public static void createAndShowToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


}
