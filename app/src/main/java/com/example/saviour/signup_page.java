package com.example.saviour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup_page extends AppCompatActivity {

    EditText name,phoneno,email,adhaar,pincode;
    TextView alreadyRes,register;
    AutoCompleteTextView gender,bloodgrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        name = findViewById(R.id.signup_name);
        phoneno = findViewById(R.id.signup_phoneno);
        email = findViewById(R.id.signup_email);
        adhaar = findViewById(R.id.signup_adhaar);
        pincode = findViewById(R.id.signup_pincode);

        register = (TextView) findViewById(R.id.register);
        alreadyRes = findViewById(R.id.alreadyRes);

        gender = findViewById(R.id.blood_group);
        String[] option1 = {"Select", "Male", "Female"};
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, R.layout.options, option1);
        gender.setText(arrayAdapter1.getItem(0).toString(), false); //to make default value...
        gender.setAdapter(arrayAdapter1);

        bloodgrp = findViewById(R.id.gender);
        String[] option = {"Select", "O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, R.layout.options, option);
        bloodgrp.setText(arrayAdapter2.getItem(0).toString(), false); //to make default value...
        bloodgrp.setAdapter(arrayAdapter2);

    }

    public void Homepage_activity(View view) {

        Toast toast = Toast.makeText(signup_page.this,"Registered Successfully",Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, signup_page.class);
    }
}