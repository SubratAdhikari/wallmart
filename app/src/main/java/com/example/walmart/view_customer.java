package com.example.walmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class view_customer extends AppCompatActivity {

    TextView tv_name, tv_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer);

        tv_name = findViewById(R.id.customer_name);
        tv_add = findViewById(R.id.customer_add);

        String ct_name = getIntent().getStringExtra("Customer_Name");
        String ct_Add = getIntent().getStringExtra("Customer_Add");
        tv_name.setText(ct_name);
        tv_add.setText(ct_Add);

    }
}