package com.example.registrationassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.MailTo;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    EditText name,birth_date,email;
    Button button;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= findViewById(R.id.name);
        email = findViewById(R.id.email);
        birth_date = findViewById(R.id.birth_date);
        button = findViewById(R.id.button);
        db = new DBHandler(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String birthdate1 = birth_date.getText().toString();
                String email1 = email.getText().toString();
                        Intent intent = new Intent(MainActivity.this,Dashboard.class );
                        intent.putExtra("keyname",name1);
                        intent.putExtra("keybirthdate",birthdate1);
                        intent.putExtra("keyemail",email1);
                        startActivity(intent);



            }
        });
    }
}