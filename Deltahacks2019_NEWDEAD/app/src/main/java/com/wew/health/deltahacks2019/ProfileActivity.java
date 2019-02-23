package com.wew.health.deltahacks2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_profile);

        //sets the status bar color
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.azure));
        }
        setTitle("");

        Bundle extras = getIntent().getExtras();
        UUID id;
        String firstName = "", lastName = "", seat = "", alertMessage = "";
        int age, alertType;
        long lastTimeServed = 0,nextTimeServed = 0;

        if (extras != null){
            id = UUID.fromString(extras.getString("id"));
            firstName = extras.getString("firstName");
            lastName = extras.getString("lastName");
            seat = extras.getString("seat");
            alertMessage = extras.getString("alertMessage");
            age = extras.getInt("age");
            alertType = extras.getInt("alertType");
            lastTimeServed = extras.getLong("lastTimeServed");
            nextTimeServed = extras.getLong("nextTimeServed");
        }

        TextView txtPatientName = findViewById(R.id.ProfileName);
        TextView txtLastTime = findViewById(R.id.lastTimeServedProfile);
        TextView txtNextTime = findViewById(R.id.nextTimeServedProfile);
        String patientName = firstName + lastName;
        txtPatientName.setText(patientName);

        ImageView profilePic = findViewById(R.id.patientProfilePicture);

        //TODO: set profile image when Raf finishes with updated images
        //set profile images based on what patient we get, patients are hardcoded so just check names and manually set imgs
        if (firstName.equals("Peter")){
            //set to Peter Parker's image
        }else if (firstName.equals("Jack")){
            //set to Jack Pearson's image
        }else if (firstName.equals("William")){
            //set to Randall's dad's image
        }

        //TODO: times are displayed as fixed times, in the future change it with proper time methods
        txtLastTime.setText("8h");
        txtNextTime.setText("3h");

        ImageView topBar = findViewById(R.id.profileHeader);
        topBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DashboardActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
