package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignIn extends AppCompatActivity implements View.OnClickListener{
    private Button buttEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        buttEnter = (Button) findViewById(R.id.buttonSignIn);
        buttEnter.setOnClickListener((View.OnClickListener) this);
    }


    @Override
    public void onClick(View v) {
        Intent intent_MainMenu = new Intent(this, MainMenu.class);
        startActivity(intent_MainMenu);
    }
}