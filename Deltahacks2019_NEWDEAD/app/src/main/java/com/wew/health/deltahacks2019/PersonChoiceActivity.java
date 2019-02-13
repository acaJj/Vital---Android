package com.wew.health.deltahacks2019;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class PersonChoiceActivity extends AppCompatActivity {
    private static final String ORDER_LIST = "new_food_order";
    private static final String DASHBOARD_LIST = "patient_dashboard";

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_choice);

        //sets the status bar color
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.azure));
        }
        setTitle("");

        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }

        BottomNavigationView bottomNavView = findViewById(R.id.navigation);
        bottomNavView.setSelectedItemId(R.id.navigation_order);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.navigation_patients:
                        intent = new Intent(getBaseContext(), DashboardActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.navigation_order:
                        break;//already here, don't do anything

                    case R.id.navigation_settings:
                        //nope
                }
                return true;
            }
        });
    }

    /**
     * Creates a PatientAllListFragment so the user can choose which patient to make food for
     * recyclerview item onClick destination is set to NewOrderActivity
     * @return the patient list fragment of patients to create a food order for
     */
    protected Fragment createFragment(){
        PatientAllListFragment fragment = new PatientAllListFragment();
        fragment.setDestination(ORDER_LIST);
        return fragment;
    }
}
