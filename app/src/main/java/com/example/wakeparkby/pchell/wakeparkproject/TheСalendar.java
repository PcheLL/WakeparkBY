package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class TheСalendar extends AppCompatActivity implements View.OnClickListener {
    private DatePicker datePicker;
    private Button buttSelectDate;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        buttSelectDate = (Button) findViewById(R.id.buttonSelectDate);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        buttSelectDate.setOnClickListener((View.OnClickListener) this);
    }


    @Override
    public void onClick(View v) {
        int mDay = datePicker.getDayOfMonth();
        int mMonth = datePicker.getMonth() + 1;
        int mYear = datePicker.getYear();
        ChooseTime chooseTime = new ChooseTime();
        chooseTime.SetData(mDay, mMonth, mYear);
        BookingDescription bookingDescription = new BookingDescription();
        bookingDescription.infoDate(mDay, mMonth, mYear);
        Intent intent_chooseData = new Intent(this, ChooseTime.class);
        startActivity(intent_chooseData);
    }
}
