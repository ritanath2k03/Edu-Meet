package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.load.model.Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Student_list extends AppCompatActivity {

    RecyclerView recyclerView;
FirebaseDatabase db=FirebaseDatabase.getInstance();
DatabaseReference reference;
Adapter adapter;
ArrayList<St_model> list;
ImageButton delete_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
       recyclerView=findViewById(R.id.recyclerView);

       View view=getLayoutInflater().inflate(R.layout.layout,null);
       delete_btn=view.findViewById(R.id.delete);

        Intent i=getIntent();
        String college_name=i.getStringExtra("college_name");
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                reference=db.getReference().child(college_name).child("Student Name");
//  reference.removeValue();
                Log.d("TAG",college_name);
            }
        });
       // String college_name=getIntent().getStringExtra("college_name");

        reference=db.getReference().child(college_name).child("Student Name");
        recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       list=new ArrayList<>();
       adapter=new Adapter(list,this);
       recyclerView.setAdapter(adapter);

       reference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               for(DataSnapshot dataSnapshot:snapshot.getChildren()) {
                   St_model Model = dataSnapshot.getValue(St_model.class);
                   list.add(Model);
               }
               adapter.notifyDataSetChanged();

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });

    }
}