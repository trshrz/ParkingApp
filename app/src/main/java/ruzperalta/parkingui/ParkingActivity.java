package ruzperalta.parkingui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ParkingActivity extends AppCompatActivity {
    Button btnFare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnFare = findViewById(R.id.btnFare);
        btnFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ParkingActivity.this, FareActivity.class);
                startActivity(i);
                finish();
            }
        });

    }



}
