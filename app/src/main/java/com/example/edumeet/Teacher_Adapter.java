package com.example.edumeet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Teacher_Adapter extends RecyclerView.Adapter<Teacher_Adapter.ViewHolder1> {
    ArrayList<Teacher_Model> arrayList1;
    Context context;

    public Teacher_Adapter(ArrayList<Teacher_Model> arrayList, Context context) {
        this.arrayList1 = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.teacher_layout,parent,false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 holder, int position) {
Teacher_Model model1=arrayList1.get(position);
holder.name.setText(model1.getName());
        holder.id.setText(model1.getId());
        holder.pass.setText(model1.getPassword());
    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder{
        TextView name,id,pass;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            id=itemView.findViewById(R.id.Id);
            pass=itemView.findViewById(R.id.Password);
        }
    }
}
