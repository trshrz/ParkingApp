package ruzperalta.parkingui;

import android.app.Activity;

import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class FareActivity extends Activity {

    TextView startTime;
    TextView endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
        startTime = (TextView) findViewById(R.id.startTime);
        endTime = (TextView) findViewById(R.id.endTime);

        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dFragment = new TimePickerFragment();
                dFragment.show(getFragmentManager(),"Time Picker");
            }
        });

        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dFragment = new TimePickerFragment();
                dFragment.show(getFragmentManager(),"Time Picker");
            }
        });
    }



}
