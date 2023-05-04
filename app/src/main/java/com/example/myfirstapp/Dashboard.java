package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    TextView emailField, passwordField, usernameField;
    Bundle bundle;
    Button userviewBTN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        userviewBTN = findViewById(R.id.userview);
        userviewBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,ListviewClass.class);
                startActivity(intent);
            }
        });

        emailField = findViewById(R.id.email);
        passwordField = findViewById(R.id.username);
        usernameField = findViewById(R.id.password);

        bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        String email = bundle.getString("email");


        emailField.setText(email);
        passwordField.setText(password);
        usernameField.setText(username);





    }
}