package com.example.wakeparkby.pchell.wakeparkproject;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ChooseTime extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefListTime = database.getReference("ListTime");
    private DatabaseReference myRefListProcReserv = database.getReference("ProcessOfReservation");
    private TimePicker timePicker;
    private TextView textViewData;
    private Button buttLong;
    private Button buttShort;
    private Button buttSelectTime;
    private TextView textViewTime1;
    private TextView textViewTime2;
    private ListView listViewTime;
    private static int day;
    private static int month;
    private static int year;
    private static int hour1;
    private static int min1;
    private static int hour2;
    private static int min2;
    private static ArrayList idList = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_time);
        buttLong = (Button) findViewById(R.id.buttonLong);
        buttLong.setOnClickListener((View.OnClickListener) this);
        buttShort = (Button) findViewById(R.id.buttonShort);
        buttShort.setOnClickListener((View.OnClickListener) this);
        listViewTime = (ListView) findViewById(R.id.listViewTime);
        chatListRefresh();

        listViewTime.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (idList.contains(id)) {
                    // view.setBackgroundColor(Color.WHITE);
                } else {
                    // view.setBackgroundColor(Color.RED);
                    idList.add(id);
                    String timeAtPosition = (String) adapterView.getItemAtPosition(position);
                    myRefListProcReserv.child(day + "-" + month + "-" + year).push().setValue(timeAtPosition);
                }
            }

        });
    }

    protected void SetData(int mDay, int mMonth, int mYear) {
        day = mDay;
        month = mMonth;
        year = mYear;
    }

    private void chatListRefresh() {
        //-----Отображение в базе данных сообщений
        myRefListTime.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot chatDS) {
                final List<String> timeList = new ArrayList<String>();
                for (DataSnapshot battle : chatDS.getChildren())
                    timeList.add((String) battle.getValue());
                ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(ChooseTime.this,
                        android.R.layout.simple_list_item_1,
                        timeList.toArray(new String[timeList.size()]));
                listViewTime.setAdapter(timeAdapter);
                TimeListRefresh();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void TimeListRefresh() {
        myRefListProcReserv.child(day + "-" + month + "-" + year).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot chatDS) {
                final List<String> ProcReservList = new ArrayList<String>();
                for (DataSnapshot battle : chatDS.getChildren())
                    ProcReservList.add((String) battle.getValue());
                ArrayAdapter<String> ProcReservTimeAdapter = new ArrayAdapter<>(ChooseTime.this,
                        android.R.layout.simple_list_item_1,
                        ProcReservList.toArray(new String[ProcReservList.size()]));
                ///////////////////////
                for (int i = 0; i < listViewTime.getCount(); i++) {
                    String et = String.valueOf(listViewTime.getItemAtPosition(i));
                    System.out.print("");
                    for (int k = 0; k < ProcReservList.size(); k++) {
                        String p = ProcReservList.get(k);

                        if (et.equals(p)) {
                            listViewTime.getChildAt(i).setBackgroundColor(Color.RED);
                        }
                        //else {
                         //   listViewTime.getChildAt(i).setBackgroundColor(Color.WHITE);
                      //  }
                    }
                }

                //////////////////////
                // listViewTime.setAdapter(timeAdapter);


            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }


    @Override
    public void onClick(View v) {
        // Intent intent_MyTasks = new Intent(this, MyTasks.class);
        switch (v.getId()) {
            case R.id.buttonLong:
                int currentApiVersion1 = android.os.Build.VERSION.SDK_INT;
                if (currentApiVersion1 > android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
                    hour1 = timePicker.getHour();
                    min1 = timePicker.getMinute();
                } else {
                    hour1 = timePicker.getCurrentHour();
                    min1 = timePicker.getCurrentMinute();
                }
                if (min1 < 10) {
                    textViewTime1.setText(hour1 + ":0" + min1);
                } else {
                    textViewTime1.setText(hour1 + ":" + min1);
                }
                break;
            case R.id.buttonShort:
                int currentApiVersion2 = android.os.Build.VERSION.SDK_INT;
                if (currentApiVersion2 > android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
                    hour2 = timePicker.getHour();
                    min2 = timePicker.getMinute();
                } else {
                    hour2 = timePicker.getCurrentHour();
                    min2 = timePicker.getCurrentMinute();
                }
                if (min2 < 10) {
                    textViewTime2.setText(hour2 + ":0" + min2);
                } else {
                    textViewTime2.setText(hour2 + ":" + min2);
                }
                break;

        }
    }
}
