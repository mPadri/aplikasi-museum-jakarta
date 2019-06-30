package com.example.museumjakarta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnJakut,btnJakbar,btnJakpus,btnJaktim,btnJaksel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJakut = findViewById(R.id.btn_jakut);
        btnJakut.setOnClickListener(this);

        btnJakbar = findViewById(R.id.btn_jakbar);
        btnJakbar.setOnClickListener(this);

        btnJakpus = findViewById(R.id.btn_jakpus);
        btnJakpus.setOnClickListener(this);

        btnJaktim = findViewById(R.id.btn_jaktim);
        btnJaktim.setOnClickListener(this);

        btnJaksel = findViewById(R.id.btn_jaksel);
        btnJaksel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_jakut:
                Intent goJakut = new Intent(MainActivity.this, ListJakut.class);
                startActivity(goJakut);
                break;
            case R.id.btn_jakbar:
                Intent goJakbar = new Intent(MainActivity.this, ListJakbar.class);
                startActivity(goJakbar);
                break;
            case R.id.btn_jakpus:
                Intent goJakpus = new Intent(MainActivity.this, ListJakpus.class);
                startActivity(goJakpus);
                break;
            case R.id.btn_jaktim:
                Intent goJaktim = new Intent(MainActivity.this, ListJaktim.class);
                startActivity(goJaktim);
                break;
            case R.id.btn_jaksel:
                Intent goJakasel = new Intent(MainActivity.this, ListJaksel.class);
                startActivity(goJakasel);
                break;

        }
    }
}
