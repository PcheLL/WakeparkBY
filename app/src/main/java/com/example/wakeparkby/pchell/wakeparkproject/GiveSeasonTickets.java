package com.example.wakeparkby.pchell.wakeparkproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GiveSeasonTickets extends AppCompatActivity implements View.OnClickListener {
    private Button buttSaveGST;
    private EditText editTextTimeGST;
    private EditText editTextNubmerPhoneGST;
    private String numberPhone;
    private String time;
    private static int timeSeasonTicket1;
    private String timeGST;
    private static int timeSeasonTicket2;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefSeasonTicketsAdmin = database.getReference("SeasonTickets");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_season_tickets);
        buttSaveGST = (Button) findViewById(R.id.buttonSaveGST);
        buttSaveGST.setOnClickListener((View.OnClickListener) this);
        editTextTimeGST = (EditText) findViewById(R.id.editTextTimeGST);
        editTextNubmerPhoneGST = (EditText) findViewById(R.id.editTextNubmerPhoneGST);

    }

    @Override
    public void onClick(View v) {
        numberPhone = String.valueOf(editTextNubmerPhoneGST.getText());
        time = String.valueOf(editTextTimeGST.getText());
        timeSeasonTicket2 = Integer.parseInt(time);
        add();

    }
    public void add(){
        myRefSeasonTicketsAdmin.child(numberPhone).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot giveSeasonTicketDS) {
                timeGST = String.valueOf(giveSeasonTicketDS.getValue());
                //for (DataSnapshot giveSeasonTicket : giveSeasonTicketDS.getChildren()) {
                //    timeGST = String.valueOf(giveSeasonTicket.getValue());
               // }
                    if (timeGST.equals("null")) {
                        myRefSeasonTicketsAdmin.child(numberPhone).setValue(timeSeasonTicket2);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Начислено " + timeSeasonTicket2 + " мин.", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        timeSeasonTicket1 = Integer.parseInt(timeGST);
                        int k = timeSeasonTicket2 + timeSeasonTicket1;
                       // /myRefSeasonTicketsAdmin = database.getReference("SeasonTickets" + "/" + numberPhone);
                       // myRefSeasonTicketsAdmin.removeValue();
                        myRefSeasonTicketsAdmin.child(numberPhone).setValue(k);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Начислено " + timeSeasonTicket2 + " мин. " + "Всего " + k + " мин." , Toast.LENGTH_SHORT);
                        toast.show();
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}