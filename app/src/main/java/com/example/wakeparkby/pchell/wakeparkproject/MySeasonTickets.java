package com.example.wakeparkby.pchell.wakeparkproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MySeasonTickets extends AppCompatActivity  {
    TextView textViewSeasonTicketsTime;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefMySeasonTickets = database.getReference("SeasonTickets");
    private String myNumberPhone = "+375295274820";
    private String myTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_season_tickets);
        textViewSeasonTicketsTime = (TextView) findViewById(R.id.textViewSeasonTicketsTime);
        refreshMyTime();
    }

    private void refreshMyTime() {
        myRefMySeasonTickets.child(myNumberPhone).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot giveSeasonTicketDS) {
                myTime = String.valueOf(giveSeasonTicketDS.getValue());
                textViewSeasonTicketsTime.setText(myTime + " мин");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
