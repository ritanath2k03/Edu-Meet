package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class College_dashboard extends AppCompatActivity {
    EditText name,id,dob;
    Button Enter;
    TextView college_header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_dashboard);
        Enter=findViewById(R.id.Enter);
        id=findViewById(R.id.id);
        dob=findViewById(R.id.dob);
        name=findViewById(R.id.name);
        college_header=findViewById(R.id.college_header);



        String college_name=getIntent().getStringExtra("college_name");
        college_header.setText("Register A Student in "+college_name+" college");


        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                HashMap<String,Object> map=new HashMap<>();
//               map.put("Institute",college.getText().toString());
                map.put("Name",name.getText().toString());
                map.put("Id",id.getText().toString());
                map.put("DOB",dob.getText().toString());
                FirebaseDatabase.getInstance().getReference().child(college_name).child("Student Name").child(name.getText().toString())
                        .setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.i("logic", "onComplete: ");
                                Toast.makeText(College_dashboard.this, "Data has enrolled", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("logic", "onFailure: "+e.toString());
                        Toast.makeText(College_dashboard.this, "Data doesn't enrolled", Toast.LENGTH_SHORT).show();
                    }

                });

            }
        });



    }

}