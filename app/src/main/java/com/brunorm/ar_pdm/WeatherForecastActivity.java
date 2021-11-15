package com.brunorm.ar_pdm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class WeatherForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.nav_host_fragment_content_main, ListingFragment.class, null)
                    .commit();
        }
    }
}