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

public class MassActivity extends AppCompatActivity implements TextWatcher, OnItemSelectedListener {
    private Spinner spMassOne, spMassTwo;
    private EditText etMassOne, etMassTwo;
    private int positionOne, positionTwo;
    private String valueFirst, valueSecond;
    private double resOne, resTwo, result;
    private MassConverter massConverter;
    private SQLiteHelperMass sqLiteHelperMass;
    private MassModel massModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        spMassOne = findViewById(R.id.spMassOne);
        spMassTwo = findViewById(R.id.spMassTwo);
        etMassOne = findViewById(R.id.etMassOne);
        etMassTwo = findViewById(R.id.etMassTwo);

        sqLiteHelperMass = new SQLiteHelperMass(this);
        String[] mass = getResources().getStringArray(R.array.mass);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mass);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spMassOne.setAdapter(adapter);
        spMassTwo.setAdapter(adapter);

        massModel = new MassModel();

        sqLiteHelperMass.getData(massModel);

        etMassOne.setText(String.valueOf(massModel.getFirstMass()));
        spMassOne.setSelection(massModel.getFirstMassSpinner());
        etMassTwo.setText(String.valueOf(massModel.getSecondMass()));
        spMassTwo.setSelection(massModel.getSecondMassSpinner());

        massConverter = new MassConverter();

        spMassOne.setOnItemSelectedListener(this);
        spMassTwo.setOnItemSelectedListener(this);
        etMassOne.addTextChangedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        valueFirst = etMassOne.getText().toString();
        valueSecond = etMassTwo.getText().toString();
        switch (item.getItemId()) {
            case android.R.id.home:
                sqLiteHelperMass.clearData();
                MassModel model = new MassModel();
                if (valueFirst != null && !valueFirst.isEmpty()) {
                    model.setFirstMass(Double.valueOf(etMassOne.getText().toString()));
                    model.setFirstMassSpinner(spMassOne.getSelectedItemPosition());
                    model.setSecondMass(Double.valueOf(etMassTwo.getText().toString()));
                    model.setSecondMassSpinner(spMassTwo.getSelectedItemPosition());
                    sqLiteHelperMass.saveLength(model);
                }

                /*Intent intent = new Intent(MassActivity.this, MainActivity.class);
                startActivity(intent);*/
                //setResult(RESULT_OK, intent);
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle("Mass");
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
            valueFirst = etMassOne.getText().toString();
            valueSecond = etMassTwo.getText().toString();
            result = getConverter();
            etMassTwo.setText(String.valueOf(new DecimalFormat("##.#####").format(result)));
        } else {
            etMassTwo.setText("0");
        }

        //etMassTwo.setText(String.valueOf(result));

    }

    public double getConverter() {
        if (valueFirst != null && !valueFirst.equals("")) {
            resOne = Double.valueOf(valueFirst);
            result = massConverter.converterMass(positionOne, positionTwo, resOne, resTwo);
            return result;
        } else {
            resOne = 0;
        }
        return result;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        valueFirst = etMassOne.getText().toString();
        valueSecond = etMassTwo.getText().toString();
        switch (adapterView.getId()) {
            case R.id.spMassOne:
                spMassOne.setSelection(position);
                positionOne = spMassOne.getSelectedItemPosition();
                result = getConverter();
                //etMassTwo.setText(String.valueOf(result));
                etMassTwo.setText(String.valueOf(new DecimalFormat("##.#####").format(result)));
                break;
            case R.id.spMassTwo:
                spMassTwo.setSelection(position);
                positionTwo = spMassTwo.getSelectedItemPosition();
                result = getConverter();
                //etMassTwo.setText(String.valueOf(result));
                etMassTwo.setText(String.valueOf(new DecimalFormat("##.#####").format(result)));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
