package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

class ContactsAdapter extends ArrayAdapter {

    ArrayList<Map> contacts;
    Context context;


    public ContactsAdapter(@NonNull Context context, ArrayList contacts) {
        super(context, 0);
        this.contacts = contacts;
        this.context = context;

    }

    @Override
    public int getCount() {
        return contacts.size();
    }
    @NonNull


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.single_contact, parent, false);

        TextView name_textview = convertView.findViewById(R.id.name);
        TextView phone_textview = convertView.findViewById(R.id.phone);
        TextView initial_textview = convertView.findViewById(R.id.initial);
        TextView delete = convertView.findViewById(R.id.delelete);
        Map contact = contacts.get(position);

        try{


            name_textview.setText(contact.get("name").toString().trim());
            phone_textview.setText(contact.get("phone").toString());
            initial_textview.setText(contact.get("name").toString().trim().substring(0,1));
        }catch (Exception e){
            e.printStackTrace();
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                firestore.collection("contacts").document(contact.get("id").toString()).delete();
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
