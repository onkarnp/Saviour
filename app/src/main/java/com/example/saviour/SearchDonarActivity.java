package com.example.saviour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.saviour.models.User;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SearchDonarActivity extends AppCompatActivity {

    FirebaseDatabase database;
    private EditText pin_code;
    AutoCompleteTextView bloodgrp;
    CardView search;
    RecyclerView recyclerView;
//    MyAdapter1 myAdapter;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donar);
    }
}