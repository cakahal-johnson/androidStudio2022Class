package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button introBTN, foodAppBTN, formAppBTN, formPptBtn, D3BTN, viewuserBTN, viewuserBTN2,
    WebviewBTN, RequestBTN, IntenBTN, DrawerBTN, bottom_navBTN, sqliteBTN, firebaseBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introBTN = findViewById(R.id.Introduction);
        introBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,Introduction.class);
                startActivity(intent);
            }
        });

        foodAppBTN = findViewById(R.id.blog);
        foodAppBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FoodApp.class);
                startActivity(intent);
            }
        });

        formAppBTN = findViewById(R.id.FormApp);
        formAppBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FormActivity.class);
                startActivity(intent);
            }
        });

        formPptBtn = findViewById(R.id.FormApp2);
        formPptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FormPractical.class);
                startActivity(intent);
            }
        });

        D3BTN = findViewById(R.id.D3);
        D3BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, design3.class);
                startActivity(intent);
            }
        });

        viewuserBTN = findViewById(R.id.viewuser);
        viewuserBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListviewClass.class);
                startActivity(intent);
            }
        });

        viewuserBTN2 = findViewById(R.id.viewuser2);
        viewuserBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewClass2.class);
                startActivity(intent);
            }
        });

        WebviewBTN = findViewById(R.id.Webview);
        WebviewBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewClass.class);
                startActivity(intent);
            }
        });

        RequestBTN = findViewById(R.id.requestApi);
        RequestBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RequestClass.class);
                startActivity(intent);
            }
        });

        IntenBTN = findViewById(R.id.inten);
        IntenBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntenClass.class);
                startActivity(intent);
            }

        });

        DrawerBTN = findViewById(R.id.drawer);
        DrawerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrawerClass.class);
                startActivity(intent);
            }
        });

        bottom_navBTN = findViewById(R.id.bottom_nav);
        bottom_navBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ButtonNav.class);
                startActivity(intent);
            }
        });

        sqliteBTN = findViewById(R.id.sqlite);
        sqliteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SqliteActivity.class);
                startActivity(intent);
            }
        });

        firebaseBTN = findViewById(R.id.firebase);
        firebaseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FireBaseActivity.class);
                        startActivity(intent);
            }
        });

    }

}