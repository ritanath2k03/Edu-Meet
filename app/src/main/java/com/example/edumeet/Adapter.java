package com.example.edumeet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<St_model> arrayList,arrayList1;
    Context context,context1;

    public Adapter(ArrayList<St_model> arrayList1, Student_verification context1) {
        this.arrayList1 = arrayList1;
        this.context1 = context1;
    }

    public Adapter(ArrayList<St_model> arrayList, Student_list context) {
        this.arrayList =  arrayList;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
St_model model=arrayList.get(position);
        holder.Name.setText(model.getName());
        holder.Id.setText(model.getId());
        holder.DOB.setText(model.getDOB());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        TextView Name,Id,DOB;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.name);
           Id=itemView.findViewById(R.id.Id);
            DOB=itemView.findViewById(R.id.Dob);


        }
    }


}
