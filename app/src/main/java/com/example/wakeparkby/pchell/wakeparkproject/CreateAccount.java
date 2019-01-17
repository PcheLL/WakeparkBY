package com.example.wakeparkby.pchell.wakeparkproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;



public class CreateAccount extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextNumberPhone;
    private Button buttSave;
    private String numberPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        editTextNumberPhone = (EditText) findViewById(R.id.editTextNumberPhoneCA);
        buttSave = (Button) findViewById(R.id.buttonSave);
        buttSave.setOnClickListener((View.OnClickListener)this);
    }

    @Override
    public void onClick(View v) {
        numberPhone = String.valueOf(editTextNumberPhone.getText());
        resendVerificationCode();
    }

    private void resendVerificationCode() {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }
        };
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                numberPhone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks         // OnVerificationStateChangedCallbacks
        );

    }
}