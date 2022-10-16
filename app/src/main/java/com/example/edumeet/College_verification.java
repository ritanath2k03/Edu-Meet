package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class College_verification extends AppCompatActivity {
Button create_btn,enter_btn;
EditText collegename,collegeid,collegepass;
FirebaseDatabase db=FirebaseDatabase.getInstance();
DatabaseReference reference;
College_Adapter adapter;
ArrayList<College_Model> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_verification);
     create_btn=findViewById(R.id.createBtn);
   enter_btn=findViewById(R.id.college_enter);
collegename=findViewById(R.id.college_name);
collegeid=findViewById(R.id.college_id);
collegepass=findViewById(R.id.college_password);
reference=db.getReference().child(collegename.getText().toString());
arrayList=new ArrayList<>();
adapter=new College_Adapter(arrayList,this);
   enter_btn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           Intent intent1=new Intent(College_verification.this,College_dashboard_main.class);
           reference = db.getReference().child(collegename.getText().toString());

           String s_id = ((TextView) findViewById(R.id.college_id)).getText().toString();
           String s_dob = ((TextView) findViewById(R.id.college_password)).getText().toString();

           reference.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot snapshot) {
                   arrayList.clear();
                   for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                       College_Model Model=dataSnapshot.getValue(College_Model.class);
                       if(Model==null){
                           arrayList.add(new College_Model("-1","none"));
                       }
                       else
                       {
                           arrayList.add(Model);
                       }
                   }
               }

               @Override
               public void onCancelled(@NonNull DatabaseError error) {

               }
           });
           if(arrayList.contains(new College_Model(s_id,s_dob))){
               intent1.putExtra("keyname",collegename.getText().toString());

               Intent intent=new Intent(College_verification.this,College_dashboard_main.class);

               intent.putExtra("name",collegename.getText().toString());
               startActivity(intent1);
           }
           else{
               Toast.makeText(College_verification.this, "Enter Valid credential", Toast.LENGTH_SHORT).show();
           }




       }
   });
            create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( College_verification.this,Create_college.class));
            }
        });
    }


}