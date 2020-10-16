package com.example.emran2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main15Activity extends AppCompatActivity {
    EditText value11 ,value22 ,value33 , value44;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main15 );

        value11 =findViewById ( R.id.editText);
        value22 =findViewById ( R.id.editText3);
        value33 =findViewById ( R.id.editText2 );
        value44=findViewById ( (R.id.editText6) );

    }

    public void Next1(View view) {
        String weight=value11.getText ().toString ();
        String heartb=value22.getText ().toString ();
        String bloodSystolic=value33.getText ().toString ();
        String bloodDiastolic=value44.getText ().toString ();


        if (TextUtils.isEmpty ( weight) &TextUtils.isEmpty ( heartb)&& TextUtils.isEmpty ( bloodSystolic)&& TextUtils.isEmpty ( bloodDiastolic)) {
            Toast.makeText ( Main15Activity.this, "Enter the answers",
                    Toast.LENGTH_SHORT ).show ();
            value11.setError ( "Enter Your weight" );
            value22.setError ( "Enter Your heartbeat" );
            value33.setError ( "Enter Your blood pressure (SYSTOLIC)" );
            value44.setError ( "Enter Your blood pressure (DIASTOLIC)" );
            return;
        }



        if (TextUtils.isEmpty ( weight)) {
            Toast.makeText ( Main15Activity.this, "Enter Your weight",
                    Toast.LENGTH_SHORT ).show ();
            value11.setError ( "Enter Your weight" );

            return;
        }
        if (TextUtils.isEmpty ( heartb)) {
            Toast.makeText ( Main15Activity.this, "Enter Your heartbeat",
                    Toast.LENGTH_SHORT ).show ();
            value22.setError ( "Enter Your heartbeat" );

            return;
        }

        if (TextUtils.isEmpty ( bloodSystolic)) {
            Toast.makeText ( Main15Activity.this, "Enter Your blood pressure (SYSTOLIC)",
                    Toast.LENGTH_SHORT ).show ();
            value33.setError ( "Enter Your blood pressure (SYSTOLIC)" );

            return;
        }

        if (TextUtils.isEmpty ( bloodDiastolic)) {
            Toast.makeText ( Main15Activity.this, "Enter Your blood pressure (DIASTOLIC)",
                    Toast.LENGTH_SHORT ).show ();
            value44.setError ( "Enter Your blood pressure (DIASTOLIC)" );

            return;
        }






        GlobalClass.weight=weight;
        GlobalClass.heartbeat=heartb;
        GlobalClass.bloodpressureSystolic=bloodSystolic;
        GlobalClass.bloodpressureDiastolic=bloodDiastolic;

        Intent intent = new Intent ( Main15Activity.this ,Main17Activity.class );
        startActivity ( intent );
    }
}