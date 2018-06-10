package com.example.timur.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class LengthActivity extends AppCompatActivity implements TextWatcher, OnItemSelectedListener{
    private  Spinner spLengthOne, spLengthTwo;
    private  EditText etLengthOne, etLengthTwo;
    private  int positionOne, positionTwo;
    private  String valueFirst, valueSecond;
    private  double resOne, resTwo, result;
    private  LengthConverter lengthConverter;
    private SQLiteHelper sqLiteHelper;
    private LengthModel lengthModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        spLengthOne = findViewById(R.id.spLengthOne);
        spLengthTwo = findViewById(R.id.spLengthTwo);
        etLengthOne = findViewById(R.id.etLengthOne);
        etLengthTwo = findViewById(R.id.etLengthTwo);

        sqLiteHelper = new SQLiteHelper(this);
        String[] length = getResources().getStringArray(R.array.length);

        valueFirst = etLengthOne.getText().toString();
        valueSecond = etLengthTwo.getText().toString();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, length);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spLengthOne.setAdapter(adapter);
        spLengthTwo.setAdapter(adapter);

        lengthModel = new LengthModel();

        sqLiteHelper.getData(lengthModel);

        etLengthOne.setText(String.valueOf(lengthModel.getFirstLength()));
        spLengthOne.setSelection(lengthModel.getFirstSpinner());
        etLengthTwo.setText(String.valueOf(lengthModel.getSecondLength()));
        spLengthTwo.setSelection(lengthModel.getSecondSpinner());

        lengthConverter = new LengthConverter();

        spLengthOne.setOnItemSelectedListener(this);
        spLengthTwo.setOnItemSelectedListener(this);
        etLengthOne.addTextChangedListener(this);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        valueFirst = etLengthOne.getText().toString();
        valueSecond = etLengthTwo.getText().toString();
        switch (item.getItemId()){
            case android.R.id.home:
                sqLiteHelper.clearData();
                LengthModel model = new LengthModel();
                if (valueFirst != null && !valueFirst.isEmpty()) {
                    model.setFirstLength(Double.valueOf(etLengthOne.getText().toString()));
                    model.setFirstSpinner(spLengthOne.getSelectedItemPosition());
                    model.setSecondLength(Double.valueOf(etLengthTwo.getText().toString()));
                    model.setSecondSpinner(spLengthTwo.getSelectedItemPosition());
                    sqLiteHelper.saveLength(model);
                }
                /*Intent intent = new Intent(LengthActivity.this, MainActivity.class);
                startActivity(intent);*/
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle("Length");
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
            valueFirst = etLengthOne.getText().toString();
            valueSecond = etLengthTwo.getText().toString();
            result = getConverter();
            etLengthTwo.setText(String.valueOf(new DecimalFormat("##.#####").format(result)));
        }
        if (editable.length() == 0) {
            etLengthTwo.setText("0");
        }


        //etLengthTwo.setText(String.valueOf(result));

    }

    public double getConverter () {
        if (valueFirst != null && !valueFirst.equals("")) {
            resOne = Double.valueOf(valueFirst);
            result = lengthConverter.converterLength(positionOne, positionTwo, resOne, resTwo);
            return result;
        } else {
            resOne = 0;
        }
        return result;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        valueFirst = etLengthOne.getText().toString();
        valueSecond = etLengthTwo.getText().toString();
        switch (adapterView.getId()) {
            case R.id.spLengthOne:
                spLengthOne.setSelection(position);
                positionOne = spLengthOne.getSelectedItemPosition();
                result = getConverter();
                //etLengthTwo.setText(String.valueOf(result));
                etLengthTwo.setText(String.valueOf(new DecimalFormat("##.#####").format(result)));
                break;
            case R.id.spLengthTwo:
                spLengthTwo.setSelection(position);
                positionTwo = spLengthTwo.getSelectedItemPosition();
                result = getConverter();
                //etLengthTwo.setText(String.valueOf(result));
                etLengthTwo.setText(String.valueOf(new DecimalFormat("##.#####").format(result)));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
