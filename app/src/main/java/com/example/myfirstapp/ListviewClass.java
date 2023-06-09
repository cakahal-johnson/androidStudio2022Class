package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListviewClass extends AppCompatActivity {
    LinearLayout container;
    LayoutInflater layoutInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_class);
        container = findViewById(R.id.container);
        layoutInflater = LayoutInflater.from(this);

        String[][] contacts = {{"Amos", "025488625444"}, {"AKH", "2562887888"}, {"Mark", "0214525644855"}};

        for(int i = 0; i < contacts.length; i++){
            String[] single_person = contacts[i];
            String name = contacts[i][0];
            String phone_number = contacts[i][1];
//            log.i("details", String.valueOf(single_person));

            String initial = name.trim().substring(0,1);

            View view = layoutInflater.inflate(R.layout.single_user,container,false);
            TextView name_textview = view.findViewById(R.id.name);
            TextView phone_textview = view.findViewById(R.id.phone);
            TextView initial_textview = view.findViewById(R.id.initial);
            TextView delete_textview = view.findViewById(R.id.delelete);


            name_textview.setText(name);
            phone_textview.setText(phone_number);
            initial_textview.setText(initial);

            container.addView(view);

            delete_textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    container.removeView(view);

                }
            });

        }
    }
}