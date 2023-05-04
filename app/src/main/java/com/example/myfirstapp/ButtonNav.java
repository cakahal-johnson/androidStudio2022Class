package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class ButtonNav extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_nav);

        frameLayout = findViewById(R.id.frame_layout);
        navigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Home_Fragment()).commit();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new Home_Fragment();


                if (item.getItemId() == R.id.home){
                    fragment = new Home_Fragment();
                    item.setChecked(true);

                }else if (item.getItemId() == R.id.list){
                    fragment = new List_Fragment();
                    item.setChecked(true);

                }else if (item.getItemId() == R.id.group){
                    fragment = new Group_Fragment();
                    item.setChecked(true);
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

                return false;
            }
        });
}
}