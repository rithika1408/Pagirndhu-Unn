package com.example.pagirunarvu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter{

    List<FetchData> fetchData;


    public HelperAdapter(List<FetchData> fetchData){
        this.fetchData=fetchData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.retrieve,parent,false);

       MyViewHolder viewHolder=new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyViewHolder viewHolder=(MyViewHolder)holder;

        final FetchData fetchdata=this.fetchData.get(position);

        viewHolder.Date.setText(fetchdata.getDate());
        viewHolder.Name.setText(fetchdata.getName());
        viewHolder.Contact.setText(fetchdata.getContact().toString());
        viewHolder.Address.setText(fetchdata.getAddress());
        viewHolder.List.setText(fetchdata.getList());
        viewHolder.Description.setText(fetchdata.getDescription());
        viewHolder.Quantity.setText(fetchdata.getQuantity());

        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("fetch").child(fetchdata.getId());
                databaseReference.removeValue();

            }
        });


    }

    @Override
    public int getItemCount() {
        return fetchData.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Date,Name,Contact,Address,List,Description,Quantity;
        Button btnDelete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Date=itemView.findViewById(R.id.Date);
            Name=itemView.findViewById(R.id.Name);
            Contact=itemView.findViewById(R.id.Contact);
            Address=itemView.findViewById(R.id.Address);
            List=itemView.findViewById(R.id.List);
            Description=itemView.findViewById(R.id.Description);
            Quantity=itemView.findViewById(R.id.Quantity);

        }

    }


}
