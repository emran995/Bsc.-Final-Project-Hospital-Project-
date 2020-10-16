package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

import java.util.ArrayList;

public class Main24Activity extends AppCompatActivity {
    TextView text1 ,text2,text3,text4;

    String id = GlobalClass.idGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main24 );

        text1=findViewById ( R.id.textView25 );
        text2=findViewById ( R.id.textView63 );
        text3=findViewById ( R.id.textView62 );
        text4=findViewById ( R.id.textView64);
        text1.setText ( "Id: "+id);



        count();


    }
    public void pie (int x, int y){
        AnimatedPieView mAnimatedPieView = findViewById(R.id.animatedPieView36);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        config.startAngle(-90)// Starting angle offset
                .addData(new SimplePieInfo (x, Color.parseColor ("#5FFF33" ), ( "Satisfied" ) ))
                .addData(new SimplePieInfo(y, Color.parseColor ("#FF3633" ),( "Not Satisfied" ))).drawText(true).strokeMode ( false)
                .duration(2000).textSize ( 25);
        //

// The following two sentences can be replace directly 'mAnimatedPieView.start (config); '
        mAnimatedPieView.applyConfig(config);
        mAnimatedPieView.start();
    }
    public void count() {


        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Satisfaction Of Patients" );
        Query query = reference.orderByChild ( "id" ).equalTo (id);
        query.addListenerForSingleValueEvent ( new ValueEventListener ()  {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int a = 0;
                int b = 0;


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    SatisfactionOfPatients p = dataSnapshot1.getValue (SatisfactionOfPatients.class );

                    if (p.getSatisfaction ().equals ( "yes" )) {
                        a++;
                    }
                    else if(p.getSatisfaction ().equals ( "no" )){
                        b++;
                    }

                }


                text2.setText ( "Number of exercises: "+ String.valueOf ( a+b) );
                text3.setText ( "The number of times the patient was SATISFIED: "+ String.valueOf ( a ) );
                text4.setText ( "The number of times the patient was NOT SATISFIED: "+ String.valueOf ( b ) );


                Log.v ( "yes", String.valueOf ( a ) );
                Log.v ( "no", String.valueOf ( b ) );

                pie(a,b);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main24Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }
    public void details444(View view){

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( id);
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot1.getValue ( Users.class );

                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main24Activity.this );
                    builder.setTitle ( "Details" );
                    builder.setIcon ( R.drawable.person1);
                    builder.setMessage (
                            "Registration Date:   "+p.getA________RegistrationDate ()+"\n"+"\n"+
                                    "First Name:   " + p.getC________FirstName ()+"\n"+"\n"+
                                    "Last Name:  " + p.getD________LastName ()+"\n"+"\n"+
                                    "Age:   " + p.getH________Age ()+"\n" +"\n"+
                                    "Gender:   " + p.getF________Gender ()+"\n" +"\n"+
                                    "Birthday:   "+ p.getG________Birthday ()+"\n" +"\n"+
                                    "Phone:   "+ p.getI________Phone ()+"\n" +"\n"+
                                    "Location:   "+ p.getJ________Location ());
                    builder.setPositiveButton ( "Go back",null);

                    builder.create ();
                    builder.show ();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main24Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }








}
