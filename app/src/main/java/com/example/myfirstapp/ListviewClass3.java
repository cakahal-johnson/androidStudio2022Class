package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListviewClass3 extends AppCompatActivity {
    ArrayList contacts = new ArrayList();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_class3);

        String[] contact1 = {"Obi", "+23456826655423"};
        String[] contact2 = {"Mark", "+23456826655423"};
        String[] contact3 = {"Akh", "+2347062113521"};

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        listView = findViewById(R.id.listview);

        UserAdapter userAdapter = new UserAdapter(ListviewClass3.this,contacts);
        listView.setAdapter(userAdapter);



    }
}