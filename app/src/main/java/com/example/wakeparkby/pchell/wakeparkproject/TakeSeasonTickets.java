package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
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

public class TakeSeasonTickets extends AppCompatActivity implements View.OnClickListener {
    private Button buttSaveTST;
    private EditText editTextTimeTST;
    private EditText editTextNubmerPhoneTST;
    private String numberPhone;
    private String time;
    private static int timeSeasonTicket1;
    private String timeTST;
    private static int timeSeasonTicket2;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefSeasonTicketsAdmin = database.getReference("SeasonTickets");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_season_tickets);
        buttSaveTST = (Button) findViewById(R.id.buttonSaveTST);
        buttSaveTST.setOnClickListener((View.OnClickListener) this);
        editTextTimeTST = (EditText) findViewById(R.id.editTextTimeTST);
        editTextNubmerPhoneTST = (EditText) findViewById(R.id.editTextNubmerPhoneTST);

    }

    @Override
    public void onClick(View v) {
        numberPhone = String.valueOf(editTextNubmerPhoneTST.getText());
        time = String.valueOf(editTextTimeTST.getText());
        timeSeasonTicket2 = Integer.parseInt(time);
        add();

    }
    public void add(){
        myRefSeasonTicketsAdmin.child(numberPhone).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot giveSeasonTicketDS) {
                timeTST = String.valueOf(giveSeasonTicketDS.getValue());
                //for (DataSnapshot giveSeasonTicket : giveSeasonTicketDS.getChildren()) {
                //    timeGST = String.valueOf(giveSeasonTicket.getValue());
                // }
                if (timeTST.equals("null")) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "У клиента нет абонимента !!!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    timeSeasonTicket1 = Integer.parseInt(timeTST);
                    int k = timeSeasonTicket1 - timeSeasonTicket2;
                    if (k<0){
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "У пользователя нет столько времени !!!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else {
                        // /myRefSeasonTicketsAdmin = database.getReference("SeasonTickets" + "/" + numberPhone);
                        // myRefSeasonTicketsAdmin.removeValue();
                        myRefSeasonTicketsAdmin.child(numberPhone).setValue(k);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Списано " + timeSeasonTicket2 + " мин. " + "Осталось " + k + " мин.", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
