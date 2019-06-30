package com.example.museumjakarta;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.museumjakarta.adapter.RequestAdapterRecyclerView;
import com.example.museumjakarta.model.Request;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListJakbar extends AppCompatActivity {

    private DatabaseReference database;
    private ArrayList<Request> daftarReq;
    private RequestAdapterRecyclerView requestAdapterRecyclerView;

    private RecyclerView rcListRequest;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jakbar);
        database = FirebaseDatabase.getInstance().getReference();

        rcListRequest = findViewById(R.id.rc_list_request);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcListRequest.setLayoutManager(mLayoutManager);
        rcListRequest.setItemAnimator(new DefaultItemAnimator());

        loading =  ProgressDialog.show(ListJakbar.this,
                null,
                "Mohon Tunggu...",
                true,
                false);

        database.child("JakartaBarat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                daftarReq = new ArrayList<>();

                for (DataSnapshot masukanData : dataSnapshot.getChildren()){
                    Request requests = masukanData.getValue(Request.class);
                    requests.setKey(masukanData.getKey());

                    daftarReq.add(requests);
                }

                requestAdapterRecyclerView = new RequestAdapterRecyclerView(daftarReq, ListJakbar.this);
                rcListRequest.setAdapter(requestAdapterRecyclerView);
                loading.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                System.out.println(error.getDetails() + "" + error.getMessage());
                loading.dismiss();
            }
        });

    }
}
