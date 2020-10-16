package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main54Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main54 );

    }

        public void linegraph1(View view) {
            Intent my =new Intent ( Main54Activity.this , Main52Activity.class );
            startActivity ( my );
        }

        public void piegraph1(View view) {
            Intent my =new Intent ( Main54Activity.this , Main32Activity.class );
            startActivity ( my );
        }



}
