package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Price extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefPriceСhildren = database.getReference("Price/Сhildren");
    private DatabaseReference myRefPriceAdults = database.getReference("Price/Adults");
    private DatabaseReference myRefPriceRent = database.getReference("Price/Rent");
    private Button buttСhildren;
    private Button buttAdults;
    private Button buttRent;
    private LinearLayout layoutСhildren;
    private LinearLayout layoutAdults;
    private LinearLayout layoutRent;
    private static String keyPrice;
    private static String price;
    //----------------------------Дети------------------------
    private TextView textView23;
    private TextView textView33;
    private TextView textView43;
    private TextView textView53;
    private TextView textView63;
    private TextView textView73;
    private TextView textView83;
    private TextView textView93;
    private TextView textView24;
    private TextView textView34;
    private TextView textView44;
    private TextView textView54;
    private TextView textView64;
    private TextView textView74;
    private TextView textView84;
    private TextView textView94;
    //-------------------------Взрослые-----------------------
    private TextView textView_23;
    private TextView textView_33;
    private TextView textView_43;
    private TextView textView_53;
    private TextView textView_63;
    private TextView textView_73;
    private TextView textView_83;
    private TextView textView_93;
    //--------------------------Аренда------------------------
    private TextView textView__22;
    private TextView textView__23;
    private TextView textView__24;
    private TextView textView__32;
    private TextView textView__33;
    private TextView textView__34;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        buttСhildren = (Button) findViewById(R.id.buttonСhildren);
        buttСhildren.setOnClickListener((View.OnClickListener) this);
        buttAdults = (Button) findViewById(R.id.buttonAdults);
        buttAdults.setOnClickListener((View.OnClickListener) this);
        buttRent = (Button) findViewById(R.id.buttonRent);
        buttRent.setOnClickListener((View.OnClickListener) this);
        layoutСhildren = (LinearLayout) findViewById(R.id.layoutСhildren);
        layoutAdults = (LinearLayout) findViewById(R.id.layoutAdults);
        layoutRent = (LinearLayout) findViewById(R.id.layoutRent);
        textView23 = (TextView) findViewById(R.id.textView23);
        textView33 = (TextView) findViewById(R.id.textView33);
        textView43 = (TextView) findViewById(R.id.textView43);
        textView53 = (TextView) findViewById(R.id.textView53);
        textView63 = (TextView) findViewById(R.id.textView63);
        textView73 = (TextView) findViewById(R.id.textView73);
        textView83 = (TextView) findViewById(R.id.textView83);
        textView93 = (TextView) findViewById(R.id.textView93);
        textView24 = (TextView) findViewById(R.id.textView24);
        textView34 = (TextView) findViewById(R.id.textView34);
        textView44 = (TextView) findViewById(R.id.textView44);
        textView54 = (TextView) findViewById(R.id.textView54);
        textView64 = (TextView) findViewById(R.id.textView64);
        textView74 = (TextView) findViewById(R.id.textView74);
        textView84 = (TextView) findViewById(R.id.textView84);
        textView94 = (TextView) findViewById(R.id.textView94);
        textView_23 = (TextView) findViewById(R.id.textView_23);
        textView_33 = (TextView) findViewById(R.id.textView_33);
        textView_43 = (TextView) findViewById(R.id.textView_43);
        textView_53 = (TextView) findViewById(R.id.textView_53);
        textView_63 = (TextView) findViewById(R.id.textView_63);
        textView_73 = (TextView) findViewById(R.id.textView_73);
        textView_83 = (TextView) findViewById(R.id.textView_83);
        textView_93 = (TextView) findViewById(R.id.textView_93);
        textView__22 = (TextView) findViewById(R.id.textView__22);
        textView__23 = (TextView) findViewById(R.id.textView__23);
        textView__24 = (TextView) findViewById(R.id.textView__24);
        textView__32 = (TextView) findViewById(R.id.textView__32);
        textView__33 = (TextView) findViewById(R.id.textView__33);
        textView__34 = (TextView) findViewById(R.id.textView__34);


        //--------------------------------Обновление цены---------------------
        myRefPriceСhildren.child("PrimeTime").child("UpTo16years").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                price = String.valueOf(dataSnapshot1.child("10min").getValue());
                textView64.setText(price);
                price = String.valueOf(dataSnapshot1.child("15min").getValue());
                textView74.setText(price);
                price = String.valueOf(dataSnapshot1.child("20min").getValue());
                textView84.setText(price);
                price = String.valueOf(dataSnapshot1.child("30min").getValue());
                textView94.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRefPriceСhildren.child("PrimeTime").child("UpTo9years").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot2) {
                price = String.valueOf(dataSnapshot2.child("10min").getValue());
                textView63.setText(price);
                price = String.valueOf(dataSnapshot2.child("15min").getValue());
                textView73.setText(price);
                price = String.valueOf(dataSnapshot2.child("20min").getValue());
                textView83.setText(price);
                price = String.valueOf(dataSnapshot2.child("30min").getValue());
                textView93.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRefPriceСhildren.child("WeekdaysNotPrimeTime").child("UpTo16years").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot3) {
                price = String.valueOf(dataSnapshot3.child("10min").getValue());
                textView24.setText(price);
                price = String.valueOf(dataSnapshot3.child("15min").getValue());
                textView34.setText(price);
                price = String.valueOf(dataSnapshot3.child("20min").getValue());
                textView44.setText(price);
                price = String.valueOf(dataSnapshot3.child("30min").getValue());
                textView54.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRefPriceСhildren.child("WeekdaysNotPrimeTime").child("UpTo9years").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot4) {
                price = String.valueOf(dataSnapshot4.child("10min").getValue());
                textView23.setText(price);
                price = String.valueOf(dataSnapshot4.child("15min").getValue());
                textView33.setText(price);
                price = String.valueOf(dataSnapshot4.child("20min").getValue());
                textView43.setText(price);
                price = String.valueOf(dataSnapshot4.child("30min").getValue());
                textView53.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRefPriceAdults.child("PrimeTime").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot5) {
                price = String.valueOf(dataSnapshot5.child("10min").getValue());
                textView_63.setText(price);
                price = String.valueOf(dataSnapshot5.child("15min").getValue());
                textView_73.setText(price);
                price = String.valueOf(dataSnapshot5.child("20min").getValue());
                textView_83.setText(price);
                price = String.valueOf(dataSnapshot5.child("30min").getValue());
                textView_93.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRefPriceAdults.child("WeekdaysNotPrimeTime").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot6) {
                price = String.valueOf(dataSnapshot6.child("10min").getValue());
                textView_23.setText(price);
                price = String.valueOf(dataSnapshot6.child("15min").getValue());
                textView_33.setText(price);
                price = String.valueOf(dataSnapshot6.child("20min").getValue());
                textView_43.setText(price);
                price = String.valueOf(dataSnapshot6.child("30min").getValue());
                textView_53.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRefPriceRent.child("WeekdaysNotPrimeTime").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot7) {
                price = String.valueOf(dataSnapshot7.child("1hour").getValue());
                textView__22.setText(price);
                price = String.valueOf(dataSnapshot7.child("2hour").getValue());
                textView__23.setText(price);
                price = String.valueOf(dataSnapshot7.child("3hour").getValue());
                textView__24.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRefPriceRent.child("PrimeTime").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {
                price = String.valueOf(dataSnapshot8.child("1hour").getValue());
                textView__32.setText(price);
                price = String.valueOf(dataSnapshot8.child("2hour").getValue());
                textView__33.setText(price);
                price = String.valueOf(dataSnapshot8.child("3hour").getValue());
                textView__34.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonСhildren:
                layoutСhildren.setVisibility(View.VISIBLE);
                layoutAdults.setVisibility(View.INVISIBLE);
                layoutRent.setVisibility(View.INVISIBLE);
                break;
            case R.id.buttonAdults:
                layoutСhildren.setVisibility(View.INVISIBLE);
                layoutAdults.setVisibility(View.VISIBLE);
                layoutRent.setVisibility(View.INVISIBLE);
                break;
            case R.id.buttonRent:
                layoutСhildren.setVisibility(View.INVISIBLE);
                layoutAdults.setVisibility(View.INVISIBLE);
                layoutRent.setVisibility(View.VISIBLE);
                break;
        }
    }
}
