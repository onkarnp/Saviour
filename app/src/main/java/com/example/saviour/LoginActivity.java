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

import com.example.saviour.HomepageActivity;
import com.example.saviour.R;

public class LoginActivity extends AppCompatActivity {


    EditText username, password;
    ImageView logo;
    TextView forgetPassword;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        forgetPassword = findViewById(R.id.login_forget_password);
        logo = findViewById(R.id.login_logo);
        loginBtn = findViewById(R.id.login_button);

    }

    public void Homepage_activity(View view) {
        Toast toast = Toast.makeText(this, "Logged in Successfully",Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);

    }
}