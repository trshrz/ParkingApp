package ruzperalta.parkingui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.*;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);


        TimePickerDialog tpd = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_HOLO_DARK,this,hour,minute,false);


        return tpd;
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        // Do something with the returned time

        TextView startTime = (TextView) getActivity().findViewById(R.id.startTime);
        TextView endTime = (TextView) getActivity().findViewById(R.id.endTime);
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
                    endTime.setText(hour_of_12_hour_format + " : " + minute + " : " + status);


    }
}
