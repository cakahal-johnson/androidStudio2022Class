package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewClass2 extends AppCompatActivity {
    ListView listview;
    EditText nameEd;
    Button submitBTN;

    ArrayList names = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_class2);

        listview = findViewById(R.id.listview);
        nameEd = findViewById(R.id.name);
        submitBTN = findViewById(R.id.submit);
        ArrayAdapter adapter = new ArrayAdapter(ListViewClass2.this, android.R.layout.simple_spinner_item, names);
        listview.setAdapter(adapter);

        submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEd.getText().toString();
                if(name.trim().length() < 2){
                    nameEd.setError("Name must be greater than 2");
                    return;

                }

                names.add(name);
                adapter.notifyDataSetChanged();
                Toast.makeText(ListViewClass2.this, "Added", Toast.LENGTH_LONG).show();
            }
        });
    }
}