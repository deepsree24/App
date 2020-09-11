package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UserActivty extends AppCompatActivity {
    Button btnLogOut,btnBMI,btnDiet,btnClk,btnExer,btnstop,btnstep;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        System.out.println(user);

        btnBMI=(Button) findViewById(R.id.btnBMI);
        btnDiet=(Button) findViewById(R.id.btnDiet) ;
        btnClk=(Button) findViewById(R.id.btnClk) ;
        btnExer=(Button) findViewById(R.id.btnExer) ;
        btnstop=findViewById(R.id.btnstop);
        btnstep=findViewById(R.id.btnstep);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);


        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivty.this, BmiActivity.class);
                startActivity(I);
            }
        });

        btnDiet.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivty.this, FitnessTipsActivity.class);
                startActivity(I);
            }
        });

        btnClk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivty.this, RemainderActivity.class);
                startActivity(I);
            }
        });

        btnExer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivty.this, WorkoutActivity.class);
                startActivity(I);
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivty.this, Stopwatch.class);
                startActivity(I);
            }
        });

        btnstep.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(UserActivty.this, StepcounterActivity.class);
                startActivity(I);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(UserActivty.this, ActivityLogin.class);
                startActivity(I);

            }
        });
    }
}