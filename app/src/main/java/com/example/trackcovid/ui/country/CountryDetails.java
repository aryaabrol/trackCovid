package com.example.trackcovid.ui.country;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.trackcovid.R;

public class CountryDetails extends AppCompatActivity {

    private TextView totalcases,todaycases,totaldeaths,todaydeaths,totalrecovered,country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        totalcases=(TextView) findViewById(R.id.number_totalCases);
        todaycases=(TextView) findViewById(R.id.number_todayCases);
        totaldeaths=(TextView) findViewById(R.id.number_totalDeaths);
        todaydeaths=(TextView) findViewById(R.id.number_todayDeaths);
        totalrecovered=(TextView) findViewById(R.id.number_totalRecovered);
        country=(TextView) findViewById(R.id.text_home);

        covidCountry covidCountry=getIntent().getParcelableExtra("EXTRA COVID");

        totalcases.setText(covidCountry.getCases());
        todaycases.setText(covidCountry.getTodayCases());
        totaldeaths.setText(covidCountry.getDeaths());
        todaydeaths.setText(covidCountry.getTodayDeaths());
        totalrecovered.setText(covidCountry.getRecovered());
        country.setText(covidCountry.getCountry());
    }
}
