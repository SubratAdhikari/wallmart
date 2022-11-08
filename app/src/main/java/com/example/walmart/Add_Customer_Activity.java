package com.example.walmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Add_Customer_Activity extends AppCompatActivity {

    EditText c_name,c_add;
    Button  add_customer;
    ImageView add_Image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        c_name = findViewById(R.id.et_customer_name);
        c_add =findViewById(R.id.et_customer_add);
        add_customer = findViewById(R.id.add_customer);
        add_Image = findViewById(R.id.add_Image);


        add_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CustomerName = c_name.getText().toString().trim();
                String CustomerAdd = c_add.getText().toString().trim();

                Intent intent = new Intent(Add_Customer_Activity.this,view_customer.class);
                intent.putExtra("Customer_Name", CustomerName);
                intent.putExtra("Customer_Add", CustomerAdd);
                startActivity(intent);
                finish();
            }
        });

    }
}