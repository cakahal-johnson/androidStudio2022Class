package com.example.myfirstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SqliteActivity extends AppCompatActivity {
    FloatingActionButton fab;
    DBHelper dbHelper;
    LayoutInflater inflater;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        fab = findViewById(R.id.fab);
        dbHelper = new DBHelper(SqliteActivity.this);
        inflater = LayoutInflater.from(this);
        container = findViewById(R.id.container);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newContactDialog();
            }
        });

        fetChUsers();
    }

    ///EDIT SECTION
    public void showUpdataDialog(String name, String phone, int id ){
        AlertDialog.Builder alerBuilder = new AlertDialog.Builder(SqliteActivity.this);
        //alerBuilder.setTitle("New Record");


        LayoutInflater inflater = SqliteActivity.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.form_layout,null);
        //alertDialog.setCancelView(dialogView);
        alerBuilder.setView(dialogView);


        AlertDialog alertDialog = alerBuilder.create();
        alerBuilder.setCancelable(true);
        final AlertDialog dialog = alerBuilder.show();

        ImageView cancel_button = dialogView.findViewById(R.id.cancel_button);
        EditText phoneEd = dialogView.findViewById(R.id.phone);
        EditText nameEd = dialogView.findViewById(R.id.name);
        Button submitBtn = dialogView.findViewById(R.id.submit);
        nameEd.setText(name);
        phoneEd.setText(phone);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneTxt = phoneEd.getText().toString();
                String nameTxt = nameEd.getText().toString();

                if(phoneTxt.trim().length() < 11){
                    phoneEd.setError("Invalid phone number");
                    return;
                }

                if(nameTxt.trim().length() < 3){
                    nameEd.setError("Invalid name");
                    return;
                }

                ///////DATABASE SECTION//////////////
//
                boolean hasSaved = dbHelper.upDate(nameTxt, phoneTxt, String.valueOf(id));
                if (hasSaved){
                    Toast.makeText(SqliteActivity.this, "Successfully Saved", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
////                    alertDialog.cancel();
//                    finish();
                    Log.i("success", "1");
                }else  {
                    Toast.makeText(SqliteActivity.this, "Failed to save", Toast.LENGTH_SHORT).show();
                    Log.i("success", "2");

                }
                fetChUsers();

            }
        });


    }
    ////EDIT SECTION END HERE

    public void fetChUsers(){
        Cursor cursor = dbHelper.fetchData();
        container.removeAllViews();

        while (cursor.moveToNext()){
            View view = inflater.inflate(R.layout.single_contact,container, false);
            TextView nameTv = view.findViewById(R.id.name);
            TextView phoneTv = view.findViewById(R.id.phone);
            TextView deleteBtm = view.findViewById(R.id.delelete);

            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String nameTxt = cursor.getString(cursor.getColumnIndex("name"));
            @SuppressLint("Range") String phoneTxt = cursor.getString(cursor.getColumnIndex("phone_number"));
            nameTv.setText(nameTxt);
            phoneTv.setText(phoneTxt);

            deleteBtm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    dbHelper.deleteContact(String.valueOf(id));
                    container.removeView(view);

                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showUpdataDialog(nameTxt, phoneTxt, id);
                }
            });





            container.addView(view);

        }
    }

    public void newContactDialog(){
        AlertDialog.Builder alerBuilder = new AlertDialog.Builder(SqliteActivity.this);
        //alerBuilder.setTitle("New Record");


        LayoutInflater inflater = SqliteActivity.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.form_layout,null);
        //alertDialog.setCancelView(dialogView);
        alerBuilder.setView(dialogView);


        AlertDialog alertDialog = alerBuilder.create();
        alerBuilder.setCancelable(true);
        final AlertDialog dialog = alerBuilder.show();

        ImageView cancel_button = dialogView.findViewById(R.id.cancel_button);
        EditText phoneEd = dialogView.findViewById(R.id.phone);
        EditText nameEd = dialogView.findViewById(R.id.name);
        Button submitBtn = dialogView.findViewById(R.id.submit);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneTxt = phoneEd.getText().toString();
                String nameTxt = nameEd.getText().toString();

                if(phoneTxt.trim().length() < 11){
                    phoneEd.setError("Invalid phone number");
                    return;
                }

                if(nameTxt.trim().length() < 3){
                    nameEd.setError("Invalid name");
                    return;
                }

                ///////DATABASE SECTION//////////////
//
                boolean hasSaved = dbHelper.saveContact(nameTxt, phoneTxt);
                if (hasSaved){
                    Toast.makeText(SqliteActivity.this, "Successfully Saved", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
////                    alertDialog.cancel();
//                    finish();
                    Log.i("success", "1");
                }else  {
                    Toast.makeText(SqliteActivity.this, "Failed to save", Toast.LENGTH_SHORT).show();
                    Log.i("success", "2");

                }
                fetChUsers();


            }
        });


//        alerBuilder.show();


    }
}