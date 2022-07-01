package com.example.edumeet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Attendance_popup extends AppCompatActivity {
TextView present,classes,absent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_popup);
        present=findViewById(R.id.present);
        classes=findViewById(R.id.classes);
        absent=findViewById(R.id.absent);
    }
}