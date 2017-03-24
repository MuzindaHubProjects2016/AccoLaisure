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
import com.example.murove.laisureApp.utils.Constants;

public class AddAccommodation extends AppCompatActivity {

    private EditText etAccommodationName;
    private EditText etPhoneNumber;
    private EditText etcity;
    private EditText etcost;
    private EditText etPackages;

    private Button btnSave;

    private dbAccolaisure db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etAccommodationName = (EditText) findViewById(R.id.txtAccommodationName);
        etPhoneNumber = (EditText) findViewById(R.id.txtAccommodationPhoneNumber);
        etcity = (EditText) findViewById(R.id.txtCity);
        etcost = (EditText) findViewById(R.id.txtCost);
        etPackages= (EditText) findViewById(R.id.txtPackage);


        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String accommodation = etAccommodationName.getText().toString().trim();
                String phoneNumber = etPhoneNumber.getText().toString().trim();
                String city = etcity.getText().toString().trim();
                String cost = etcost.getText().toString().trim();
                String packages= etPackages.getText().toString().trim();

                db.insertAccommodation(accommodation, phoneNumber, city, cost, packages);

                                Toast.makeText(getApplicationContext(), "Data saved successfully",
                        Toast.LENGTH_LONG ).show();

                Intent intentM = new Intent(getApplicationContext(), AccoLaisure.class);
                startActivity(intentM);
                finish();

            }
        });
    }
}
