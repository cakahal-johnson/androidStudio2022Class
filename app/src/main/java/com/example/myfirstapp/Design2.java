package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Design2 extends AppCompatActivity {
    Button foodBTN, foodBTN2, foodBTN3, foodBTN4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design2);

        foodBTN = findViewById(R.id.foodIMG);
        foodBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Design2.this, design3.class);
                startActivity(intent);
            }
        });

        foodBTN2 = findViewById(R.id.foodIMG2);
        foodBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Design2.this, design3.class);
                startActivity(intent);
            }
        });

        foodBTN3 = findViewById(R.id.foodIMG3);
        foodBTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Design2.this, design3.class);
                startActivity(intent);
            }
        });

        foodBTN4 = findViewById(R.id.foodIMG4);
        foodBTN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Design2.this, design3.class);
                startActivity(intent);
            }
        });

    }


}