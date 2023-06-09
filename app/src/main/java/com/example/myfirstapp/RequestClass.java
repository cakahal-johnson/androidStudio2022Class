package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class RequestClass extends AppCompatActivity {
    ProgressDialog pd;
    UserAdapterApi userAdapter;
    ArrayList<JSONObject> users;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_class);
        //SET THE URL WHERE CAN GET THE API
        String url = "https://reqres.in/api/users";

        ///TO PUR THE DATA TO XML SINGLE USER
        users = new ArrayList<>();

        pd = new ProgressDialog(this);
        userAdapter = new UserAdapterApi(this,users);
        pd.show();
        listView = findViewById(R.id.listview);
        listView.setAdapter(userAdapter);


        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("response",response);
                pd.dismiss();

                try {

                    JSONObject object = new JSONObject(response);
                    JSONArray data = object.getJSONArray("data");
                    Log.i("Debug", "debug");
                    for(int i = 0; i < data.length(); i++){
                        JSONObject user = data.getJSONObject(i);
                        users.add(user);
                    }

                    Log.i("Debug2", "debug00000");
                    userAdapter.notifyDataSetChanged();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Request Error", String.valueOf(error));
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}