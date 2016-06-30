package com.example.mitzicubedo.stores.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mitzicubedo.stores.R;

/**
 * Activity that displays a splash image for N amount of time
 *
 * @author Mitzi <3
 */
public class SplashActivity extends Activity {
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); //close activity
            }
        }, SPLASH_TIME_OUT);
    }
}
