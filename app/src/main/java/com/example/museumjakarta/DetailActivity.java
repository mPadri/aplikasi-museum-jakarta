package com.example.museumjakarta;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private String getId, getNama, getAlamat, getDesk, getOprasional;

    TextView nmMuseum, almtMuseum, deskMuseum, oprMuseum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nmMuseum = findViewById(R.id.namaMuseum);
        almtMuseum = findViewById(R.id.alamat);
        deskMuseum = findViewById(R.id.deskripsi);
        oprMuseum = findViewById(R.id.operasional);

        getId = getIntent().getStringExtra("id");
        getNama = getIntent().getStringExtra("nama");
        nmMuseum.setText(getNama);
        getAlamat = getIntent().getStringExtra("alamat");
        almtMuseum.setText(getAlamat);
        getDesk = getIntent().getStringExtra("desk");
        deskMuseum.setText(getDesk);
        getOprasional = getIntent().getStringExtra("oprasional");
        oprMuseum.setText(getOprasional);


    }

    public void openLocation(View view) {

        Uri addressUri = Uri.parse("geo:0,0?q=" + getAlamat);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else {
            Log.d("Implicit Intents", "Can't handle this!");
        }
    }
}
