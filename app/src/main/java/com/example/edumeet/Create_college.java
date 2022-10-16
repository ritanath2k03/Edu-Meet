package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Create_college extends AppCompatActivity {
    EditText college_name,college_id,college_password;
    Button college_enter,create_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_college);
        college_enter=findViewById(R.id.college_enter);
        college_name=findViewById(R.id.college_name);
        college_id=findViewById(R.id.college_id);
        college_password=findViewById(R.id.college_password);
        create_btn=findViewById(R.id.createBtn);
        college_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String collegename=college_name.getText().toString();
                Intent intent=new Intent(Create_college.this,College_dashboard_main.class);
                intent.putExtra("keyname",collegename);

                String collegename1=college_name.getText().toString();
                Intent intent1=new Intent(Create_college.this,College_dashboard.class);
                intent1.putExtra("college_name",collegename1);

                HashMap<String,Object> map=new HashMap<>();
                map.put("Id",college_id.getText().toString());
                map.put("Pass",college_password.getText().toString());
                FirebaseDatabase.getInstance().getReference().child(collegename).child("Security")
                        .setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.i("logi", "onComplete: ");
                                startActivity(intent);
                                Toast.makeText(Create_college.this, "Data has enrolled", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("logi", "onComplete: ");
                        Toast.makeText(Create_college.this, "Data doesnot enrolled", Toast.LENGTH_SHORT).show();
                    }
                });

            }


        });
    }
}