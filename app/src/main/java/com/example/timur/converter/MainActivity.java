package com.example.timur.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener{
public Button btnMass, btnLength, btnCurrency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnLength = findViewById(R.id.btnLength);
        btnMass = findViewById(R.id.btnMass);
        btnCurrency = findViewById(R.id.btnCurrency);

        btnLength.setOnClickListener(this);
        btnMass.setOnClickListener(this);
        btnCurrency.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLength:
                Intent intentLength = new Intent(this, LengthActivity.class);
                startActivity(intentLength);
                break;
            case R.id.btnMass:
                Intent intentMass = new Intent(this, MassActivity.class);
                startActivity(intentMass);
                break;
            case R.id.btnCurrency:
                Intent intentCurrency = new Intent(this, CurrencyActivity.class);
                startActivity(intentCurrency);
                break;
        }
    }
}
