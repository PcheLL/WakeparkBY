package com.example.wakeparkby.pchell.wakeparkproject;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class ChooseTime extends AppCompatActivity implements View.OnClickListener {
    private TimePicker timePicker;
    private TextView textViewData;
    private Button buttTime1;
    private Button buttTime2;
    private Button buttSelectTime;
    private TextView textViewTime1;
    private TextView textViewTime2;
    private static int day;
    private static int month;
    private static int year;
    private static int hour1;
    private static int min1;
    private static int hour2;
    private static int min2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_time);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        textViewData = (TextView) findViewById(R.id.textViewData);
        textViewData.setText("(" + day + "." + month + "." + year + ")");
        buttTime1 = (Button) findViewById(R.id.buttonTime1);
        buttTime1.setOnClickListener((View.OnClickListener) this);
        buttTime2 = (Button) findViewById(R.id.buttonTime2);
        buttTime2.setOnClickListener((View.OnClickListener) this);
        buttSelectTime = (Button) findViewById(R.id.buttonSelectTime);
        buttSelectTime.setOnClickListener((View.OnClickListener) this);
        textViewTime1 = (TextView) findViewById(R.id.textViewTime1);
        textViewTime2 = (TextView) findViewById(R.id.textViewTime2);

    }

    protected void SetData(int mDay, int mMonth, int mYear) {
        day = mDay;
        month = mMonth;
        year = mYear;
    }


    @Override
    public void onClick(View v) {
        // Intent intent_MyTasks = new Intent(this, MyTasks.class);
        switch (v.getId()) {
            case R.id.buttonTime1:
                int currentApiVersion1 = android.os.Build.VERSION.SDK_INT;
                if (currentApiVersion1 > android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
                    hour1 = timePicker.getHour();
                    min1 = timePicker.getMinute();
                } else {
                    hour1 = timePicker.getCurrentHour();
                    min1 = timePicker.getCurrentMinute();
                }
                if (min1 < 10) {
                    textViewTime1.setText(hour1 + ":0" + min1);
                } else {
                    textViewTime1.setText(hour1 + ":" + min1);
                }
                break;
            case R.id.buttonTime2:
                int currentApiVersion2 = android.os.Build.VERSION.SDK_INT;
                if (currentApiVersion2 > android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
                    hour2 = timePicker.getHour();
                    min2 = timePicker.getMinute();
                } else {
                    hour2 = timePicker.getCurrentHour();
                    min2 = timePicker.getCurrentMinute();
                }
                if (min2 < 10) {
                    textViewTime2.setText(hour2 + ":0" + min2);
                } else {
                    textViewTime2.setText(hour2 + ":" + min2);
                }
                break;
            case R.id.buttonSelectTime:
                if (hour1 == 0 || hour2 == 0) {
                    Toast.makeText(getApplicationContext(), "Check the entered time", Toast.LENGTH_LONG).show();
                } else if (hour1 < 9 || hour2 < 9) {
                    Toast.makeText(getApplicationContext(), "Check the entered time", Toast.LENGTH_LONG).show();
                } else if (hour1 >= 21 || hour2 >= 21) {
                    Toast.makeText(getApplicationContext(), "Check the entered time", Toast.LENGTH_LONG).show();
                } else if (hour1 > hour2) {
                    Toast.makeText(getApplicationContext(), "Check the entered time", Toast.LENGTH_LONG).show();
                } else if (min1 != 0 & min1 != 5 & min1 != 10 & min1 != 15 & min1 != 20
                        & min1 != 25 & min1 != 30 & min1 != 35 & min1 != 40 & min1 != 45 & min1 != 50 & min1 != 55) {
                    Toast.makeText(getApplicationContext(), "Check the entered time", Toast.LENGTH_LONG).show();
                } else if (min2 != 0 & min2 != 5 & min2 != 10 & min2 != 15 & min2 != 20
                        & min2 != 25 & min2 != 30 & min2 != 35 & min2 != 40 & min2 != 45 & min2 != 50 & min2 != 55) {
                    Toast.makeText(getApplicationContext(), "Check the entered time", Toast.LENGTH_LONG).show();
                } else if (hour1 == hour2) {
                    if (min1 == min2) {
                        Toast.makeText(getApplicationContext(), "Check the entered time", Toast.LENGTH_LONG).show();
                    }
                }
                else {

                    Intent intent_BookingDescription = new Intent(this, BookingDescription.class);
                    startActivity(intent_BookingDescription);
                }
                //        startActivity(intent_MyTasks);
                break;
        }
    }
}
