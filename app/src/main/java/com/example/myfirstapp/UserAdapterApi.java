package com.example.myfirstapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;

public class UserAdapterApi extends ArrayAdapter {
//    alt+enta
    ArrayList<JSONObject> users;
    Context context;


    public UserAdapterApi(@NonNull Context context, ArrayList users ) {
        super(context, 0);
        this.users = users;
        this.context = context;
    }
// crl+o
    @Override
    public int getCount() {
        return users.size();
    }

//crl + o

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.single_user2,parent,false);

        TextView name_TV = convertView.findViewById(R.id.name);
        TextView email_Tv = convertView.findViewById(R.id.email);
        ImageView imageView = convertView.findViewById(R.id.image);

        try{

            JSONObject userDetail = users.get(position);

            name_TV.setText(userDetail.getString("first_name"));
            email_Tv.setText(userDetail.getString("email"));
            Log.i("user", String.valueOf(userDetail));

            Picasso.with(context).load(userDetail.getString("avatar")).into(imageView);


        }catch (Exception e){
            e.printStackTrace();
        }

        return convertView;
    }
}
