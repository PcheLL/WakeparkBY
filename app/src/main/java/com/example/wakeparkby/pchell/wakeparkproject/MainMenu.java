/*package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    private Button buttChoosePl;
    private Button buttGiveSeasonTickets;
    private Button buttPrice;
    private Button buttTakeSeasonTickets;
    private Button buttChangePrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        buttChoosePl = (Button) findViewById(R.id.buttonChoosePl);
        buttChoosePl.setOnClickListener((View.OnClickListener) this);
        buttGiveSeasonTickets = (Button) findViewById(R.id.buttonGiveSeasonTickets);
        buttGiveSeasonTickets.setOnClickListener((View.OnClickListener) this);
        buttPrice = (Button) findViewById(R.id.buttonPrice);
        buttPrice.setOnClickListener((View.OnClickListener) this);
        buttTakeSeasonTickets = (Button) findViewById(R.id.buttonTakeSeasonTickets);
        buttTakeSeasonTickets.setOnClickListener((View.OnClickListener) this);
        buttChangePrice = (Button) findViewById(R.id.buttonChangePrice);
        buttChangePrice.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_LocationSelection = new Intent(this, LocationSelection.class);
        Intent intent_Give_Season_Tickets = new Intent(this, GiveSeasonTickets.class);
        Intent intent_Take_Season_Tickets = new Intent(this, TakeSeasonTickets.class);
        Intent intent_Price = new Intent(this, Price.class);
        Intent intent_Change_Price = new Intent(this, ChangePrices.class);

        switch (v.getId()) {
            case R.id.buttonChoosePl:
                startActivity(intent_LocationSelection);
                break;
            case R.id.buttonGiveSeasonTickets:
                startActivity(intent_Give_Season_Tickets);
                break;
            case R.id.buttonPrice:
                startActivity(intent_Price);
                break;
            case R.id.buttonTakeSeasonTickets:
                startActivity(intent_Take_Season_Tickets);
                break;
            case R.id.buttonChangePrice:
                startActivity(intent_Change_Price);
                break;
        }
    }
}*/

package com.example.wakeparkby.pchell.wakeparkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        //        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.addDrawerListener(toggle);
        //toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent_LocationSelection = new Intent(this, LocationSelection.class);
        Intent intent_Give_Season_Tickets = new Intent(this, GiveSeasonTickets.class);
        Intent intent_Take_Season_Tickets = new Intent(this, TakeSeasonTickets.class);
        Intent intent_Price = new Intent(this, Price.class);
        Intent intent_Change_Price = new Intent(this, ChangePrices.class);
        Intent intent_My_Season_Tickets = new Intent(this, MySeasonTickets.class);
        Intent intent_History = new Intent(this, History.class);
        int id = item.getItemId();

         if (id == R.id.nav_ChoosePl) {
            startActivity(intent_LocationSelection);
        } else if (id == R.id.nav_MySeasonTickets) {
             startActivity(intent_My_Season_Tickets);
        } else if (id == R.id.nav_Price) {
            startActivity(intent_Price);

        } else if (id == R.id.nav_History) {
             startActivity(intent_History);

        } else if (id == R.id.nav_Mark) {

        } else if (id == R.id.nav_Give_Season_Tickets) {
            startActivity(intent_Give_Season_Tickets);

        } else if (id == R.id.nav_Take_Season_Tickets) {
            startActivity(intent_Take_Season_Tickets);

        } else if (id == R.id.nav_Change_Price) {
            startActivity(intent_Change_Price);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
