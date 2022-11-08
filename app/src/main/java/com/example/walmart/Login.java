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

public class Login extends AppCompatActivity {
    EditText email_edit, password_edit;
    Button login_btn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email_edit = findViewById(R.id.et_email);
        password_edit =findViewById(R.id.et_password);
        login_btn = findViewById(R.id.btn_login);
        firebaseAuth = FirebaseAuth.getInstance();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_edit.getText().toString().trim();
                String password = password_edit.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if  (task.isSuccessful()){
                                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(Login.this, "Login Complete", Toast.LENGTH_SHORT).show();
                                    finish();
                                }else {
                                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                );
            }
        });
    }

    public void back_arrow_login(View view) {
        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void Forgot_Password(View view) {
        Intent intent=new Intent(getApplicationContext(),ForgotPassword.class);
        startActivity(intent);
    }

    public void register_now(View view) {
        Intent intent=new Intent(getApplicationContext(),Signup.class);
        startActivity(intent);
    }
}