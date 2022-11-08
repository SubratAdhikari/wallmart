package com.example.walmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    EditText forgot_email;
    Button forgot_btn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgot_email = findViewById(R.id.et_email);
        forgot_btn = findViewById(R.id.btn_forgot);
        firebaseAuth = FirebaseAuth.getInstance();

        forgot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetEmail();
            }
        });

    }

    private void GetEmail() {
        String email = forgot_email.getText().toString().trim();
        if (email.isEmpty()){
            forgot_email.setError("Email is Required");
            forgot_email.requestFocus();
        }
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ForgotPassword.this, "Check Email", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ForgotPassword.this, "Something error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void back_arrow_login(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}