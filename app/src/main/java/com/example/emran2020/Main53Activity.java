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

public class Main53Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main53 );
    }

    public void piegraph(View view) {

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Satisfaction Of Patients" );
        Query query = reference.orderByChild ( "id" ).equalTo ( GlobalClass.idGraph);
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists ()) {

                    Intent my =new Intent ( Main53Activity.this , Main24Activity.class );
                    startActivity ( my );
                }
                else{
                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main53Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "This id: "+"< " +GlobalClass.idGraph+" >"+ " is not exists");
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

    public void linegraph (View view) {

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Satisfaction Of Patients" );
        Query query = reference.orderByChild ( "id" ).equalTo ( GlobalClass.idGraph);
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists ()) {

                    Intent my =new Intent ( Main53Activity.this , Main51Activity.class );
                    startActivity ( my );
                }
                else{
                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main53Activity.this );
                    builder.setTitle ( "Message" );
                    builder.setMessage ( "This id: "+"< " +GlobalClass.idGraph+" >"+ " is not exists");
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
