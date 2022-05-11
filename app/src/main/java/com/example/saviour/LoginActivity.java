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


    EditText user_mail, login_password;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user_mail = (EditText) findViewById(R.id.user_mail);
        login_password = (EditText) findViewById(R.id.login_password);
    }

    public void Homepage_activity(View view) {
        Toast toast = Toast.makeText(this, "Logged in Successfully",Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
        startActivity(intent);

    }
    public void register(View view){
        Toast toast = Toast.makeText(this, "",Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(LoginActivity.this, signup_page.class);
        startActivity(intent);


    }
}