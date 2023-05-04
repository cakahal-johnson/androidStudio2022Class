package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FireBaseActivity extends AppCompatActivity {
    EditText nameEd, phoneEd;
    Button submit;
    FirebaseFirestore db;
    ArrayList<Map> contacts;
    ListView listView;
    ContactsAdapter contactsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);

         nameEd = findViewById(R.id.name);
        phoneEd = findViewById(R.id.phone);
        submit = findViewById(R.id.submit);
        listView = findViewById(R.id.listview);
        contacts = new ArrayList<>();

        contactsAdapter = new ContactsAdapter(this, contacts);
        listView.setAdapter(contactsAdapter);


      db = FirebaseFirestore.getInstance();

        db.collection("contacts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                Log.d("contact_error", document.getId() + " => " + document.getData());
                                Map contact = document.getData();
                                contact.put("id", document.getId());
                                contacts.add(contact);

                            }
                            contactsAdapter.notifyDataSetChanged();
                        }else{
                            Log.w("contact_error", "Error getting documents ", task.getException());

                        }
                    }
                });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postToFirebase();

            }
        });
    }

    void postToFirebase(){
        Map<String, Object> contact = new HashMap<>();

        String nameTxt = nameEd.getText().toString();
        String phoneTxt = phoneEd.getText().toString();
        contact.put("name", nameTxt);
        contact.put("phone", phoneTxt);

        db.collection("contacts").add(contact).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(FireBaseActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                Log.i("ggg", String.valueOf(contact));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FireBaseActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                Log.i("noooooo", String.valueOf(contact));
            }
        });
        Log.i("ggg",String.valueOf(contact));
        contactsAdapter.notifyDataSetChanged();
    }
}