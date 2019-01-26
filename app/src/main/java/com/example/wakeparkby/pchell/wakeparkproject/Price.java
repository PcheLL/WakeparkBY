package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Price extends AppCompatActivity implements View.OnClickListener {
    private Button buttСhildren;
    private Button buttAdults;
    private Button buttRent;
    private LinearLayout layoutСhildren;
    private LinearLayout layoutAdults;
    private LinearLayout layoutRent;

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
