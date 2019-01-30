package com.example.wakeparkby.pchell.wakeparkproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefReserved = database.getReference("RESERVED");
    private ExpandableListView expandableListView;
    private String n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        expandableListView = (ExpandableListView) findViewById(R.id.expListView);
        refreshReservedList();
    }

    private void refreshReservedList() {
        myRefReserved.child("TIME").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot deleteTimeReservDS) {
                final List<String> deleteReservTimeList = new ArrayList<String>();
                for (DataSnapshot battle : deleteTimeReservDS.getChildren()) {
                    String findValue = (String) battle.getValue();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

}
