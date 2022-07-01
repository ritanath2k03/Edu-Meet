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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup_page extends AppCompatActivity {
    EditText email,password,name;
    Button loginBtn,createBtn;
    FirebaseAuth auth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        auth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(Signup_page.this);
       progressDialog.setTitle("Just a moment....");
        progressDialog.setMessage("We are Creating your Account");
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        loginBtn=findViewById(R.id.loginBtn);
        createBtn=findViewById(R.id.createBtn);
        name=findViewById(R.id.name);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                String emailBox,pass,nameBox;
                emailBox=email.getText().toString();
                pass=password.getText().toString();
                nameBox=name.getText().toString();

                auth.createUserWithEmailAndPassword(emailBox,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                   if(task.isSuccessful())
                   {
                       Toast.makeText(Signup_page.this, "Account has Created", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(Signup_page.this,Decision_page.class));
                   }
                   else{
                       Toast.makeText(Signup_page.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                   }
                    }
                });
            }
        });
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup_page.this,Login_page.class));
            }
        });
    }
}