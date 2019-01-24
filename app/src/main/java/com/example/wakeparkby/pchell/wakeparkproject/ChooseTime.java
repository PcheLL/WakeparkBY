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
    private final List<String> timeList = new ArrayList<String>();
    private static String infoLocationName;
    private static String timeAtPosition;
    private static String deleteTimeAtPosition;
    private static String infoDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_time);
        buttLong = (Button) findViewById(R.id.buttonLong);
        buttLong.setOnClickListener((View.OnClickListener) this);
        buttShort = (Button) findViewById(R.id.buttonShort);
        buttShort.setOnClickListener((View.OnClickListener) this);
        buttSelectTime = (Button) findViewById(R.id.buttonSelectTime);
        buttSelectTime.setOnClickListener((View.OnClickListener) this);
        listViewTime = (ListView) findViewById(R.id.listViewTime);
        timeListRefresh();
        timeListRefresh1();

        listViewTime.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (idList.contains(id)) {
                    timeAtPosition = (String) adapterView.getItemAtPosition(position);
                    for (int i = 0; i < timeAtPosition.length(); i++) {
                        String b = String.valueOf(timeAtPosition.charAt(i));
                        if (b.equals(" ")) {
                            deleteTimeAtPosition = timeAtPosition.substring(0, i);
                            break;
                        }
                    }
                    myRefListProcReserv.child(infoLocationName).child(infoDate).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot findTimeDS) {
                            final List<String> findTimeList = new ArrayList<String>();
                            for (DataSnapshot battle : findTimeDS.getChildren()) {
                                String findValue = (String) battle.getValue();
                                if (findValue.equals(deleteTimeAtPosition)) {
                                    //-----Поиск значения в БД  и удаление его
                                    String findValueKey = battle.getKey();
                                    myRefListProcReserv = database.getReference("ProcessOfReservation/" + infoLocationName + "/" + infoDate + "/" + findValueKey);
                                    myRefListProcReserv.removeValue();
                                    //timeListRefresh1(); //notifeDataSet... УСТРАНИТЬ
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }
                    });
                } else {
                    idList.add(id);
                    timeAtPosition = (String) adapterView.getItemAtPosition(position);
                    myRefListProcReserv.child(infoLocationName).child(infoDate).push().setValue(timeAtPosition);
                    timeListRefresh1();
                }
            }
        });
    }

    protected void SetData(int mDay, int mMonth, int mYear) {
        day = mDay;
        month = mMonth;
        year = mYear;
        infoDate = day + "-" + month + "-" + year;
    }

    private void timeListRefresh() {
        //-----Отображение в базе данных сообщений
        myRefListTime.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot timeDS) {
                for (DataSnapshot battle : timeDS.getChildren())
                    timeList.add((String) battle.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void timeListRefresh1() {
        myRefListProcReserv.child(infoLocationName).child(infoDate).addValueEventListener(new ValueEventListener() {
            final List<String> ProcReservList = new ArrayList<String>();
            final List<String> finalProcReservList = new ArrayList<String>();

            @Override
            public void onDataChange(@NonNull DataSnapshot procResDS) {
                for (DataSnapshot battle : procResDS.getChildren())
                    ProcReservList.add((String) battle.getValue());
                int cl = ProcReservList.size();
                if (cl == 0) {
                    ArrayAdapter<String> timeAdapter1 = new ArrayAdapter<>(ChooseTime.this,
                            android.R.layout.simple_list_item_1,
                            timeList.toArray(new String[timeList.size()]));
                    listViewTime.setAdapter(timeAdapter1);
                } else {
                    for (int c = 0; c < timeList.size(); c++) {
                        String et = timeList.get(c);
                        int counter = 0;

                        for (int k = 0; k < ProcReservList.size(); k++) {
                            String p = ProcReservList.get(k);
                            if (et.equals(p)) {
                                finalProcReservList.add(et + "    ОЖИДАНИЕ БРОНИРОВАНИЯ");
                                counter = 1;
                            } else if (cl == k + 1) {
                                if (counter == 0) {
                                    finalProcReservList.add(et);
                                }
                            }
                        }
                    }
                    ArrayAdapter<String> timeAdapter2 = new ArrayAdapter<>(ChooseTime.this,
                            android.R.layout.simple_list_item_1,
                            finalProcReservList.toArray(new String[finalProcReservList.size()]));
                    listViewTime.setAdapter(timeAdapter2);
                    //listViewTime.deferNotifyDataSetChanged(); -- ОПТИМИЗИРОВАТЬ
                }
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
            case R.id.buttonEnter:

                break;

        }
    }

    public void infoLocation(String locationName) {

        infoLocationName = (locationName);
    }
}
