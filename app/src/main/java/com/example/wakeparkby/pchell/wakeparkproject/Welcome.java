package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    private Button buttSignIn;
    private Button buttCreateAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        buttSignIn = (Button) findViewById(R.id.buttonSignIn);
        buttCreateAcc = (Button) findViewById(R.id.buttonCreateAcc);
        buttSignIn.setOnClickListener((View.OnClickListener) this);
        buttCreateAcc.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {
        Intent intent_CreateAcc = new Intent(this, CreateAccount.class);
        Intent intent_SignIn = new Intent(this, SignIn.class);
        switch (v.getId()) {
            case R.id.buttonCreateAcc:
                startActivity(intent_CreateAcc);
                break;
            case R.id.buttonSignIn:
                startActivity(intent_SignIn);
                break;
        }
    }
}
