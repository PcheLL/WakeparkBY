package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class LocationSelection extends AppCompatActivity implements View.OnClickListener {
private Button buttDrozdy;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selection);
        buttDrozdy = (Button) findViewById(R.id.buttonDrozdy);
        buttDrozdy.setOnClickListener((View.OnClickListener) this);
    }


    @Override
    public void onClick(View v) {
        Intent intent_TheCalendar = new Intent(this,   TheСalendar.class);
        startActivity(intent_TheCalendar);
    }
}
