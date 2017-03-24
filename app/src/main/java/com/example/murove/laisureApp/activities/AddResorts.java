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

public class AddResorts extends AppCompatActivity {

    private EditText etResortName;
    private EditText etPhoneNumber;
    private EditText etbookingHouse;
    private EditText etactivities;
    private EditText etcity;
    private EditText etcost;
//    private EditText etcheckIn;


    private Button btnSave;

    private dbAccolaisure db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resorts1);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etResortName = (EditText) findViewById(R.id.txtCompanyName);
        etPhoneNumber = (EditText) findViewById(R.id.txtCompanyPhoneNumber);
        etbookingHouse = (EditText) findViewById(R.id.txtCompanyAddress);
        etactivities = (EditText) findViewById(R.id.txtCarModel);
        etcity= (EditText) findViewById(R.id.txtNumberPlate);
        etcost= (EditText) findViewById(R.id.txtDriverName);

        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String resortName = etResortName.getText().toString().trim();
                String phoneNumber = etPhoneNumber.getText().toString().trim();
                String bookHouse= etbookingHouse.getText().toString().trim();
                String activities= etactivities.getText().toString().trim();
                String city= etcity.getText().toString().trim();
                String cost= etcost.getText().toString().trim();

                db.insertResorts(resortName, phoneNumber, bookHouse, activities, city, cost);


                Toast.makeText(getApplicationContext(), "Data saved successfully",
                        Toast.LENGTH_LONG ).show();

                Intent intentM = new Intent(getApplicationContext(), AccoLaisure.class);
                startActivity(intentM);
                finish();

            }
        });

            }
}
