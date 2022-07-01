package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_page extends AppCompatActivity {
EditText email,password;
Button loginBtn,createBtn;
FirebaseAuth auth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        progressDialog=new ProgressDialog(Login_page.this);
        progressDialog.setTitle("Please Wait....");
        progressDialog.setMessage("Almost There");
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        loginBtn=findViewById(R.id.loginBtn);
        createBtn=findViewById(R.id.createBtn);
        auth=FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                String emailbox,passwordbox;
                emailbox=email.getText().toString();
                passwordbox=password.getText().toString();
                auth.signInWithEmailAndPassword(emailbox,passwordbox).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login_page.this, "Logged in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login_page.this, Decision_page.class));
                        }
                        else
                        {
                            Toast.makeText(Login_page.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(Login_page.this,Signup_page.class));
            }
        });
    }
}