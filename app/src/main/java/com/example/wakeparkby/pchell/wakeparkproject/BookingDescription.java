package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class BookingDescription extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefReserved = database.getReference("RESERVED");
    private TextView textViewLocation;
    private TextView textViewDate;
    private TextView textViewTime;
    private TextView textViewPrice;
    private static String infoMounth = null;
    private static String infoLocationName = null;
    private static String infoTime = "-";
    private static String infoData = null;
    private static String infoPrice = null;
    private String m1 = null;
    private String m2 = null;
    private Button buttBooking;
    private Button buttBackToMenu;
    private ImageView imageViewReserved;
    private String name = "Катя";
    private String reservedTime;
    private static List<String> visitorsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_description);
        textViewLocation = (TextView) findViewById(R.id.textViewInfoLocation);
        textViewLocation.setText("Место: "+infoLocationName);
        textViewDate = (TextView) findViewById(R.id.textViewInfoDate);
        textViewDate.setText("Дата: "+infoData);
        textViewTime = (TextView) findViewById(R.id.textViewInfoTime);
        textViewTime.setText("Время: "+infoTime);
        textViewPrice = (TextView) findViewById(R.id.textViewInfoPrice);
        textViewPrice.setText(infoPrice);
        buttBooking = (Button) findViewById(R.id.buttonBooking);
        buttBooking.setOnClickListener((View.OnClickListener) this);
        imageViewReserved = (ImageView) findViewById(R.id.imageViewReserved);
        buttBackToMenu = (Button) findViewById(R.id.buttonBackToMenu);
        buttBackToMenu.setOnClickListener((View.OnClickListener) this);
    }

    protected void infoLocation(String locationName) {
        infoLocationName = (locationName);
    }

    protected void infoDate(int mDay, int mMonth, int mYear) {

        infoData = (mDay + "-" + mMonth + "-" + mYear);
    }

    /*protected void infoTime(int hour1, int min1, int hour2, int min2) {
        if (min1 < 10) {
            m1 = ("0" + min1);
        } else {
            m1 = String.valueOf(min1);
        }
        if (min2 < 10) {
            m2 = ("0" + min2);
        } else {
            m2 = String.valueOf(min2);
        }
        infoTime = ("Время: " + hour1 + "." + m1 + " - " + hour2 + "." + m2);
    }*/

    protected void infoPrice() {
    }

    @Override
    public void onClick(View v) {
        Intent intent_Main_menu = new Intent(this, MainMenu.class);
        switch (v.getId()) {
            case R.id.buttonBooking:
                booking();
                imageViewReserved.setVisibility(View.VISIBLE);
                buttBooking.setVisibility(View.INVISIBLE);
                buttBackToMenu.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonBackToMenu:
                startActivity(intent_Main_menu);
                break;
        }

    }

    private void booking() {
        for (int i = 0; i<visitorsList.size();i++)
        {
            reservedTime = visitorsList.get(i);
            myRefReserved.child(infoLocationName).child(infoData).child(name).push().setValue(reservedTime);
            myRefReserved.child(infoLocationName).child(infoData).child("TIME").push().setValue(reservedTime);

        }
    }

    public void visitorsReserv(List<String> visitorsReservList) {
        visitorsList = visitorsReservList;
        System.out.print("");
    }
}