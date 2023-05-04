package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    Button submit;
    EditText username, password;
    Spinner spinner;
    CheckBox eating, dancing, football;
    RadioGroup radio_button_group;
    SeekBar seekBar;
    TextView range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form);
        ////TO CONSOLE LOG/////
        Log.i("myId",String.valueOf(R.id.male)); ////THEN FROM THE LOGCAT BELOW TOOLBAR SELECT INFO AS I
        ////BUTTON////////////
        submit = findViewById(R.id.submit);
        /////////EDIT TEXT///////////////////
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        spinner = findViewById(R.id.spinner);
        /////SPINNER SETTING/////
        eating = findViewById(R.id.eating);
        dancing = findViewById(R.id.dancing);
        football = findViewById(R.id.football);

        //////////RADIO GROUP//////////////
        radio_button_group = findViewById(R.id.radio_button);

        ////SEEKBAR//////
        seekBar = findViewById(R.id.seekbar);
        range = findViewById(R.id.range);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                range.setText(String.valueOf(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //////////RADIO GROUP/////
        radio_button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if(id == R.id.male){
                    Toast.makeText(getApplicationContext(), "You are male",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "You are female",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        /////CHECKBOX//////
        football.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Toast.makeText(getApplicationContext(), "You checked football",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "You checked football",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        dancing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Toast.makeText(getApplicationContext(), "You checked dancing",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "You checked dancing",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        eating.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Toast.makeText(getApplicationContext(), "You checked eating",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "You checked eating",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        ///////SPINNER OPTION////////
        String[] options = {"OND", "HND", "DEGREE", "MASTERS", "PHD"};
        ArrayAdapter adapter = new ArrayAdapter(FormActivity.this,
                android.R.layout.simple_spinner_item,options);
        spinner.setAdapter(adapter);


        ////////TEXT SECTION//////
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameTxt = username.getText().toString();
                String passwordTxt = password.getText().toString();
                if (usernameTxt.trim().length() < 3){
                    Toast.makeText(FormActivity.this,
                            "Username must be greater than 3 character", Toast.LENGTH_LONG).show();
                }else if (passwordTxt.trim().length() < 6){
                    Toast.makeText(FormActivity.this,
                            "Password must be greater than 3 character", Toast.LENGTH_LONG).show();
                }else{
                    String result = "Success!!!! \n";
                    result += "Username "+usernameTxt+" \n";
                    result += "password "+passwordTxt+" \n";

                    Toast.makeText(FormActivity.this, result, Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}