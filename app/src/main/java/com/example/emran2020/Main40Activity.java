package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Main40Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main40 );
    }

    public void details100(View view) {
        Intent intent = new Intent ( Main40Activity.this, Main41Activity.class );
        startActivity ( intent );
    }

    public void myTraining(View view) {


        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.answer1 );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists ()) {
                    Intent intent = new Intent ( Main40Activity.this, Main42Activity.class );
                    startActivity ( intent );
                }
                else{
                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main40Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "You have no exercises");
                    builder.setIcon ( R.drawable.sad);
                    builder.setPositiveButton ( "Ok",null);
                    builder.create ();
                    builder.show ();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );


    }
}
