package com.example.pagirunarvu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Collect extends AppCompatActivity {

    EditText Fullname,contact;
    Button continu;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        final AutoCompleteTextView spinner=findViewById(R.id.spinner);

        Fullname=findViewById(R.id.fulname);
        contact=findViewById(R.id.con);
        continu=findViewById(R.id.cont);
        ImageView imageView =findViewById(R.id.imagevieww);
        fAuth=FirebaseAuth.getInstance();

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Type);
        spinner.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.showDropDown();
            }
        });

        continu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Continue_collectform.class));


            }
        });


    }
    private static final String[] Type=new String[]{"Individual","Organisation"};
}