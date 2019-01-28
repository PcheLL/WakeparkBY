package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ChooseTime extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefListTime = database.getReference("ListTime");
    private DatabaseReference myRefListProcReserv = database.getReference("ProcessOfReservation");
    private DatabaseReference myRefListProcReserv2 = database.getReference("ProcessOfReservation");
    private DatabaseReference myRefReserved = database.getReference("RESERVED");
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
    private final List<String> ProcReservList = new ArrayList<String>();
    private final List<String> finalProcReservList = new ArrayList<String>();
    private final List<String> reserverList = new ArrayList<String>();
    private final List<String> visitorsReservList = new ArrayList<String>();
    private final List<String> finalReserverList = new ArrayList<String>();
    private final List<String> finalReserverList2 = new ArrayList<String>();
    private static String infoLocationName;
    private static String timeAtPosition;
    private static String deleteTimeAtPosition;
    private static String infoDate;
    private String nameVisitors = "Катя";
    private String findValue;


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
        timeListRefresh1();
        timeListRefresh2();

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
                            for (DataSnapshot battle : findTimeDS.getChildren()) {
                                findValue = (String) battle.getValue();
                                if (findValue.equals(deleteTimeAtPosition)) {
                                    //-----Поиск значения в БД  и удаление его
                                    String findValueKey = battle.getKey();
                                    myRefListProcReserv = database.getReference("ProcessOfReservation/" + infoLocationName + "/" + infoDate + "/TIME/" + findValueKey);
                                    myRefListProcReserv.removeValue();
                                    //timeListRefresh2(); //notifeDataSet... УСТРАНИТЬ
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
                    myRefListProcReserv.child(infoLocationName).child(infoDate).child("TIME").push().setValue(timeAtPosition);
                    myRefListProcReserv.child(infoLocationName).child(infoDate).child(nameVisitors).push().setValue(timeAtPosition);
                    timeListRefresh2();
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

    private void timeListRefresh1() {
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

    private void timeListRefresh2() {
        myRefListProcReserv.child(infoLocationName).child(infoDate).child("TIME").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot procResDS) {
                for (DataSnapshot battle1 : procResDS.getChildren()){
                        ProcReservList.add((String) battle1.getValue());}
                int cl = ProcReservList.size();
                if (cl == 0) {
                    timeListRefresh3();
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
                    ProcReservList.clear();
                    timeListRefresh3();
                    //listViewTime.deferNotifyDataSetChanged(); -- ОПТИМИЗИРОВАТЬ
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void timeListRefresh3(){
        myRefReserved.child(infoLocationName).child(infoDate).child("TIME").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot timeReservedDS) {
                for (DataSnapshot timeReserved : timeReservedDS.getChildren()){
                    reserverList.add((String) timeReserved.getValue());}
                int cl1 = reserverList.size();
                int cl2 = finalProcReservList.size();
                if (cl2 == 0){
                    if (cl1 == 0){
                        ArrayAdapter<String> timeAdapter1 = new ArrayAdapter<>(ChooseTime.this,
                                R.layout.text_view,
                                timeList.toArray(new String[timeList.size()]));
                        listViewTime.setAdapter(timeAdapter1);
                    }
                }
                 if (cl2 == 0){
                    if (cl1 != 0 ){
                        for (int c = 0; c < timeList.size(); c++) {
                            String et = timeList.get(c);
                            int counter = 0;
                            for (int k = 0; k < cl1; k++) {
                                String p = reserverList.get(k);
                                if (et.equals(p)) {
                                    finalReserverList.add(et + "    ЗАБРОНИРОВАНО");
                                    counter = 1;
                                } else if (cl1 == k + 1) {
                                    if (counter == 0) {
                                        finalReserverList.add(et);
                                    }
                                }
                            }
                        }
                        ArrayAdapter<String> timeAdapter2 = new ArrayAdapter<>(ChooseTime.this,
                                R.layout.text_view,
                                finalReserverList.toArray(new String[finalReserverList.size()]));
                        listViewTime.setAdapter(timeAdapter2);
                    }
                   /* else {
                        ArrayAdapter<String> timeAdapter3 = new ArrayAdapter<>(ChooseTime.this,
                                R.layout.text_view,
                                finalProcReservList.toArray(new String[finalProcReservList.size()]));
                        listViewTime.setAdapter(timeAdapter3);
                       // finalProcReservList.clear();
                        if (reserverList != null) {
                            reserverList.clear();
                        }
                    }*/

                }
                else {
                     if (cl1 != 0 ){
                         for (int c = 0; c < finalProcReservList.size(); c++) {
                             String et = finalProcReservList.get(c);
                             int counter = 0;
                             for (int k = 0; k < cl1; k++) {
                                 String p = reserverList.get(k);
                                 if (et.equals(p)) {
                                     finalReserverList2.add(et + "    ЗАБРОНИРОВАНО");
                                     counter = 1;
                                 } else if (cl1 == k + 1) {
                                     if (counter == 0) {
                                         finalReserverList2.add(et);
                                     }
                                 }
                             }
                         }
                         ArrayAdapter<String> timeAdapter4 = new ArrayAdapter<>(ChooseTime.this,
                                 R.layout.text_view,
                                 finalReserverList2.toArray(new String[finalReserverList2.size()]));
                         listViewTime.setAdapter(timeAdapter4);
                         finalProcReservList.clear();
                         reserverList.clear();
                         ProcReservList.clear();
                         finalReserverList2.clear();
                     }
                     else{
                         ArrayAdapter<String> timeAdapter5 = new ArrayAdapter<>(ChooseTime.this,
                                 R.layout.text_view,
                                 finalProcReservList.toArray(new String[finalProcReservList.size()]));
                         listViewTime.setAdapter(timeAdapter5);
                         finalProcReservList.clear();
                         reserverList.clear();
                         ProcReservList.clear();
                         finalReserverList2.clear();
                     }
                 }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent_BookingDescription = new Intent(this, BookingDescription.class);
        switch (v.getId()) {
            case R.id.buttonLong:
                break;
            case R.id.buttonShort:
                break;
            case R.id.buttonSelectTime:
                myRefListProcReserv2.child(infoLocationName).child(infoDate).child(nameVisitors).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot visitorsDataSnapshot) {
                        // visitorsReservList = (List<String>) visitorsDataSnapshot.getValue();
                        for (DataSnapshot battle : visitorsDataSnapshot.getChildren())
                            visitorsReservList.add((String) battle.getValue());
                        BookingDescription bookingDescription = new BookingDescription();
                        bookingDescription.visitorsReserv(visitorsReservList);

                        // }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                startActivity(intent_BookingDescription);
                break;

        }
    }



    public void infoLocation(String locationName) {

        infoLocationName = (locationName);
    }

    public void clearIdList() {
        idList.clear();
    }
}
