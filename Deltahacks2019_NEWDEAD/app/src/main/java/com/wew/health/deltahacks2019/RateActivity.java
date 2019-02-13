package com.wew.health.deltahacks2019;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class RateActivity extends AppCompatActivity {

    private ActivityHelper mActivityHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate);

        //sets the status bar color
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.azure));
        }
        setTitle("");

        mActivityHelper = new ActivityHelper();

        final ImageView great = findViewById(R.id.great);
        final ImageView okay = findViewById(R.id.okay);
        final ImageView bad = findViewById(R.id.bad);
        final ImageView doneButton = findViewById(R.id.doneButton);
        great.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivityHelper.toggleOptionSelected(view.getContext(),great,R.drawable.option_great_selected,R.drawable.option_great);
                doneButton.setImageResource(R.drawable.btn_done_active);
                doneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),DashboardActivity.class);
                        finish();
                        startActivity(intent);
                    }
                });
            }
        });

        ImageView exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DashboardActivity.class);
                finish();
                startActivity(intent);
            }
        });

        TextView headerMessage = findViewById(R.id.rateHeaderMessage);
    }
}
