package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    private Button buttChoosePl;
    private Button buttGiveSeasonTickets;
    private Button buttPrice;
    private Button buttTakeSeasonTickets;
    private Button buttChangePrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        buttChoosePl = (Button) findViewById(R.id.buttonChoosePl);
        buttChoosePl.setOnClickListener((View.OnClickListener) this);
        buttGiveSeasonTickets = (Button) findViewById(R.id.buttonGiveSeasonTickets);
        buttGiveSeasonTickets.setOnClickListener((View.OnClickListener) this);
        buttPrice = (Button) findViewById(R.id.buttonPrice);
        buttPrice.setOnClickListener((View.OnClickListener) this);
        buttTakeSeasonTickets = (Button) findViewById(R.id.buttonTakeSeasonTickets);
        buttTakeSeasonTickets.setOnClickListener((View.OnClickListener) this);
        buttChangePrice = (Button) findViewById(R.id.buttonChangePrice);
        buttChangePrice.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_LocationSelection = new Intent(this, LocationSelection.class);
        Intent intent_Give_Season_Tickets = new Intent(this, GiveSeasonTickets.class);
        Intent intent_Take_Season_Tickets = new Intent(this, TakeSeasonTickets.class);
        Intent intent_Price = new Intent(this, Price.class);
        Intent intent_Change_Price = new Intent(this, ChangePrices.class);

        switch (v.getId()) {
            case R.id.buttonChoosePl:
                startActivity(intent_LocationSelection);
                break;
            case R.id.buttonGiveSeasonTickets:
                startActivity(intent_Give_Season_Tickets);
                break;
            case R.id.buttonPrice:
                startActivity(intent_Price);
                break;
            case R.id.buttonTakeSeasonTickets:
                startActivity(intent_Take_Season_Tickets);
                break;
            case R.id.buttonChangePrice:
                startActivity(intent_Change_Price);
                break;
        }
    }
}
