package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main25Activity extends AppCompatActivity {
    RadioButton rd1, rd2;
    SatisfactionOfPatients satisfactionOfPatients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main25 );
        rd1 = findViewById ( R.id.radioButton8 );
        rd2 = findViewById ( R.id.radioButton9 );


    }

    public void continue2(View view) {

        String answer;
        int answer1;


        if (rd1.isChecked () == false && rd2.isChecked () == false) {
            Toast.makeText ( this, "Please Choose Answer", Toast.LENGTH_LONG ).show ();
            return;
        }

            if (rd1.isChecked ()) {
                answer = "yes";
                answer1=2;
            } else {
                answer = "no";
                answer1=1;
            }

            GlobalClass.satisfation=answer;
            GlobalClass.satisfation1=answer1;


            Intent intent = new Intent ( Main25Activity.this, Main3Activity.class );
            startActivity ( intent );


        }
    }

