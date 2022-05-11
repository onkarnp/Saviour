package com.example.saviour;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.saviour.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import com.google.firebase.firestore.auth.User;

public class signup_page extends AppCompatActivity {

    EditText name,phoneno,email,adhaar,pincode,password;
    TextView alreadyRes,register;
    AutoCompleteTextView gender,bloodgrp;

    private ProgressDialog loadingbar;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference ref;

    @RequiresApi(api= Build.VERSION_CODES.JELLY_BEAN_MR1)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_page);

        name = findViewById(R.id.signup_name);
        phoneno = findViewById(R.id.signup_phoneno);
        email = findViewById(R.id.signup_email);
        adhaar = findViewById(R.id.signup_adhaar);
        pincode = findViewById(R.id.signup_pincode);
        password = findViewById(R.id.signup_password);

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

        loadingbar = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            loadingbar.setMessage("Fetching Your data");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();
            String userID = mAuth.getCurrentUser().getUid();
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("allusers");
            ref.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if(task.isSuccessful()){
                        for(DataSnapshot dataSnapshot:task.getResult().getChildren()){
                            if(userID.equals(dataSnapshot.getKey())){
                                loadingbar.dismiss();
                                Toast.makeText(signup_page.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signup_page.this,HomepageActivity.class));
                                finish();
                            }
                        }
                    }
                    else{
                        loadingbar.dismiss();
                        Toast.makeText(signup_page.this,"Error Occured",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signup_page.this,signup_page.class)); ///make changes
                    }

                }
            });
        }


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = name.getText().toString();
                String mobileNo = phoneno.getText().toString();
                String email_Id = email.getText().toString();
                String adhaar_no = adhaar.getText().toString();
                String pin_code = pincode.getText().toString();
                String Password = password.getText().toString();
                String Bloodgrp = bloodgrp.getText().toString();
                String Gender = gender.getText().toString();

                if(fullName.isEmpty() || fullName.length()<5)
                {
                    showError(name, "Please enter valid name");
                }
                else if (mobileNo.length()!=10)
                {
                    showError(phoneno, "Please enter valid 10 digit number");
                }
                else if(email_Id.isEmpty() && !isEmailValid(email_Id))
                {
                    showError(email, "Please enter valid email address");
                }
                else if(pin_code.length()!=6)
                {
                    showError(pincode, "Please enter correct pin code");
                }
                else if(adhaar_no.length()!=12)
                {
                    showError(adhaar, "Please enter correct Adhaar Number");
                }
                else if(Password.length() < 8)
                {
                    showError(password, "Password size must be more than 8");
                }

                else if(Gender.isEmpty() | Gender.equals("Select"))
                {
                    Toast.makeText(signup_page.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                }
                else if(Bloodgrp.isEmpty()| Bloodgrp.equals("Select"))
                {
                    Toast.makeText(signup_page.this, "Please select your blood group", Toast.LENGTH_SHORT).show();
                }
                else{
                    createUser();
                }
            }

            public void createUser(){
                String fullName = name.getText().toString();
                String mobileNo = phoneno.getText().toString();
                String email_Id = email.getText().toString();
                String adhaar_no = adhaar.getText().toString();
                String pin_code = pincode.getText().toString();
                String Password = password.getText().toString();
                String Bloodgrp = bloodgrp.getText().toString();
                String Gender = gender.getText().toString();

                User user = new User(fullName,mobileNo,email_Id,adhaar_no,pin_code,Password,Bloodgrp,Gender);
                if (!phoneno.getText().toString().trim().isEmpty()) {
                    if ((phoneno.getText().toString().trim()).length() == 10) {


                        register.setVisibility(View.INVISIBLE);
//                        loadingBar.setTitle("Create Account");
                        loadingbar.setMessage("Signing up");
                        loadingbar.setCanceledOnTouchOutside(false);
                        loadingbar.show();


                    }
                } else {
                    loadingbar.dismiss();
                    register.setVisibility(View.VISIBLE);
                    Toast.makeText(signup_page.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                }

            }


        });

        alreadyRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        }

    public boolean isEmailValid(String email_id) {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9]+)@[_A-Za-z0-9]+(\\.[_A-Za-z0-9]+)(\\.[A-Za-z]{2,})$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        final Matcher matcher = pattern.matcher(email_id);
        return matcher.matches();
    }

    public void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();

    }


}







//    public void Homepage_activity(View view) {
//
//        Toast toast = Toast.makeText(signup_page.this,"Registered Successfully",Toast.LENGTH_SHORT);
//        toast.show();
//        Intent intent = new Intent(this, signup_page.class);
//    }







