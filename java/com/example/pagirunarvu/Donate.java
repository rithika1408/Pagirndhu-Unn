package com.example.pagirunarvu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Context;

public class Donate extends AppCompatActivity {

    private EditText name,contact,address;
    private EditText list,description,quantity,date;
    private Button submit;

    public class Con{
        public static final String STORAGE_PATH_UPLOADS="fetch/";
        public static final String DATABASE_PATH_UPLOADS="fetch";
    }
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        date=findViewById(R.id.Date);
        name=findViewById(R.id.Name);
        contact=findViewById(R.id.Contact);
        address=findViewById(R.id.Address);
        list=findViewById(R.id.List);
        description=findViewById(R.id.Description);
        quantity=findViewById(R.id.Quantity);
        submit=findViewById(R.id.submit);
        ref= FirebaseDatabase.getInstance().getReference(Con.DATABASE_PATH_UPLOADS);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id,Date,Name,Address,List,Description,Quantity;
                Long Contact;
                id=ref.push().getKey();
                Date=date.getText().toString();
                Name=name.getText().toString();
                Contact= Long.valueOf(contact.getText().toString());
                Address=address.getText().toString();
                List=list.getText().toString();
                Description=description.getText().toString();
                Quantity=quantity.getText().toString();

                FetchData fetchData=new FetchData(id,Date,Name,Contact,Address,List,Description,Quantity);
                ref.child(id).setValue(fetchData);

                Toast.makeText(Donate.this,"Data submitted successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Donate.this,FoodTest.class));
            }
        });


    }
}