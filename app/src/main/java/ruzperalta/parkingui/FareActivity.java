package ruzperalta.parkingui;

import android.app.Activity;

import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class FareActivity extends Activity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);
        startTime = (TextView) findViewById(R.id.startTime);
        endTime = (TextView) findViewById(R.id.endTime);
        btnParking = findViewById(R.id.btnParking);
        btnCalculate = findViewById(R.id.btnCalculate);

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

                Toast.makeText(FareActivity.this, "Fare is " + fare + " pesos.", Toast.LENGTH_LONG).show();
            }
        });
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(FareActivity.this, new TimePickerDialog.OnTimeSetListener() {
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

                timePickerDialog = new TimePickerDialog(FareActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
                Intent i = new Intent(FareActivity.this, UserParkingActivity.class);
                startActivity(i);
                finish();
            }
        });
    }



}
