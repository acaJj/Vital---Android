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

    final private ImageView doneButton = findViewById(R.id.doneButton);

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

        final ImageView great = findViewById(R.id.great);
        final ImageView okay = findViewById(R.id.okay);
        final ImageView bad = findViewById(R.id.bad);

        //TODO: great button is the only one with the proper selected image, harangue raf until he makes the rest or find one yourself
        great.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = ActivityHelper.toggleOptionSelected(view.getContext(),great,R.drawable.option_great_selected,R.drawable.option_great);
                toggleDone(result);

                //turns off the other 2 options
                if (result == 1){
                    okay.setImageResource(R.drawable.option_okay);
                    bad.setImageResource(R.drawable.option_bad_1);
                }
            }
        });

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = ActivityHelper.toggleOptionSelected(view.getContext(),okay,R.drawable.option_great_selected,R.drawable.option_okay);
                toggleDone(result);
                //turns off the other 2 options
                if (result == 1){
                    great.setImageResource(R.drawable.option_great);
                    bad.setImageResource(R.drawable.option_bad_1);
                }
            }
        });

        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = ActivityHelper.toggleOptionSelected(view.getContext(),bad,R.drawable.option_great_selected,R.drawable.option_bad_1);
                toggleDone(result);
                //turns off the other 2 options
                if (result == 1){
                    great.setImageResource(R.drawable.option_great);
                    okay.setImageResource(R.drawable.option_okay);
                }
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

    /**
     * Toggles the done button on/off
     * @param toggle 1 if button should be turned on, 0 if turned off
     */
    private void toggleDone(int toggle){
        if (toggle == 1){
            doneButton.setImageResource(R.drawable.btn_done_active);
            doneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),DashboardActivity.class);
                    finish();
                    startActivity(intent);
                }
            });
        }else if (toggle == 0){
            doneButton.setImageResource(R.drawable.btn_done_disabled);
            doneButton.setOnClickListener(null);
        }

    }
}
