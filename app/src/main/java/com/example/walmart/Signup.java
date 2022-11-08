package com.example.walmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText email_et, name_et, password_et, conformPassword_et;
    Button btn_signup;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email_et = findViewById(R.id.et_email);
        name_et = findViewById(R.id.et_name);
        password_et = findViewById(R.id.et_password);
        conformPassword_et = findViewById(R.id.et_confirmPassword);
        btn_signup = findViewById(R.id.btn_reg);
        firebaseAuth = FirebaseAuth.getInstance();

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_et.getText().toString().trim();
                String password = password_et.getText().toString().trim();
                String conformPassword = conformPassword_et.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Signup.this, "Please Provide Email ID", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup.this, "Please Provide Password ID", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(conformPassword)){
                    Toast.makeText(Signup.this, "Please Provide Conform Password ID", Toast.LENGTH_SHORT).show();
                }
                if (password.length()<6){
                    Toast.makeText(Signup.this, "Password Too Short", Toast.LENGTH_SHORT).show();
                }
                if (conformPassword.equals(password)){
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Signup.this, "Signup Complete", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }else {
                                        Toast.makeText(Signup.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                    );
                }
            }
        });

    }

    public void back_arrow_login(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void Login_Now(View view) {
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
}