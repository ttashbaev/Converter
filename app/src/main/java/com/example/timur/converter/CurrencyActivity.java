package com.example.timur.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.timur.converter.CurrencyModel.Rates;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyActivity extends AppCompatActivity implements OnItemSelectedListener, TextWatcher{
    private Spinner spCurrencyOne, spCurrencyTwo;
    private EditText etCurrencyOne, etCurrencyTwo;
    private RetrofitService service;
    private  String valueFirst, valueSecond;
    private double currencyOne, currencyTwo ,result;
    private double resOne, resTwo;
    private int positionTwo ,positionOne;
    private String[] currency;
    private ArrayList<String> arrayList = new ArrayList<>();
    private TextView tvCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        spCurrencyOne = findViewById(R.id.spCurrencyOne);
        spCurrencyTwo = findViewById(R.id.spCurrencyTwo);
        etCurrencyOne = findViewById(R.id.etCurrencyOne);
        etCurrencyTwo = findViewById(R.id.etCurrencyTwo);
        tvCurrency = findViewById(R.id.tvCurrency);
        currency = getResources().getStringArray(R.array.currency);
        service = StartApplication.get(this).getRetrofit();

        sendRequest();
        spCurrencyOne.setOnItemSelectedListener(this);
        spCurrencyTwo.setOnItemSelectedListener(this);
        etCurrencyOne.addTextChangedListener(this);
    }

    private void sendRequest () {
        Call<CurrencyModel> currencyModel = service.getJSONList();
        currencyModel.enqueue(new Callback<CurrencyModel>() {
            @Override
            public void onResponse(Call<CurrencyModel> call, Response<CurrencyModel> response) {

                CurrencyModel currencyModel = response.body();

                if (response.isSuccessful() && response.body() != null) {
                    //for (int i = 0; i < currency.length; i++) {
                        arrayList.add(currencyModel.getRates().getAUD());
                        arrayList.add(currencyModel.getRates().getBGN());
                        arrayList.add(currencyModel.getRates().getBRL());
                        arrayList.add(currencyModel.getRates().getCAD());
                        arrayList.add(currencyModel.getRates().getCHF());
                        arrayList.add(currencyModel.getRates().getCNY());
                        arrayList.add(currencyModel.getRates().getCZK());
                        arrayList.add(currencyModel.getRates().getDKK());
                        arrayList.add(currencyModel.getRates().getGBP());
                        arrayList.add(currencyModel.getRates().getHKD());
                        arrayList.add(currencyModel.getRates().getHRK());
                        arrayList.add(currencyModel.getRates().getHUF());
                        arrayList.add(currencyModel.getRates().getIDR());
                        arrayList.add(currencyModel.getRates().getILS());
                        arrayList.add(currencyModel.getRates().getINR());
                        arrayList.add(currencyModel.getRates().getISK());
                        arrayList.add(currencyModel.getRates().getJPY());
                        arrayList.add(currencyModel.getRates().getKRW());
                        arrayList.add(currencyModel.getRates().getMXN());
                        arrayList.add(currencyModel.getRates().getMYR());
                        arrayList.add(currencyModel.getRates().getNOK());
                        arrayList.add(currencyModel.getRates().getNZD());
                        arrayList.add(currencyModel.getRates().getPHP());
                        arrayList.add(currencyModel.getRates().getPLN());
                        arrayList.add(currencyModel.getRates().getRON());
                        arrayList.add(currencyModel.getRates().getRUB());
                        arrayList.add(currencyModel.getRates().getSEK());
                        arrayList.add(currencyModel.getRates().getSGD());
                        arrayList.add(currencyModel.getRates().getTHB());
                        arrayList.add(currencyModel.getRates().getTRY());
                        arrayList.add(currencyModel.getRates().getUSD());
                        arrayList.add(currencyModel.getRates().getZAR());
                  //  }
                    Log.d("SUCCESS", "get API " + arrayList);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(CurrencyActivity.this,
                            android.R.layout.simple_spinner_item,currency);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spCurrencyOne.setAdapter(adapter);
                    spCurrencyTwo.setAdapter(adapter);
                }


            }

            @Override
            public void onFailure(Call<CurrencyModel> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                /*Intent intent = new Intent(CurrencyActivity.this, MainActivity.class);
                startActivity(intent);*/
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle("Currency");
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        valueFirst = etCurrencyOne.getText().toString();

        valueSecond = etCurrencyTwo.getText().toString();

        switch (adapterView.getId()) {
            case R.id.spCurrencyOne:
                spCurrencyOne.setSelection(position);
                //for (int i = 0; i < currency.length; i++){

                positionOne = spCurrencyOne.getSelectedItemPosition();
                currencyOne = Double.parseDouble(String.valueOf(arrayList.get(position)));
                result = getConverter();
                //etLengthTwo.setText(String.valueOf(result));
                etCurrencyTwo.setText(String.valueOf(new DecimalFormat("##.#####").format(result)));
                tvCurrency.setText(String.valueOf(new DecimalFormat("##.#####").format(currencyTwo / currencyOne)));
                    Log.d("Check", "first SP: " + currencyOne);
               // }

                break;
            case R.id.spCurrencyTwo:
                spCurrencyTwo.setSelection(position);
                positionTwo = spCurrencyTwo.getSelectedItemPosition();
                currencyTwo = Double.parseDouble(String.valueOf(arrayList.get(position)));
                result = getConverter();
                //etLengthTwo.setText(String.valueOf(result));
                etCurrencyTwo.setText(String.valueOf(new DecimalFormat("##.#####").format(result)));
                tvCurrency.setText(String.valueOf(new DecimalFormat("##.#####").format(currencyTwo / currencyOne)));
                Log.d("Check", "second SP: " + currencyTwo);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public double getConverter () {
        if (valueFirst != null && !valueFirst.equals("")) {
            resOne = Double.parseDouble(valueFirst);
            resTwo = Double.parseDouble(valueSecond);
            result = converterCurrency(positionOne, positionTwo, resOne, currencyOne, currencyTwo);
            return result;
        } else {
            //currencyOne = 0;
        }
        return result;
    }

    public double converterCurrency (int posOne, int posTwo, double resOne, double value, double result) {
        //double result = 0;
        if (posOne == posTwo) {
            result = value;
        } else {
            //result = result / value;
            return ((resOne * result) / value);
        }

        return ((resOne * result) / value);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable.length() > 0) {
            valueFirst = etCurrencyOne.getText().toString();
            valueSecond = etCurrencyTwo.getText().toString();
            result = getConverter();
            etCurrencyTwo.setText(String.valueOf(new DecimalFormat("##.#####").format(result)));
        }
        if (editable.length() == 0) {
            etCurrencyTwo.setText("0");
        }

    }
}
