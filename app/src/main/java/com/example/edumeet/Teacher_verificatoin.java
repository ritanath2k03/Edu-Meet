package com.example.edumeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Teacher_verificatoin extends AppCompatActivity {
EditText name,college,id,pass;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_verificatoin);
        college=findViewById(R.id.reg_collegeBox);
        name=findViewById(R.id.reg_name);
        id=findViewById(R.id.reg_idBox);
        pass=findViewById(R.id.reg_passwordBox);
        submit=findViewById(R.id.reg_submit);

     submit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String teacher_name=name.getText().toString();
             Intent intent2=new Intent(Teacher_verificatoin.this,Teacher_dashboard.class);
             intent2.putExtra("teacher_name",teacher_name);
             startActivity(new Intent(intent2));
         }
     });

    }
}