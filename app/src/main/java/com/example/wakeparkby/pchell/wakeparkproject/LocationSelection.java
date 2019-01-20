package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class LocationSelection extends AppCompatActivity implements View.OnClickListener {
    private Button buttDrozdy;
    private Button buttLogoysk;
    private String locationName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selection);
        buttDrozdy = (Button) findViewById(R.id.buttonDrozdy);
        buttDrozdy.setOnClickListener((View.OnClickListener) this);
        buttLogoysk = (Button) findViewById(R.id.buttonLogoysk);
        buttLogoysk.setOnClickListener((View.OnClickListener) this);
    }


    @Override
    public void onClick(View v) {
        BookingDescription bookingDescription = new BookingDescription();
        ChooseTime chooseTime = new ChooseTime();
        Intent intent_TheCalendar = new Intent(this, TheСalendar.class);
        switch (v.getId()) {
            case R.id.buttonDrozdy:
                locationName = "Водохранилище Дрозды";
                bookingDescription.infoLocation(locationName);
                chooseTime.infoLocation(locationName);
                startActivity(intent_TheCalendar);
                break;
            case R.id.buttonLogoysk:
                locationName = "ГСОК ЛОГОЙСК";
                bookingDescription.infoLocation(locationName);
                chooseTime.infoLocation(locationName);
                startActivity(intent_TheCalendar);
                break;
        }
    }
}
