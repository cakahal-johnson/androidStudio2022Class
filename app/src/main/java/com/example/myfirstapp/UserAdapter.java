package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Locale;

public class UserAdapter extends ArrayAdapter {

    ArrayList contacts;
    Context context;


    public UserAdapter(@NonNull Context context, ArrayList contacts) {
        super(context, 0);
        this.contacts = contacts;
        this.context = context;
    }
    ///crl o to bring the over ride
    @Override
    public int getCount() {
        return contacts.size();
    }

    ///crl o to bring out over ride

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.single_user,parent,false);
        TextView initial_tv = convertView.findViewById(R.id.initial);
        TextView name_tv = convertView.findViewById(R.id.name);
        TextView phone_number_tv = convertView.findViewById(R.id.phone);

        String[] details = (String[]) contacts.get(position);
        String name = details[0];
        String phone = details[1];
        String initial = name.trim().substring(0,1);

        initial_tv.setText(initial.toUpperCase());
        name_tv.setText(name);
        phone_number_tv.setText(phone);

        return convertView;
    }
}
