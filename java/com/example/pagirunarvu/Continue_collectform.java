package com.example.pagirunarvu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListAdapter_LifecycleAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Queue;

public class Continue_collectform extends AppCompatActivity {

    List<FetchData> fetchData;
    ListView lv;
    FirebaseListAdapter adapter;
    private ProgressDialog progressDialog;

    DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_collectform);

        progressDialog = new ProgressDialog(this);


        lv = findViewById(R.id.listview);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        Query query = FirebaseDatabase.getInstance().getReference().child("fetch");
        FirebaseListOptions<FetchData> options = new FirebaseListOptions.Builder<FetchData>()
                .setLayout(R.layout.retrieve).setQuery(query, FetchData.class).build();
        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) {
                TextView Date = v.findViewById(R.id.Date);
                TextView Name = v.findViewById(R.id.Name);
                TextView Contact = v.findViewById(R.id.Contact);
                TextView Address = v.findViewById(R.id.Address);
                TextView List = v.findViewById(R.id.List);
                TextView Description = v.findViewById(R.id.Description);
                TextView Quantity = v.findViewById(R.id.Quantity);

                progressDialog.dismiss();

                FetchData std = (FetchData) model;
                Date.setText("Date: "+std.getDate().toString());
                Name.setText("Donor Name: "+std.getName().toString());
                Contact.setText("Contact Number: "+std.getContact().toString());
                Address.setText("Address: "+std.getAddress().toString());
                List.setText("List Of Food Items: "+std.getList().toString());
                Description.setText("Description: "+std.getDescription().toString());
                Quantity.setText("Quantity: "+std.getQuantity().toString());
            }
        };
        lv.setAdapter(adapter);



    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}