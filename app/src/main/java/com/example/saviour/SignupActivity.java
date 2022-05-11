package com.example.saviour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText name,phoneno,email,adhaar,address,pincode;
    ImageView logo;
    Button signup;
    TextView alreadyRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.signup_name);
        phoneno = findViewById(R.id.signup_phoneno);
        email = findViewById(R.id.signup_email);
        adhaar = findViewById(R.id.signup_adhaar);
        address = findViewById(R.id.signup_address);
        pincode = findViewById(R.id.signup_pincode);

        signup = findViewById(R.id.registerBtn);
        alreadyRes = findViewById(R.id.alreadyRes);
        logo = findViewById(R.id.imageButton);

    }

    public void Homepage_activity(View view) {

        Toast toast = Toast.makeText(SignupActivity.this,"Registered Successfully",Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, SignupActivity.class);
    }
}