package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Registered_teacher_name extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference reference;
    Teacher_Adapter adapter1;
    ArrayList<Teacher_Model> list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_teacher_name);
        recyclerView=findViewById(R.id.recyclerView);

        String college_name=getIntent().getStringExtra("college_name");

        reference=db.getReference().child(college_name).child("Teacher Name");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list1=new ArrayList<>();
        adapter1= new Teacher_Adapter(list1,this);
        recyclerView.setAdapter(adapter1);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Teacher_Model Model1=dataSnapshot.getValue(Teacher_Model.class);
                    list1.add(Model1);
                }
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}