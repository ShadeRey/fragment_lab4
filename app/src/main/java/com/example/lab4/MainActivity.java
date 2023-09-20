package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment, new BlankFragment(), "blank_Fragment")
                .addToBackStack("blank_fragment_transaction")
                .commit();
    }
}