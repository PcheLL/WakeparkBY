package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefHistory = database.getReference("HISTORY");
    private ExpandableListView expandableListView;
    private String name = "+375295274820(Катя)";
    private ArrayList<ArrayList<String>> mGroups;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        expandableListView = (ExpandableListView) findViewById(R.id.expListView);
        newExpandableListView();
        refreshReservedList();
    }

    private void newExpandableListView() {

        // Находим наш list
        //Создаем набор данных для адаптера
        ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
        ArrayList<String> children1 = new ArrayList<String>();
        ArrayList<String> children2 = new ArrayList<String>();
        children1.add("Child_1");
        children1.add("Child_2");
        groups.add(children1);
        children2.add("Child_1");
        children2.add("Child_2");
        children2.add("Child_3");
        groups.add(children2);
        //Создаем адаптер и передаем context и список с данными
        ExpandableListAdapter adapter = new ExpandableListAdapter() {

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return mGroups.size();
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return mGroups.get(groupPosition).size();
            }

            @Override
            public Object getGroup(int groupPosition) {
                return mGroups.get(groupPosition);
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return mGroups.get(groupPosition).get(childPosition);
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.group_view, null);
                }

                if (isExpanded) {
                    //Изменяем что-нибудь, если текущая Group раскрыта
                } else {
                    //Изменяем что-нибудь, если текущая Group скрыта
                }

                TextView textGroup = (TextView) convertView.findViewById(R.id.textGroup);
                textGroup.setText("Group " + Integer.toString(groupPosition));

                return convertView;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.child_view, null);
                }

                TextView textChild = (TextView) convertView.findViewById(R.id.textChild);
                textChild.setText(mGroups.get(groupPosition).get(childPosition));

                Button button = (Button) convertView.findViewById(R.id.buttonChild);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      //  Toast.makeText(mContext, "button is pressed", 1000).show();
                    }
                });

                return convertView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }
        };
        expandableListView.setAdapter(adapter);
    }

    private void refreshReservedList() {
        myRefHistory.child(name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot refreshReservedListDS) {
                final List<String> refreshReservedList = new ArrayList<String>();
                for (DataSnapshot battle1 : refreshReservedListDS.getChildren()) {
                    String findChild1 = (String) battle1.getKey();
                    String findChild2 = String.valueOf(refreshReservedListDS.child(findChild1).getChildren());
                    String findValue = String.valueOf(refreshReservedListDS.child(findChild1).child(findChild2).getValue());
                    System.out.print("");

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

}
