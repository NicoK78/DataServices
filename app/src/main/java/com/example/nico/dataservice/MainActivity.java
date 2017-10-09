package com.example.nico.dataservice;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.android.datetimepicker.date.DatePickerDialog;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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

            //startActivity(new Intent(MainActivity.this, ResultActivity.class));
                new DownloadDatas().execute("http://google.fr");
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

    // GET REQUEST
    private class DownloadDatas extends AsyncTask<String, Void, String> {
        /** The system calls this to perform work in a worker thread and * delivers it the parameters given to AsyncTask.execute() */
        protected String doInBackground(String... urls) {
            try {
                return loadStringFromNetwork(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
        /** The system calls this to perform work in the UI thread and delivers * the result from doInBackground() */
        protected void onPostExecute(String str) {
            Log.d("TAG", str);
        }
    }

    protected String loadStringFromNetwork(String str) throws IOException {
        URL url = new URL(str);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);

        // Starts the query
        conn.connect();
        int response = conn.getResponseCode();
        Log.d("TAG", "The response is: " + response);
        InputStream is = conn.getInputStream();

        String temp = "";
        int current = is.read();
        while(current != -1) {
            temp += (char) current;
            current = is.read();
        }

        is.close();
        conn.disconnect();

        return temp;
    }
}
