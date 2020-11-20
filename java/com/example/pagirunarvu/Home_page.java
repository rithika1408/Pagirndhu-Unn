package com.example.pagirunarvu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;

public class Home_page extends AppCompatActivity {

    CardView donate;
    CardView collect;
    ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        donate=findViewById(R.id.donate);
        collect=findViewById(R.id.collect);

        int image[]={R.drawable.h1,R.drawable.h4,R.drawable.h5,R.drawable.h6,R.drawable.h7};

        viewFlipper=findViewById(R.id.viewfilp);

        for(int i:image){
            flipperimages((i));
        }
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_page.this,Donate.class));
            }
        });
        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_page.this,Collect.class));
            }
        });


    }
    public void flipperimages(int images){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(images);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.logout) {

            Toast.makeText(Home_page.this, "Logged out Successfully", Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();

        }
        if(id==R.id.chatbot){

            Intent b = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web-chat.global.assistant.watson.cloud.ibm.com/preview.html?region=eu-gb&integrationID=6fca1f90-dcf7-4da0-ab01-cee80554056e&serviceInstanceID=faf5e2da-0250-446a-8ac6-31e40d6d49a6"));
            startActivity(b);

        }


        return super.onOptionsItemSelected(item);
    }

}