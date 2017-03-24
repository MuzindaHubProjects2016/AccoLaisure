package com.example.murove.laisureApp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.murove.laisureApp.R;
import com.example.murove.laisureApp.db.dbAccolaisure;
import com.example.murove.laisureApp.model.Accommodation;

public class EditAccommodation extends AppCompatActivity {


    Accommodation mAccommodation;

    private TextView tvAccommodationName;
    private TextView tvCity;
    private TextView tvCost;
    private TextView tvPhoneNumber;
    private TextView tvServices;

    private Button btnSave;

    private Spinner SpinStatus;

    private dbAccolaisure db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_accommodation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mAccommodation = (Accommodation)getIntent().getSerializableExtra(AccoLaisure.ACCOLAISURE_EXTRA);

        db = new dbAccolaisure(this);


        tvAccommodationName = (TextView) findViewById(R.id.tvAccommodationName);
        tvPhoneNumber  = (TextView) findViewById(R.id.tvPhoneNumber);
        tvCity    =  (TextView) findViewById(R.id.tvCity);
        tvCost  = (TextView) findViewById(R.id.tvCost);
        tvServices   = (TextView) findViewById(R.id.tvServices);

        btnSave = (Button)findViewById(R.id.btnSave);
        SpinStatus = (Spinner)findViewById(R.id.spinner);


        tvAccommodationName.setText(mAccommodation.getAccommodationName());
        tvPhoneNumber.setText(mAccommodation.getPhoneNumber());
        tvCity.setText(mAccommodation.getCity());
        tvCost.setText(mAccommodation.getCost());
        tvServices.setText(mAccommodation.getServices());

  // the save button updates customer's status to IN/OUT in DB

       /* btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String status = SpinStatus.getSelectedItem().toString();

                // converting the String value to int by parsingInt
                db.update(Integer.parseInt(mAccommodation.getId()), status);

                Toast.makeText(getApplicationContext(), "Changes committed Successfully",
                        Toast.LENGTH_LONG ).show();

                Intent i = new Intent(getApplicationContext(), AccoLaisure.class);
                startActivity(i);

            }
        });*/

    }

}
