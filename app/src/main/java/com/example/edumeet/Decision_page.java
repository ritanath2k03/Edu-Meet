package com.example.edumeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Decision_page extends AppCompatActivity {
Button Teacher,Student,College;
ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision_page);


        Student=findViewById(R.id.student);
        Teacher=findViewById(R.id.Teacher);
        College=findViewById(R.id.College);
button=findViewById(R.id.logout);
        College.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Decision_page.this,College_verification.class));

            }
        });
         Student.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(Decision_page.this,Student_verification.class));
             }
         });
         Teacher.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(Decision_page.this,Teacher_verificatoin.class));
             }
         });
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 FirebaseAuth.getInstance().signOut();
                 startActivity(new Intent(Decision_page.this,Login_page.class));
             }
         });
    }
}