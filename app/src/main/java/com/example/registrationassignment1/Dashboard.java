package com.example.registrationassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    TextView name,birth_date,email;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        name= findViewById(R.id.text_name);
        birth_date = findViewById(R.id.text_date);
        email=findViewById(R.id.text_email);
        String uname = getIntent().getStringExtra("keyname");
        String ubirthdate = getIntent().getStringExtra("keybirthdate");
        String uemail= getIntent().getStringExtra("keyemail");
        name.setText(uname);
        birth_date.setText(ubirthdate);
        email.setText(uemail);

    }
}