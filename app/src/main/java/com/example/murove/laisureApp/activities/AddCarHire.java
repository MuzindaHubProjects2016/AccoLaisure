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

public class AddCarHire extends AppCompatActivity {

    private EditText etCompanyName;
    private EditText etPhoneNumber;
    private EditText etAddress;
    private EditText etCarModel;
    private EditText etNumberPlates;
    private EditText etDriverName;
    private EditText etDriverContacts;
    private EditText etCost;

    private Button btnSave;

    private dbAccolaisure db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_hiring);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etCompanyName = (EditText) findViewById(R.id.txtCompanyName);
        etPhoneNumber = (EditText) findViewById(R.id.txtCompanyPhoneNumber);
        etAddress = (EditText) findViewById(R.id.txtCompanyAddress);
        etCarModel = (EditText) findViewById(R.id.txtCarModel);
        etNumberPlates= (EditText) findViewById(R.id.txtNumberPlate);
        etDriverName= (EditText) findViewById(R.id.txtDriverName);
        etDriverContacts= (EditText) findViewById(R.id.txtDriverContact);
        etCost= (EditText) findViewById(R.id.txtCost);


        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String companyName = etCompanyName.getText().toString().trim();
                String phoneNumber = etPhoneNumber.getText().toString().trim();
                String address= etAddress.getText().toString().trim();
                String carModel= etCarModel.getText().toString().trim();
                String numberPlates= etNumberPlates.getText().toString().trim();
                String driverName= etDriverName.getText().toString().trim();
                String driverContacts= etDriverContacts.getText().toString().trim();
                String cost= etCost.getText().toString().trim();

                db.insertCars(companyName, phoneNumber, address, carModel, numberPlates,
                            driverName, driverContacts, cost);




                Toast.makeText(getApplicationContext(), "Data saved successfully",
                        Toast.LENGTH_LONG ).show();

                Intent intentM = new Intent(getApplicationContext(), AccoLaisure.class);
                startActivity(intentM);
                finish();

            }
        });
    }
}
