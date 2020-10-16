package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

import java.util.ArrayList;

public class Main52Activity extends AppCompatActivity {
    TextView text ,text2,text3;

    LineGraphSeries series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main52 );

        text=findViewById ( R.id.textView86 );
        text2=findViewById ( R.id.textView88 );

        text3=findViewById ( R.id.textView87 );

        text.setText ( "Patient's ID: "+ GlobalClass.idGraph );

        text3.setText ( "- כל אחד מערכי ציר X מתאר בדיקה כללית."+ "\n"+
                 "- ציר Y מתאר את רמת הסיכון המטובל בכל אימון" +
                "\n"+ "- גבוהה= 3   בינונית=2    נמוכה=1 ");



        final GraphView graph = (GraphView) findViewById ( R.id.view3 );
        series=new LineGraphSeries (  );
        graph.addSeries ( series );
        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Patients Training" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.idGraph );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataPoint [] dp=new DataPoint [(int) dataSnapshot.getChildrenCount ()];
                int index=0;
                int i=1;
                int count=0;
                int key=0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    PatientsTraining dax=dataSnapshot1.getValue (PatientsTraining.class);
                    count++;
                      key=0;
                    String risk=dax.getL________RiskLevel ();
                    if(risk.equals ( "Low" )){
                      key=1;
                    }
                    else if(risk.equals ( "Medium" )){
                        key=2;
                    }
                    else{
                        key=3;
                    }

                    dp[index]=new DataPoint ( i++ ,key );
                    index++;



                }
                text2.setText ("The number of general tests the patient did:"+String.valueOf (count));
                series.resetData ( dp );

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText ( Main52Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );


    }


    public void details59(View view){

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.idGraph );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot1.getValue ( Users.class );

                    AlertDialog.Builder builder= new AlertDialog.Builder ( Main52Activity.this );
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
                Toast.makeText ( Main52Activity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }
}