package com.wew.health.deltahacks2019;

import android.app.Activity;
import android.content.Intent;
import android.os.Debug;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class PatientListActivity extends AppCompatActivity {
    private static final String ORDER_LIST = "new_food_order";
    private static final String DASHBOARD_LIST = "patient_dashboard";

    private ImageView dashboardAllTab;
    private ImageView dashboardAlertTab;
    private int currentTab = 0;//0 == alert list, 1 == all list

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        //sets the status bar color
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.azure));
        }
        setTitle("");

        dashboardAlertTab = findViewById(R.id.dashboardAlert);
        dashboardAllTab = findViewById(R.id.dashboardAll);

        dashboardAlertTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchLists(dashboardAlertTab);
            }
        });

        dashboardAllTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchLists(dashboardAllTab);
            }
        });

        BottomNavigationView bottomNavView = findViewById(R.id.navigation);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.navigation_patients:
                        break;//we are on this patients page so don't start a new activity

                    case R.id.navigation_order:
                        intent = new Intent(getBaseContext(), PersonChoiceActivity.class);
                        intent.putExtra("SOURCE",0);
                        startActivity(intent);
                        break;

                    case R.id.navigation_settings:
                        //nope
                }
                return true;
            }
        });

        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            Log.i("Borbot fragment create","Loading fragment container...");
            fragment = createStartingFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }else{
            Log.i("Borbot fragment create","Not null...");
        }
    }

    public void switchLists(View tab){
        switch (tab.getId()){
            case R.id.dashboardAlert:
                //if already on alerts list, then do nothing
                if (currentTab == 0)return;
                PatientAllListFragment fragment = (PatientAllListFragment) fm.findFragmentById(R.id.fragment_container);
                fragment.setDestination(DASHBOARD_LIST);
                fm.beginTransaction()
                        .replace(R.id.fragment_container, new PatientAlertsListFragment())
                        .commit();
                currentTab = 0;

                break;
            case R.id.dashboardAll:
                //if already on all list, then do nothing
                if (currentTab == 1)return;
                fm.beginTransaction()
                        .replace(R.id.fragment_container, new PatientAllListFragment())
                        .commit();
                currentTab = 1;

                break;
        }
    }

    protected Fragment createStartingFragment(){return new PatientAlertsListFragment();}

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }
}
