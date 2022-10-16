package com.example.edumeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class College_dashboard_main extends AppCompatActivity {
TextView college_header1;
Button register_a_student,register_a_teacher,registered_student,registered_teacher,college_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_dashboard_main);
        college_header1=findViewById(R.id.college_header1);
        register_a_student=findViewById(R.id.register_a_student);
        register_a_teacher=findViewById(R.id.register_a_teacher);
        registered_student=findViewById(R.id.registered_student);
        registered_teacher=findViewById(R.id.registered_teacher);
        college_list=findViewById(R.id.college_name);
        String college_name=getIntent().getStringExtra("keyname");
        college_header1.setText("Welcome to "+college_name+" college");

        college_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(College_dashboard_main.this,College_List.class);
                intent.putExtra("college_name",college_name);
                startActivity(new Intent(intent));
               // startActivity(new Intent(College_dashboard_main.this,College_List.class));
            }
        });
        register_a_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(College_dashboard_main.this,College_dashboard.class);
                intent.putExtra("college_name",college_name);
                startActivity(new Intent(intent));
            }
        });
        registered_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(College_dashboard_main.this,Student_list.class);
                intent.putExtra("college_name",college_name);
                startActivity(new Intent(intent));
            }
        });
        register_a_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(College_dashboard_main.this,Teacher_registration.class);
                intent.putExtra("college_name",college_name);
                startActivity(new Intent(intent));
            }
        });
        registered_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(College_dashboard_main.this,Registered_teacher_name.class);
                intent.putExtra("college_name",college_name);
                startActivity(new Intent(intent));
            }
        });
    }
}