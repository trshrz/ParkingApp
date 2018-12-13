package ruzperalta.parkingui;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class FareActivity extends AppCompatActivity {

    TextView startTime;
    TextView endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);
        startTime = (TextView) findViewById(R.id.startTime);
        endTime = (TextView) findViewById(R.id.endTime);
    }

    public void setStartTime(View v) {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog;
            timePickerDialog = new TimePickerDialog(FareActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    String status = "AM";

                    if(hourOfDay > 11) {
                        status = "PM";
                    }

                    int hour_of_12_hour_format;
                    if(hourOfDay > 11){
                        hour_of_12_hour_format = hourOfDay - 12;
                    }
                    else {
                        hour_of_12_hour_format = hourOfDay;
                    }
                    startTime.setText(hour_of_12_hour_format + " : " + minute + " : " + status);
                }
            }, hour, minute, false);
            timePickerDialog.show();
    }

    public void setEndTime(View v) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog;
        timePickerDialog = new TimePickerDialog(FareActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                endTime.setText(hourOfDay+":"+minute);
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }



}
