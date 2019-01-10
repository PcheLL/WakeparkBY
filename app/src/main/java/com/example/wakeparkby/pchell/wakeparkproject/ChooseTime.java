package com.example.wakeparkby.pchell.wakeparkproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.TimePicker;


public class ChooseTime extends AppCompatActivity {
    private TimePicker timePicker;
    private TextView textViewData;
    private static int day;
    private static int month;
    private static int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_time);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        textViewData = (TextView) findViewById(R.id.textViewData);
        textViewData.setText("(" + day + "." + month + "." + year + ")");
    }

    protected void SetData(int mDay, int mMonth, int mYear) {
        day = mDay;
        month = mMonth;
        year = mYear;
    }
}
