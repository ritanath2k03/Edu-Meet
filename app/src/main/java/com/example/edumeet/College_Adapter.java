package com.example.edumeet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class College_Adapter extends RecyclerView.Adapter<College_Adapter.ViewHolder> {
    ArrayList<College_Model> arrayList;
   Context  context,context1;

    public College_Adapter(ArrayList<College_Model> arrayList, Context context1) {
        this.arrayList = arrayList;
        this.context1 = context1;
    }

    public College_Adapter(ArrayList<College_Model> arrayList, College_verification context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public College_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context1).inflate(R.layout.college_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull College_Adapter.ViewHolder holder, int position) {
       College_Model model=arrayList.get(position);
       holder.id.setText(model.getId());
       holder.pass.setText(model.getPass());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
   TextView id,pass;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.Id);
            pass=itemView.findViewById(R.id.Dob);
        }
    }
}
