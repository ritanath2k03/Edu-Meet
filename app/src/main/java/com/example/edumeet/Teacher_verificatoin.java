package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Teacher_verificatoin extends AppCompatActivity {
EditText name,college,id,pass;
Button submit;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference reference;
    Teacher_Adapter adapter;
    ArrayList<Teacher_Model> arrayList1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_verificatoin);
        college=findViewById(R.id.reg_collegeBox);
        name=findViewById(R.id.reg_name);
        id=findViewById(R.id.reg_idBox);
        pass=findViewById(R.id.reg_passwordBox);
        submit=findViewById(R.id.reg_submit);
       //String college_name = college.getText().toString();
        reference = db.getReference().child(college.getText().toString()).child("Teacher Name");
        arrayList1 = new ArrayList<>();
        adapter = new Teacher_Adapter(arrayList1, this);

     submit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
//             String teacher_name=name.getText().toString();
//             Intent intent2=new Intent(Teacher_verificatoin.this,Teacher_dashboard.class);
//             intent2.putExtra("teacher_name",teacher_name);
//             startActivity(new Intent(intent2));
             Intent intent=new Intent(Teacher_verificatoin.this,Teacher_dashboard.class);
             intent.putExtra("keyname",name.getText().toString());
             reference = db.getReference().child(college.getText().toString()).child("Teacher Name");
             name=findViewById(R.id.reg_name);
             String username=name.getText().toString();
             String s_id = ((TextView) findViewById(R.id.reg_idBox)).getText().toString();
             String s_password = ((TextView) findViewById(R.id.reg_passwordBox)).getText().toString();
             String s_college = ((TextView)findViewById(R.id.reg_collegeBox)).getText().toString();
             intent.putExtra("keyname", username);
             reference.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot snapshot) {
                     arrayList1.clear();
                     for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                       Teacher_Model model = dataSnapshot.getValue(Teacher_Model.class);
                         if(model==null)
                         {
                             arrayList1.add(new Teacher_Model("None","-1","01/01/01"));
                         }
                         else
                         {
                             arrayList1.add(model);
                         }
                     }
                     adapter.notifyDataSetChanged();
                 }

                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {

                 }

             });
             if (arrayList1.contains(new Teacher_Model(username,s_id,s_password))) {
                 startActivity(new Intent(intent));
                 // Toast.makeText(Teacher_verificatoin.this,"hi", Toast.LENGTH_SHORT).show();
                 // ;
             } else {
                 Toast.makeText(Teacher_verificatoin.this, "Enter a valid Credentials", Toast.LENGTH_SHORT).show();
             }

         }
     });

    }
}