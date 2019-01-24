package com.example.wakeparkby.pchell.wakeparkproject;

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

import java.util.Calendar;

public class TheСalendar extends AppCompatActivity implements View.OnClickListener {
    private DatePicker datePicker;
    private Button buttSelectDate;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        buttSelectDate = (Button) findViewById(R.id.buttonSelectDate);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int headerId = Resources.getSystem().getIdentifier("day_picker_selector_layout", "id", "android");
            //int bodyId = Resources.getSystem().getIdentifier("numberpicker_input", "id", "android");
            final View header = datePicker.findViewById(headerId);
            //final View day = datePicker.findViewById(bodyId);
            header.setBackgroundColor(getResources().getColor(R.color.colorYelow));
           // day.setBackgroundColor(getResources().getColor(R.color.colorYelow));
            //final View body = datePicker.findViewById(id)
        }*/
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
