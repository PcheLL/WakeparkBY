package com.example.wakeparkby.pchell.wakeparkproject;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class TheСalendar extends AppCompatActivity implements View.OnClickListener {
    private DatePicker datePicker;
    private Button buttSelectDate;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        buttSelectDate = (Button) findViewById(R.id.buttonSelectDate);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        buttSelectDate.setOnClickListener((View.OnClickListener) this);
        Calendar cal=Calendar.getInstance();
        long now = System.currentTimeMillis() - 1000;
        datePicker.setMinDate(now);
        datePicker.setMaxDate(now+(1000*60*60*24*6));
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
