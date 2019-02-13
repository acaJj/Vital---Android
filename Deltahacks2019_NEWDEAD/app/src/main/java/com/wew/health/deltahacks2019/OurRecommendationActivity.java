package com.wew.health.deltahacks2019;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class OurRecommendationActivity extends AppCompatActivity {

    private ActivityHelper mActivityHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommendation);

        //sets the status bar color
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.azure));
        }
        setTitle("");

        mActivityHelper = new ActivityHelper();

        ImageView exitButton = findViewById(R.id.recommendationBack);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NewOrderActivity.class);
                finish();
                startActivity(intent);
            }
        });

        final ImageView avocadoToastOption = findViewById(R.id.avocadoToast);
        final ImageView oatmealOption = findViewById(R.id.oatmeal);
        final ImageView plainToastOption = findViewById(R.id.plainToast);
        final ImageView serveButton = findViewById(R.id.serveButton);
        avocadoToastOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivityHelper.toggleOptionSelected(view.getContext(),avocadoToastOption,
                        R.drawable.list_avocado_toast_selected,R.drawable.list_avocado_toast);

                serveButton.setImageResource(R.drawable.btn_serve_active);
                serveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Toast.makeText(OurRecommendationActivity.this, "You have prepared a meal", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(), ServedActivity.class);
                        finish();
                        startActivity(intent);

                    }
                });
            }
        });

        oatmealOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivityHelper.toggleOptionSelected(view.getContext(),oatmealOption,
                        R.drawable.list_oatmean_selected,R.drawable.list_oatmeal);

                serveButton.setImageResource(R.drawable.btn_serve_active);
                serveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Toast.makeText(OurRecommendationActivity.this, "You have prepared a meal", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(), ServedActivity.class);
                        finish();
                        startActivity(intent);

                    }
                });
            }
        });

        plainToastOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivityHelper.toggleOptionSelected(view.getContext(),plainToastOption,
                        R.drawable.list_plain_toast_selected,R.drawable.list_plain_toast);

                serveButton.setImageResource(R.drawable.btn_serve_active);
                serveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Toast.makeText(OurRecommendationActivity.this, "You have prepared a meal", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(), ServedActivity.class);
                        finish();
                        startActivity(intent);

                    }
                });
            }
        });

    }
}
