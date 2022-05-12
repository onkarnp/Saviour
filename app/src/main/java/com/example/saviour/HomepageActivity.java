package com.example.saviour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class HomepageActivity extends AppCompatActivity {

    CardView update_profile_card,request_blood_card,search_donor_card,find_nearby_card,common_queries_card,log_out_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        update_profile_card = (CardView) findViewById(R.id.update_profile_card);
        update_profile_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UpdateProfile.class);
                startActivity(intent);
            }
        });

        request_blood_card = (CardView) findViewById(R.id.request_blood_card);
        request_blood_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RequestBloodActivity.class);
                startActivity(intent);
            }
        });

        search_donor_card = (CardView) findViewById(R.id.search_donor_card);
        search_donor_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchDonarActivity.class);
                startActivity(intent);
            }
        });

        find_nearby_card = (CardView) findViewById(R.id.find_nearby_card);
        find_nearby_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Find_nearby_activity.class);
                startActivity(intent);
            }
        });

        common_queries_card = (CardView) findViewById(R.id.common_queries_card);
        common_queries_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), common_queries.class);
                startActivity(intent);
            }
        });

        log_out_card = (CardView) findViewById(R.id.log_out_card);
        log_out_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}