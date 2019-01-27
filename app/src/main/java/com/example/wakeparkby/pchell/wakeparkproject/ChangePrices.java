package com.example.wakeparkby.pchell.wakeparkproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChangePrices extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefPriceСhildren = database.getReference("Price/Сhildren");
    private DatabaseReference myRefPriceAdults = database.getReference("Price/Adults");
    private DatabaseReference myRefPriceRent = database.getReference("Price/Rent");

    private Button buttNewPriceСhildren;
    private Button buttNewPriceAdults;
    private Button buttNewPriceRent;
    private Button buttCNotPrimeTime;
    private Button buttCNewPrimeTime;
    private Button buttANotPrimeTime;
    private Button buttANewPrimeTime;
    private Button buttRNotPrimeTime;
    private Button buttRNewPrimeTime;
    private Button buttEnterNewPriceChildren;
    private Button buttEnterNewPriceChildrenPT;
    private Button buttEnterNewPriceAdults;
    private Button buttEnterNewPriceAdultsPT;
    private Button buttEnterNewPriceRent;
    private Button buttEnterNewPriceRentPT;


    private LinearLayout linearLayoutNPChildren;
    private LinearLayout linearLayoutNPChildrenPT;
    private LinearLayout linearLayoutNPAdults;
    private LinearLayout linearLayoutNPAdultsPT;
    private LinearLayout linearLayoutNPRental;
    private LinearLayout linearLayoutNPRentalPT;
    private LinearLayout linearLayoutCTime;
    private LinearLayout linearLayoutATime;
    private LinearLayout linearLayoutRTime;


    //------------------------Дети-------------------
    private EditText editTextC1_11;
    private EditText editTextC1_12;
    private EditText editTextC1_21;
    private EditText editTextC1_22;
    private EditText editTextC1_31;
    private EditText editTextC1_32;
    private EditText editTextC1_41;
    private EditText editTextC1_42;
    private EditText editTextC2_11;
    private EditText editTextC2_12;
    private EditText editTextC2_21;
    private EditText editTextC2_22;
    private EditText editTextC2_31;
    private EditText editTextC2_32;
    private EditText editTextC2_41;
    private EditText editTextC2_42;
    //--------------------Взрослые-------------------
    private EditText editTextA1_11;
    private EditText editTextA1_21;
    private EditText editTextA1_31;
    private EditText editTextA1_41;
    private EditText editTextA2_11;
    private EditText editTextA2_21;
    private EditText editTextA2_31;
    private EditText editTextA2_41;
    //---------------------Аренда--------------------
    private EditText editTextR1_11;
    private EditText editTextR1_21;
    private EditText editTextR1_31;
    private EditText editTextR2_11;
    private EditText editTextR2_21;
    private EditText editTextR2_31;

    private String newPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_prices);

        linearLayoutNPChildren = (LinearLayout) findViewById(R.id.linearLayoutNPChildren);
        linearLayoutNPChildrenPT = (LinearLayout) findViewById(R.id.linearLayoutNPChildrenPT);
        linearLayoutNPAdults = (LinearLayout) findViewById(R.id.linearLayoutNPAdults);
        linearLayoutNPAdultsPT = (LinearLayout) findViewById(R.id.linearLayoutNPAdultsPT);
        linearLayoutNPRental = (LinearLayout) findViewById(R.id.linearLayoutNPRental);
        linearLayoutNPRentalPT = (LinearLayout) findViewById(R.id.linearLayoutNPRentalPT);
        linearLayoutCTime = (LinearLayout) findViewById(R.id.linearLayoutCTime);
        linearLayoutATime = (LinearLayout) findViewById(R.id.linearLayoutATime);
        linearLayoutRTime = (LinearLayout) findViewById(R.id.linearLayoutRTime);

        buttNewPriceСhildren = (Button) findViewById(R.id.buttonNewPriceСhildren);
        buttNewPriceAdults = (Button) findViewById(R.id.buttonNewPriceAdults);
        buttNewPriceRent = (Button) findViewById(R.id.buttonNewPriceRent);
        buttCNotPrimeTime = (Button) findViewById(R.id.buttonCNotPrimeTime);
        buttCNewPrimeTime = (Button) findViewById(R.id.buttonCNewPrimeTime);
        buttANotPrimeTime = (Button) findViewById(R.id.buttonANotPrimeTime);
        buttANewPrimeTime = (Button) findViewById(R.id.buttonANewPrimeTime);
        buttRNotPrimeTime = (Button) findViewById(R.id.buttonRNotPrimeTime);
        buttRNewPrimeTime = (Button) findViewById(R.id.buttonRNewPrimeTime);
        buttEnterNewPriceChildren = (Button) findViewById(R.id.buttonEnterNewPriceChildren);
        buttEnterNewPriceChildrenPT = (Button) findViewById(R.id.buttonEnterNewPriceChildrenPT);
        buttEnterNewPriceAdults = (Button) findViewById(R.id.buttonEnterNewPriceAdults);
        buttEnterNewPriceAdultsPT = (Button) findViewById(R.id.buttonEnterNewPriceAdultsPT);
        buttEnterNewPriceRent = (Button) findViewById(R.id.buttonEnterNewPriceRent);
        buttEnterNewPriceRentPT = (Button) findViewById(R.id.buttonEnterNewPriceRentPT);
        buttNewPriceСhildren.setOnClickListener((View.OnClickListener) this);
        buttNewPriceAdults.setOnClickListener((View.OnClickListener) this);
        buttNewPriceRent.setOnClickListener((View.OnClickListener) this);
        buttCNotPrimeTime.setOnClickListener((View.OnClickListener) this);
        buttCNewPrimeTime.setOnClickListener((View.OnClickListener) this);
        buttANotPrimeTime.setOnClickListener((View.OnClickListener) this);
        buttANewPrimeTime.setOnClickListener((View.OnClickListener) this);
        buttRNotPrimeTime.setOnClickListener((View.OnClickListener) this);
        buttRNewPrimeTime.setOnClickListener((View.OnClickListener) this);
        buttEnterNewPriceChildren.setOnClickListener((View.OnClickListener) this);
        buttEnterNewPriceChildrenPT.setOnClickListener((View.OnClickListener) this);
        buttEnterNewPriceAdults.setOnClickListener((View.OnClickListener) this);
        buttEnterNewPriceAdultsPT.setOnClickListener((View.OnClickListener) this);
        buttEnterNewPriceRent.setOnClickListener((View.OnClickListener) this);
        buttEnterNewPriceRentPT.setOnClickListener((View.OnClickListener) this);

        editTextC1_11 = (EditText) findViewById(R.id.editTextC1_11);
        editTextC1_12 = (EditText) findViewById(R.id.editTextC1_12);
        editTextC1_21 = (EditText) findViewById(R.id.editTextC1_21);
        editTextC1_22 = (EditText) findViewById(R.id.editTextC1_22);
        editTextC1_31 = (EditText) findViewById(R.id.editTextC1_31);
        editTextC1_32 = (EditText) findViewById(R.id.editTextC1_32);
        editTextC1_41 = (EditText) findViewById(R.id.editTextC1_41);
        editTextC1_42 = (EditText) findViewById(R.id.editTextC1_42);
        editTextC2_11 = (EditText) findViewById(R.id.editTextC2_11);
        editTextC2_12 = (EditText) findViewById(R.id.editTextC2_12);
        editTextC2_21 = (EditText) findViewById(R.id.editTextC2_21);
        editTextC2_22 = (EditText) findViewById(R.id.editTextC2_22);
        editTextC2_31 = (EditText) findViewById(R.id.editTextC2_31);
        editTextC2_32 = (EditText) findViewById(R.id.editTextC2_32);
        editTextC2_41 = (EditText) findViewById(R.id.editTextC2_41);
        editTextC2_42 = (EditText) findViewById(R.id.editTextC2_42);
        editTextA1_11 = (EditText) findViewById(R.id.editTextA1_11);
        editTextA1_21 = (EditText) findViewById(R.id.editTextA1_21);
        editTextA1_31 = (EditText) findViewById(R.id.editTextA1_31);
        editTextA1_41 = (EditText) findViewById(R.id.editTextA1_41);
        editTextA2_11 = (EditText) findViewById(R.id.editTextA2_11);
        editTextA2_21 = (EditText) findViewById(R.id.editTextA2_21);
        editTextA2_31 = (EditText) findViewById(R.id.editTextA2_31);
        editTextA2_41 = (EditText) findViewById(R.id.editTextA2_41);
        editTextR1_11 = (EditText) findViewById(R.id.editTextR1_11);
        editTextR1_21 = (EditText) findViewById(R.id.editTextR1_21);
        editTextR1_31 = (EditText) findViewById(R.id.editTextR1_31);
        editTextR2_11 = (EditText) findViewById(R.id.editTextR2_11);
        editTextR2_21 = (EditText) findViewById(R.id.editTextR2_21);
        editTextR2_31 = (EditText) findViewById(R.id.editTextR2_31);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonNewPriceСhildren:
                linearLayoutNPChildren.setVisibility(View.VISIBLE);
                linearLayoutNPChildrenPT.setVisibility(View.INVISIBLE);
                linearLayoutNPAdults.setVisibility(View.INVISIBLE);
                linearLayoutNPAdultsPT.setVisibility(View.INVISIBLE);
                linearLayoutNPRental.setVisibility(View.INVISIBLE);
                linearLayoutNPRentalPT.setVisibility(View.INVISIBLE);
                linearLayoutCTime.setVisibility(View.VISIBLE);
                linearLayoutATime.setVisibility(View.INVISIBLE);
                linearLayoutRTime.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildren.setVisibility(View.VISIBLE);
                buttEnterNewPriceChildrenPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdults.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdultsPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRent.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRentPT.setVisibility(View.INVISIBLE);

                break;
            case R.id.buttonNewPriceAdults:
                linearLayoutNPChildren.setVisibility(View.INVISIBLE);
                linearLayoutNPChildrenPT.setVisibility(View.INVISIBLE);
                linearLayoutNPAdults.setVisibility(View.VISIBLE);
                linearLayoutNPAdultsPT.setVisibility(View.INVISIBLE);
                linearLayoutNPRental.setVisibility(View.INVISIBLE);
                linearLayoutNPRentalPT.setVisibility(View.INVISIBLE);
                linearLayoutCTime.setVisibility(View.INVISIBLE);
                linearLayoutATime.setVisibility(View.VISIBLE);
                linearLayoutRTime.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildren.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildrenPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdults.setVisibility(View.VISIBLE);
                buttEnterNewPriceAdultsPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRent.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRentPT.setVisibility(View.INVISIBLE);
                break;
            case R.id.buttonNewPriceRent:
                linearLayoutNPChildren.setVisibility(View.INVISIBLE);
                linearLayoutNPChildrenPT.setVisibility(View.INVISIBLE);
                linearLayoutNPAdults.setVisibility(View.INVISIBLE);
                linearLayoutNPAdultsPT.setVisibility(View.INVISIBLE);
                linearLayoutNPRental.setVisibility(View.VISIBLE);
                linearLayoutNPRentalPT.setVisibility(View.INVISIBLE);
                linearLayoutCTime.setVisibility(View.INVISIBLE);
                linearLayoutATime.setVisibility(View.INVISIBLE);
                linearLayoutRTime.setVisibility(View.VISIBLE);
                buttEnterNewPriceChildren.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildrenPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdults.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdultsPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRent.setVisibility(View.VISIBLE);
                buttEnterNewPriceRentPT.setVisibility(View.INVISIBLE);
                break;
            case R.id.buttonCNotPrimeTime:
                linearLayoutNPChildren.setVisibility(View.VISIBLE);
                linearLayoutNPChildrenPT.setVisibility(View.INVISIBLE);
                linearLayoutNPAdults.setVisibility(View.INVISIBLE);
                linearLayoutNPAdultsPT.setVisibility(View.INVISIBLE);
                linearLayoutNPRental.setVisibility(View.INVISIBLE);
                linearLayoutNPRentalPT.setVisibility(View.INVISIBLE);
                linearLayoutCTime.setVisibility(View.VISIBLE);
                linearLayoutATime.setVisibility(View.INVISIBLE);
                linearLayoutRTime.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildren.setVisibility(View.VISIBLE);
                buttEnterNewPriceChildrenPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdults.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdultsPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRent.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRentPT.setVisibility(View.INVISIBLE);
                break;
            case R.id.buttonCNewPrimeTime:
                linearLayoutNPChildren.setVisibility(View.INVISIBLE);
                linearLayoutNPChildrenPT.setVisibility(View.VISIBLE);
                linearLayoutNPAdults.setVisibility(View.INVISIBLE);
                linearLayoutNPAdultsPT.setVisibility(View.INVISIBLE);
                linearLayoutNPRental.setVisibility(View.INVISIBLE);
                linearLayoutNPRentalPT.setVisibility(View.INVISIBLE);
                linearLayoutCTime.setVisibility(View.VISIBLE);
                linearLayoutATime.setVisibility(View.INVISIBLE);
                linearLayoutRTime.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildren.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildrenPT.setVisibility(View.VISIBLE);
                buttEnterNewPriceAdults.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdultsPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRent.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRentPT.setVisibility(View.INVISIBLE);
                break;
            case R.id.buttonANotPrimeTime:
                linearLayoutNPChildren.setVisibility(View.INVISIBLE);
                linearLayoutNPChildrenPT.setVisibility(View.INVISIBLE);
                linearLayoutNPAdults.setVisibility(View.VISIBLE);
                linearLayoutNPAdultsPT.setVisibility(View.INVISIBLE);
                linearLayoutNPRental.setVisibility(View.INVISIBLE);
                linearLayoutNPRentalPT.setVisibility(View.INVISIBLE);
                linearLayoutCTime.setVisibility(View.INVISIBLE);
                linearLayoutATime.setVisibility(View.VISIBLE);
                linearLayoutRTime.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildren.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildrenPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdults.setVisibility(View.VISIBLE);
                buttEnterNewPriceAdultsPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRent.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRentPT.setVisibility(View.INVISIBLE);
                break;
            case R.id.buttonANewPrimeTime:
                linearLayoutNPChildren.setVisibility(View.INVISIBLE);
                linearLayoutNPChildrenPT.setVisibility(View.INVISIBLE);
                linearLayoutNPAdults.setVisibility(View.INVISIBLE);
                linearLayoutNPAdultsPT.setVisibility(View.VISIBLE);
                linearLayoutNPRental.setVisibility(View.INVISIBLE);
                linearLayoutNPRentalPT.setVisibility(View.INVISIBLE);
                linearLayoutCTime.setVisibility(View.INVISIBLE);
                linearLayoutATime.setVisibility(View.VISIBLE);
                linearLayoutRTime.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildren.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildrenPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdults.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdultsPT.setVisibility(View.VISIBLE);
                buttEnterNewPriceRent.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRentPT.setVisibility(View.INVISIBLE);
                break;
            case R.id.buttonRNotPrimeTime:
                linearLayoutNPChildren.setVisibility(View.INVISIBLE);
                linearLayoutNPChildrenPT.setVisibility(View.INVISIBLE);
                linearLayoutNPAdults.setVisibility(View.INVISIBLE);
                linearLayoutNPAdultsPT.setVisibility(View.INVISIBLE);
                linearLayoutNPRental.setVisibility(View.VISIBLE);
                linearLayoutNPRentalPT.setVisibility(View.INVISIBLE);
                linearLayoutCTime.setVisibility(View.INVISIBLE);
                linearLayoutATime.setVisibility(View.INVISIBLE);
                linearLayoutRTime.setVisibility(View.VISIBLE);
                buttEnterNewPriceChildren.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildrenPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdults.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdultsPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRent.setVisibility(View.VISIBLE);
                buttEnterNewPriceRentPT.setVisibility(View.INVISIBLE);
                break;
            case R.id.buttonRNewPrimeTime:
                linearLayoutNPChildren.setVisibility(View.INVISIBLE);
                linearLayoutNPChildrenPT.setVisibility(View.INVISIBLE);
                linearLayoutNPAdults.setVisibility(View.INVISIBLE);
                linearLayoutNPAdultsPT.setVisibility(View.INVISIBLE);
                linearLayoutNPRental.setVisibility(View.INVISIBLE);
                linearLayoutNPRentalPT.setVisibility(View.VISIBLE);
                linearLayoutCTime.setVisibility(View.INVISIBLE);
                linearLayoutATime.setVisibility(View.INVISIBLE);
                linearLayoutRTime.setVisibility(View.VISIBLE);
                buttEnterNewPriceChildren.setVisibility(View.INVISIBLE);
                buttEnterNewPriceChildrenPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdults.setVisibility(View.INVISIBLE);
                buttEnterNewPriceAdultsPT.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRent.setVisibility(View.INVISIBLE);
                buttEnterNewPriceRentPT.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonEnterNewPriceChildren:
                newPrice = String.valueOf(editTextC1_11.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("WeekdaysNotPrimeTime").child("UpTo9years").child("10min").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextC1_12.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("WeekdaysNotPrimeTime").child("UpTo16years").child("10min").setValue(newPrice);
                    editTextC1_12.setText("");
                }
                newPrice = String.valueOf(editTextC1_21.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("WeekdaysNotPrimeTime").child("UpTo9years").child("15min").setValue(newPrice);
                    editTextC1_21.setText("");
                }
                newPrice = String.valueOf(editTextC1_22.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("WeekdaysNotPrimeTime").child("UpTo16years").child("15min").setValue(newPrice);
                    editTextC1_22.setText("");
                }
                newPrice = String.valueOf(editTextC1_31.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("WeekdaysNotPrimeTime").child("UpTo9years").child("20min").setValue(newPrice);
                    editTextC1_31.setText("");
                }
                newPrice = String.valueOf(editTextC1_32.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("WeekdaysNotPrimeTime").child("UpTo16years").child("20min").setValue(newPrice);
                    editTextC1_32.setText("");
                }
                newPrice = String.valueOf(editTextC1_41.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("WeekdaysNotPrimeTime").child("UpTo9years").child("30min").setValue(newPrice);
                    editTextC1_41.setText("");
                }
                newPrice = String.valueOf(editTextC1_42.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("WeekdaysNotPrimeTime").child("UpTo16years").child("30min").setValue(newPrice);
                    editTextC1_42.setText("");
                }
                break;
            case R.id.buttonEnterNewPriceChildrenPT:
                newPrice = String.valueOf(editTextC2_11.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("PrimeTime").child("UpTo9years").child("10min").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextC2_12.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("PrimeTime").child("UpTo16years").child("10min").setValue(newPrice);
                    editTextC1_12.setText("");
                }
                newPrice = String.valueOf(editTextC2_21.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("PrimeTime").child("UpTo9years").child("15min").setValue(newPrice);
                    editTextC1_21.setText("");
                }
                newPrice = String.valueOf(editTextC2_22.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("PrimeTime").child("UpTo16years").child("15min").setValue(newPrice);
                    editTextC1_22.setText("");
                }
                newPrice = String.valueOf(editTextC2_31.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("PrimeTime").child("UpTo9years").child("20min").setValue(newPrice);
                    editTextC1_31.setText("");
                }
                newPrice = String.valueOf(editTextC2_32.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("PrimeTime").child("UpTo16years").child("20min").setValue(newPrice);
                    editTextC1_32.setText("");
                }
                newPrice = String.valueOf(editTextC2_41.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("PrimeTime").child("UpTo9years").child("30min").setValue(newPrice);
                    editTextC1_41.setText("");
                }
                newPrice = String.valueOf(editTextC2_42.getText());
                if (!newPrice.equals("")){
                    myRefPriceСhildren.child("PrimeTime").child("UpTo16years").child("30min").setValue(newPrice);
                    editTextC1_42.setText("");
                }
                break;
            case R.id.buttonEnterNewPriceAdults:
                newPrice = String.valueOf(editTextA1_11.getText());
                if (!newPrice.equals("")){
                    myRefPriceAdults.child("WeekdaysNotPrimeTime").child("10min").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextA1_21.getText());
                if (!newPrice.equals("")){
                    myRefPriceAdults.child("WeekdaysNotPrimeTime").child("15min").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextA1_31.getText());
                if (!newPrice.equals("")){
                    myRefPriceAdults.child("WeekdaysNotPrimeTime").child("20min").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextA1_41.getText());
                if (!newPrice.equals("")){
                    myRefPriceAdults.child("WeekdaysNotPrimeTime").child("30min").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                break;
            case R.id.buttonEnterNewPriceAdultsPT:
                newPrice = String.valueOf(editTextA2_11.getText());
                if (!newPrice.equals("")){
                    myRefPriceAdults.child("PrimeTime").child("10min").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextA2_21.getText());
                if (!newPrice.equals("")){
                    myRefPriceAdults.child("PrimeTime").child("15min").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextA2_31.getText());
                if (!newPrice.equals("")){
                    myRefPriceAdults.child("PrimeTime").child("20min").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextA2_41.getText());
                if (!newPrice.equals("")){
                    myRefPriceAdults.child("PrimeTime").child("30min").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                break;
            case R.id.buttonEnterNewPriceRent:
                newPrice = String.valueOf(editTextR1_11.getText());
                if (!newPrice.equals("")){
                    myRefPriceRent.child("WeekdaysNotPrimeTime").child("1hour").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextR1_21.getText());
                if (!newPrice.equals("")){
                    myRefPriceRent.child("WeekdaysNotPrimeTime").child("2hour").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextR1_31.getText());
                if (!newPrice.equals("")){
                    myRefPriceRent.child("WeekdaysNotPrimeTime").child("3hour").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                break;
            case R.id.buttonEnterNewPriceRentPT:
                newPrice = String.valueOf(editTextR2_11.getText());
                if (!newPrice.equals("")){
                    myRefPriceRent.child("PrimeTime").child("1hour").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextR2_21.getText());
                if (!newPrice.equals("")){
                    myRefPriceRent.child("PrimeTime").child("2hour").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                newPrice = String.valueOf(editTextR2_31.getText());
                if (!newPrice.equals("")){
                    myRefPriceRent.child("PrimeTime").child("3hour").setValue(newPrice);
                    editTextC1_11.setText("");
                }
                break;

        }
    }
}
