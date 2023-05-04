package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntenClass extends AppCompatActivity {

    Button launcher, smsBTN, dailerBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inten_class);

        launcher = findViewById(R.id.launch);
        smsBTN = findViewById(R.id.sms);
        dailerBTN = findViewById(R.id.dailer);

        dailerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:09062119521"));
                startActivity(intent);
            }
        });

        launcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(intent);
            }
        });

        smsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setType("vnd.android-dir/mms-sms");
//                intent.putExtra("address", "07062119521");
                intent.putExtra("sms_body", "Hello world");
                intent.setData(Uri.parse("sms:07062119521"));

                startActivity(intent);
            }
        });
    }
}