package com.example.nico.dataservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.android.datetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button button;
//    DatePicker datePicker;
    EditText editTextCity;
    EditText editTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        editTextCity = (EditText) findViewById(R.id.editTextCity);
//        datePicker = (DatePicker) findViewById(R.id.datePicker);
        editTextDate = (EditText) findViewById(R.id.editTextDate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Log.d("TAG", "TEXT : " + editTextCity.getText());
//            Log.d("TAG", "DATE : " + datePicker.getDayOfMonth() + "/" + (datePicker.getMonth()+1));

            startActivity(new Intent(MainActivity.this, ResultActivity.class));
            }
        });

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                DatePickerDialog.newInstance(MainActivity.this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show(getFragmentManager(), "Calendar");
            }
        });
    }

    @Override
    public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {

        editTextDate.setText(year + "-" + monthOfYear + "-" + dayOfMonth);

    }
}
