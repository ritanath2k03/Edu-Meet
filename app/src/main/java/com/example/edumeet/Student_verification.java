package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Student_verification extends AppCompatActivity {
EditText name,id,dob,college;
Button Enter;
FirebaseDatabase db=FirebaseDatabase.getInstance();
DatabaseReference reference;
Adapter adapter;
ArrayList<St_model> arrayList1;

    public static final String Extra_name="keyname";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_verification);
       Enter=findViewById(R.id.st_Enter);
       id=findViewById(R.id.st_id);
       dob=findViewById(R.id.st_dob);
        college=findViewById(R.id.st_college);
       // String college_name = college.getText().toString();
        reference=db.getReference().child("BIT").child("Student Name");
        arrayList1=new ArrayList<>();
        adapter=new Adapter(arrayList1,this);

       Enter.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(Student_verification.this, Student_dashboard.class);
               name = findViewById(R.id.st_name);
               String username = name.getText().toString();
               intent.putExtra(Extra_name, username);
               startActivity(new Intent(intent));

reference.addValueEventListener(new ValueEventListener()
               { @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
//        for(DataSnapshot dataSnapshot:snapshot.getChildren()){
//            St_model Model=dataSnapshot.getValue(St_model.class);
//            arrayList1.add(Model);
//        }
//        adapter.notifyDataSetChanged();



//                   arrayList1.clear();
//                   for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                       St_model Model = dataSnapshot.getValue(St_model.class);
//                       if(Model==null)
//                       {
//                           arrayList1.add(new St_model("None","1","01/01/01"));
//                       }
//                       else
//                       {
//                           arrayList1.add(Model);
//                       }
//                   }
//                   adapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }

});

//               Integer s = arrayList1.size();
//               if (arrayList1.contains(new St_model(username, id.getText().toString(), dob.getText().toString()))) {
//                   startActivity(intent);
//                   Toast.makeText(Student_verification.this, s.toString(), Toast.LENGTH_SHORT).show();
//                   ;
//               } else {
//                   Toast.makeText(Student_verification.this, "Enter a valid name", Toast.LENGTH_SHORT).show();
//               }
   }
});




    }
}