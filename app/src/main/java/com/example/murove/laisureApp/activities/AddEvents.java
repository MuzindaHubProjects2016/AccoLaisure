package com.example.murove.laisureApp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.murove.laisureApp.R;
import com.example.murove.laisureApp.db.dbAccolaisure;

import java.util.Calendar;
import java.util.Date;

public class AddEvents extends AppCompatActivity {

    private EditText etArtistName;
    private EditText etPhoneNumber;
    private EditText etVenue;
    private EditText etCity;
    private EditText etDate;
    private EditText etTime;
    private EditText etCost;

    private Button btnSave;

    private dbAccolaisure db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events2);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etArtistName = (EditText) findViewById(R.id.txtArtistName);
        etPhoneNumber = (EditText) findViewById(R.id.txtEventPhoneNumber);
        etVenue = (EditText) findViewById(R.id.txtEventVenue);
        etCity = (EditText) findViewById(R.id.txtEventCity);
        etDate= (EditText) findViewById(R.id.txtEventDate);
        etTime= (EditText) findViewById(R.id.txtEventTime);
        etCost= (EditText) findViewById(R.id.txtCost);


        btnSave = (Button) findViewById(R.id.btnSaveEvent);

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String artistName = etArtistName.getText().toString().trim();
                String phoneNumber = etPhoneNumber.getText().toString().trim();
                String venue= etVenue.getText().toString().trim();
                String city= etCity.getText().toString().trim();
                String date= etDate.getText().toString().trim();
                String time= etTime.getText().toString().trim();
                String cost= etCost.getText().toString().trim();

                db.insertEvents(artistName, phoneNumber, venue, city, date, time, cost);




                Toast.makeText(getApplicationContext(), "Data saved successfully",
                        Toast.LENGTH_LONG ).show();

                Intent intentM = new Intent(getApplicationContext(), AccoLaisure.class);
                startActivity(intentM);
                finish();

            }
        });

   }


    //this method sets the current date
    private String getServiceDate(){

        Date currentDate = Calendar.getInstance().getTime();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("YYYY/MM/dd");

        return  simpleDateFormat.format(currentDate);


    }

}