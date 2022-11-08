package com.example.walmart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void ShowAddPopup(View view) {
        Intent intent= new Intent(Home.this,AddItemActivity.class);
        startActivity(intent);
    }

    public void ShowAddCustomer(View view) {
        Intent intent= new Intent(Home.this,Add_Customer_Activity.class);
        startActivity(intent);
    }

    public void edit_item(View view) {
        Intent intent= new Intent(Home.this,Edit_Item_Activity.class);
        startActivity(intent);
    }

    public void edit_customer(View view) {
        Intent intent= new Intent(Home.this,Edit_Customer_Activity.class);
        startActivity(intent);
    }

    public void View_Items(View view) {
        Intent intent= new Intent(Home.this,view_items.class);
        startActivity(intent);

    }

    public void View_Customer(View view) {
        Intent intent= new Intent(Home.this,view_customer.class);
        startActivity(intent);
    }
}