package com.example.wakeparkby.pchell.wakeparkproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class BookingDescription extends AppCompatActivity {
    private TextView textViewLocation;
    private TextView textViewDate;
    private TextView textViewTime;
    private TextView textViewPrice;
    private static String infoMounth = null;
    private static String infoLocationName = null;
    private static String infoTime = null;
    private static String infoData = null;
    private static String infoPrice = null;
    private String m1 = null;
    private String m2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_description);
        textViewLocation = (TextView) findViewById(R.id.textViewInfoLocation);
        textViewLocation.setText(infoLocationName);
        textViewDate = (TextView) findViewById(R.id.textViewInfoDate);
        textViewDate.setText(infoData);
        textViewTime = (TextView) findViewById(R.id.textViewInfoTime);
        textViewTime.setText(infoTime);
        textViewPrice = (TextView) findViewById(R.id.textViewInfoPrice);
        textViewPrice.setText(infoPrice);
    }

    protected void infoLocation(String locationName) {
        infoLocationName =("Location: " + locationName);
    }

    protected void infoDate(int mDay, int mMonth, int mYear) {
        if (mMonth == 1) {
            infoMounth = "Январь";
        }
        if (mMonth == 2) {
            infoMounth = "Февраль";
        }
        if (mMonth == 3) {
            infoMounth = "Март";
        }
        if (mMonth == 4) {
            infoMounth = "Апрель";
        }
        if (mMonth == 5) {
            infoMounth = "Май";
        }
        if (mMonth == 6) {
            infoMounth = "Июнь";
        }
        if (mMonth == 7) {
            infoMounth = "Июль";
        }
        if (mMonth == 8) {
            infoMounth = "Август";
        }
        if (mMonth == 9) {
            infoMounth = "Сентябрь";
        }
        if (mMonth == 10) {
            infoMounth = "Октябрь";
        }
        if (mMonth == 11) {
            infoMounth = "Ноябрь";
        }
        if (mMonth == 12) {
            infoMounth = "Декабрь";
        }
        infoData = ("Date: " + mDay + " " + infoMounth + " " + mYear);
    }

    protected void infoTime(int hour1, int min1, int hour2, int min2) {
        if (min1 < 10) {
             m1 = ("0" + min1);
        }
        else {
            m1 = String.valueOf(min1);
        }
         if (min2 < 10) {
             m2 = ("0" + min2);
        }
        else {
             m2 = String.valueOf(min2);
         }
        infoTime =("Time: " + hour1 + "." + m1 + " - " + hour2 + "." + m2);
    }

    protected void infoPrice(){}
}