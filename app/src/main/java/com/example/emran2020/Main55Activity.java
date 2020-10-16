package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main55Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main55 );
    }

    public void show980(View view) {

        Intent intent =new Intent ( Main55Activity.this,Main39Activity.class );
        startActivity ( intent);
    }



    public void show9800(View view) {

        Intent intent =new Intent ( Main55Activity.this,Main29Activity.class );
        startActivity ( intent);
    }

}
