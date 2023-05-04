package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SharePreferenceClass extends AppCompatActivity {

    Button loginBTN, logoutBTN;
    TextView usernameTV, passwordTV;
    LinearLayout login_layout, dashboard_layout;
    EditText usernameEd, passwordEd;
    SharedPreferences sharePreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preference_class);

        ////SHAREDPREFERENCES////
        sharePreferences = getSharedPreferences("user", MODE_PRIVATE);
        editor = sharePreferences.edit();

        ///BUTTONS////
        loginBTN = findViewById(R.id.login);
        loginBTN =findViewById(R.id.logout);

        ///EDIT TEXT/////
        usernameEd = findViewById(R.id.usernameET);
        passwordEd = findViewById(R.id.passwordET);

        ////TEXT VIEW///
        usernameTV = findViewById(R.id.usernameTV);
        passwordTV = findViewById(R.id.passwordTV);

        ///LAYOUTS////
        login_layout = findViewById(R.id.login_layout);
        dashboard_layout = findViewById(R.id.dashboard_layout);

        ///GET ALREADY SAVED DATA
        String savedUsername = sharePreferences.getString("username","");
        String savedPassword = sharePreferences.getString("password", "");

        ////CHECKING IF DATA IS SAVED///
        if(!savedPassword.equals("") && !savedUsername.equals("")){
            ///THIS IS A SAVED USER, LETS SHOW TO THE DASHBOARD AND DISPLAY TO THE USER
            dashboard_layout.setVisibility(View.VISIBLE);

            ////HIDE THE LOGIN LAYOUT
            login_layout.setVisibility(View.GONE);

            usernameTV.setText("username: "+savedUsername);
            passwordTV.setText("password: "+savedPassword);
        }

        ///SET ACTION ON LOGIN BUTTON
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////GET INPUT FROM EDIT TEXT
                String usernameToSave = usernameEd.getText().toString();
                String passwordToSave = passwordEd.getText().toString();

                /////VALIDATION

                if (usernameToSave.trim().length() < 2){
                    usernameEd.setError("character must be greater than 2");
                    return;
                }

                if (passwordToSave.trim().length() < 2){
                    passwordEd.setError("character must be greater than 2");
                    return;
                }

                ///////SAVED TO SHAREDPERFERENCE
                editor.putString("username", usernameToSave);
                editor.putString("password", passwordToSave);
                editor.commit();

                /////ALL DONE
                //////NOW LETS BRING OUT THE DASHBOARD

                ////SET VALUES TO THE TEXT VIEWS
                usernameTV.setText("username: "+usernameToSave);
                passwordTV.setText("password: "+passwordToSave);

                login_layout.setVisibility(View.GONE);
                dashboard_layout.setVisibility(View.VISIBLE);

            }
        });

        ////? SET ACTION ON LOGOUT BUTTON

        logoutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////? WE NEED TO CLEAR THE SHARE DEPENDENCE

                editor.clear();
                editor.commit();

                ////////? ALL DONE /////
                ////? LETS SHOW THE LOGIN INTERFACE////
                dashboard_layout.setVisibility(View.GONE);
                login_layout.setVisibility(View.VISIBLE);
            }
        });
    }
}