package com.example.myfirstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormPractical extends AppCompatActivity {
    EditText email, username, password;

    AlertDialog.Builder alertBuilder;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_practical);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = findViewById(R.id.submit);
        alertBuilder = new AlertDialog.Builder(FormPractical.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameText = username.getText().toString();
                String passwordText = password.getText().toString();
                String emailText = email.getText().toString();


                if(usernameText.trim().isEmpty()){
                    username.setError("Please fill filed");
                    return;
                }

                if(passwordText.trim().length() < 5 ){
                    password.setError("Password must be 5 xters and above");
                    return;
                }

                if(!emailText.trim().contains("@") && emailText.trim().length() < 3){
                    email.setError("Invalid email");
                    return;
                }

                alertBuilder.setTitle("Success");
                alertBuilder.setMessage("You have successfully registered");

                alertBuilder.setPositiveButton("Go To Dashboard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Bundle bundle = new Bundle();
                        bundle.putString("username", usernameText);
                        bundle.putString("password", passwordText);
                        bundle.putString("email", emailText);


                        Intent intent = new Intent(FormPractical.this, Dashboard.class);
                        intent.putExtras(bundle); /// using Array
                        startActivity(intent);



                    }
                });

                alertBuilder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                AlertDialog alertDialog = alertBuilder.create();
                alertDialog.show();
            }
        });
    }
}