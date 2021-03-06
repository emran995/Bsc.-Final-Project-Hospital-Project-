package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Main14Activity extends AppCompatActivity {
    EditText firstName, lastName, gender, birthday, newPassWord3, phone, location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main14 );



        firstName = findViewById ( R.id.editText54 );
        lastName = findViewById ( R.id.editText55 );
        gender = findViewById ( R.id.editText56 );
        birthday = findViewById ( R.id.editText63 );
        newPassWord3 = findViewById ( R.id.editText65 );
        phone = findViewById ( R.id.editText64 );
        location = findViewById ( R.id.editText66);



    }


    public void update55(View view) {
        String pass=newPassWord3.getText ().toString ();
        if (TextUtils.isEmpty (  newPassWord3.getText ().toString () )) {
            Toast.makeText ( Main14Activity.this, "Enter Your Password",
                    Toast.LENGTH_SHORT ).show ();
            newPassWord3.setError ( "Enter Your Password" );
            return;
        }


        if ( TextUtils.isEmpty (  newPassWord3.getText ().toString () )) {
            Toast.makeText ( Main14Activity.this, "Enter Your Password",
                    Toast.LENGTH_SHORT ).show ();
            newPassWord3.setError ( "Enter Your Password" );
            return;
        }


        if( newPassWord3.getText ().toString ().length ()<6){
            Toast.makeText ( Main14Activity.this, "Your Password should be at least 6 numbers/characters",
                    Toast.LENGTH_SHORT ).show ();
            newPassWord3.setError ( "Your Password should be at least 6 numbers/characters" );
            return;
        }


        updateData (GlobalClass.updateId);



    }
    private void updateData(final String yourId){


        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo (GlobalClass.updateId);
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );
                    String old = dataSnapshot11.child ( "e________PassWord" ).getValue ().toString ();
                    GlobalClass.oldPassWord = old;
                    dataSnapshot11.getRef ().child ( "e________PassWord" ).setValue ( newPassWord3.getText ().toString () );

                }
                changePassWord ( GlobalClass.updateId, GlobalClass.oldPassWord, newPassWord3.getText ().toString () );


                Toast.makeText ( Main14Activity.this, "Your password update was performed successfully", Toast.LENGTH_SHORT ).show ();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
    }


    public void changePassWord(final String id, final String oldPass , final String newPass) {
        final String idd =id+"@gmail.com";

        final FirebaseAuth mAuthh = FirebaseAuth.getInstance ();
        mAuthh.signInWithEmailAndPassword ( idd, oldPass )
                .addOnCompleteListener ( Main14Activity.this, new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            final FirebaseUser user = mAuthh.getCurrentUser ();

                            updateUIi ( user );



// Get auth credentials from the user for re-authentication. The example below shows
// email and password credentials but there are multiple possible providers,
// such as GoogleAuthProvider or FacebookAuthProvider.
                        AuthCredential credential = EmailAuthProvider
                                .getCredential(idd, oldPass);

// Prompt the user to re-provide their sign-in credentials
                        user.reauthenticate(credential)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    private static final String TAG =" Message" ;

                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            user.updatePassword(newPass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Log.d(TAG, "Password updated");
                                                    } else {
                                                        Log.d(TAG, "Error password not updated");
                                                    }
                                                }
                                            });
                                        } else {
                                            Log.d(TAG, "Error auth failed");
                                        }
                                    }
                                });



                    }

                } );




    }




    public void updateUIi(final FirebaseUser currentUser) {

        Intent myy = new Intent ( Main14Activity.this, Main14Activity.class );
        myy.putExtra ( "ID ,", currentUser.getEmail () );
        startActivity ( myy );
        //   }
    }




    public void update11(View view) {
        if (TextUtils.isEmpty ( firstName.getText ().toString () )) {
            Toast.makeText ( Main14Activity.this, "Enter Your First Name",
                    Toast.LENGTH_SHORT ).show ();
            firstName.setError ( "Enter Your First Name" );
            return;
        }

        if(firstName.getText ().toString ().contains ( " " )){
            Toast.makeText ( Main14Activity.this, "enter a correct First Name",
                    Toast.LENGTH_SHORT ).show ();
            firstName.setError ( "enter a correct First Name" );
            return;

        }

        if(firstName.getText ().toString ().length ()<2){
            Toast.makeText ( Main14Activity.this, "Your First Name should be at least 2 characters" ,
                    Toast.LENGTH_SHORT ).show ();
            firstName.setError ( "Your First Name should be at least 2 characters" );
            return;

        }

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.updateId);
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );
                    dataSnapshot11.getRef ().child ( "c________FirstName" ).setValue ( firstName.getText ().toString () );


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        } );

        Toast.makeText ( Main14Activity.this, " Your First Name update was performed successfully", Toast.LENGTH_SHORT ).show ();


    }


    public void update22(View view) {
        if (TextUtils.isEmpty ( lastName.getText ().toString () )) {
            Toast.makeText ( Main14Activity.this, "Enter Your Last Name",
                    Toast.LENGTH_SHORT ).show ();
            lastName.setError ( "Enter Your Last Name" );
            return;
        }


        if(lastName.getText ().toString ().contains ( " " )){
            Toast.makeText ( Main14Activity.this, "enter a correct Last Name",
                    Toast.LENGTH_SHORT ).show ();
            lastName.setError ( "enter a correct Last Name" );
            return;

        }

        if(lastName.getText ().toString ().length ()<2){
            Toast.makeText ( Main14Activity.this, "Your Last Name should be at least 2 characters",
                    Toast.LENGTH_SHORT ).show ();
            lastName.setError ( "Your Last Name should be at least 2 characters" );
            return;

        }


        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.updateId);
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );

                    dataSnapshot11.getRef ().child ( "d________LastName" ).setValue ( lastName.getText ().toString () );


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        Toast.makeText ( Main14Activity.this, " Your Last Name update was performed successfully", Toast.LENGTH_SHORT ).show ();


    }

    public void update33(View view) {
        if (TextUtils.isEmpty ( gender.getText ().toString () )) {
            Toast.makeText ( Main14Activity.this, "Enter Your Gender",
                    Toast.LENGTH_SHORT ).show ();
            gender.setError ( "Enter Your Gender" );
            return;
        }

        if(gender.getText ().toString ().contains ( " " )){
            Toast.makeText ( Main14Activity.this, "enter a correct Gender male / female",
                    Toast.LENGTH_SHORT ).show ();
            gender.setError ( "enter a correct Gender male / female" );
            return;

        }

//        if(gender.getText ().toString ()!="male" || gender.getText ().toString ()!="female"){
//            Toast.makeText ( Main14Activity.this, "enter a correct Gender male / female",
//                    Toast.LENGTH_SHORT ).show ();
//            gender.setError ( "enter a correct Gender male / female");
//            return;
//
//        }

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.updateId );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );

                    dataSnapshot11.getRef ().child ( "f________Gender" ).setValue ( gender.getText ().toString () );


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        Toast.makeText ( Main14Activity.this, " Your Gender update was performed successfully", Toast.LENGTH_SHORT ).show ();

    }

    public void update44(View view) {

        if (TextUtils.isEmpty ( birthday.getText ().toString () )) {
            Toast.makeText ( Main14Activity.this, "Enter Your Birthday",
                    Toast.LENGTH_SHORT ).show ();
            birthday.setError ( "Enter Your Birthday" );
            return;
        }



        int Count=0;
        boolean check=false;
        for(int m=0 ; m<birthday.length (); m++){
            if(birthday.getText ().toString ().charAt ( m)=='/'){
                Count++;

            }
        }
        if(Count==2){


            if(birthday.length ()==8 || birthday.length ()==9 || birthday.length ()==10 ) {

                if ((birthday.getText ().toString ().charAt ( 1 ) == '/' && birthday.getText ().toString ().charAt ( 3 ) == '/')
                        || (birthday.getText ().toString ().charAt ( 2 ) == '/' && birthday.getText ().toString ().charAt ( 4 ) == '/')
                        || (birthday.getText ().toString ().charAt ( 2 ) == '/' && birthday.getText ().toString ().charAt ( 5 ) == '/')
                        || (birthday.getText ().toString ().charAt ( 1 ) == '/' && birthday.getText ().toString ().charAt ( 4 ) == '/')) {
                    check = true;
                } else {
                    check = false;
                }
            }



        }
        else{
            Toast.makeText ( Main14Activity.this, "enter a correct date :\n dat/month/year ",
                    Toast.LENGTH_SHORT ).show ();
            birthday.setError ( "enter a correct date " );
            return;

        }



        if(check==false){
            Toast.makeText ( Main14Activity.this, "enter a correct date :\n dat/month/year ",
                    Toast.LENGTH_SHORT ).show ();
            birthday.setError ( "enter a correct date " );
            return;
        }


        String age1="";
        int count=0;
        int k1=0;
        for(int k=0 ;k<birthday.getText ().toString ().length ();k++){
            if(count==2){
                k1=k;
                break;
            }
            if (birthday.getText ().toString ().charAt ( k ) == '/') {
                count++;
            }
        }

        if(age1.length ()>4){
            Toast.makeText ( Main14Activity.this, "enter a correct date :\n dat/month/year ",
                    Toast.LENGTH_SHORT ).show ();
            birthday.setError ( "enter a correct date " );


        }
        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.updateId );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );

                    dataSnapshot11.getRef ().child ( "g________Birthday" ).setValue ( birthday.getText ().toString () );


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        Toast.makeText ( Main14Activity.this, " Your Birthday update was performed successfully", Toast.LENGTH_SHORT ).show ();


    }



    public void update66(View view) {
        if (TextUtils.isEmpty (phone.getText ().toString () )) {
            Toast.makeText ( Main14Activity.this, "Enter Your Phone",
                    Toast.LENGTH_SHORT ).show ();
            phone.setError ( "Enter Your Phone" );
            return;
        }

        if (TextUtils.isEmpty ( phone.getText ().toString ())) {
            phone.setError ( "Enter Your Phone" );
            Toast.makeText ( Main14Activity.this, "Enter Your Phone",
                    Toast.LENGTH_SHORT ).show ();
            return;
        }

        if(phone.getText ().toString ().length ()<7){
            Toast.makeText ( Main14Activity.this, "Your Password should be at least 6 numbers/characters",
                    Toast.LENGTH_SHORT ).show ();
            phone.setError ( "Your Phone should be at least 7 numbers" );
            return;
        }


        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.updateId);
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );

                    dataSnapshot11.getRef ().child ( "i________Phone" ).setValue ( phone.getText ().toString () );


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        Toast.makeText ( Main14Activity.this, " Your Phone update was performed successfully",Toast.LENGTH_SHORT ).show ();
    }

    public void update77(View view) {
        if (TextUtils.isEmpty ( location.getText ().toString () )) {
            Toast.makeText ( Main14Activity.this, "Enter Your Location",
                    Toast.LENGTH_SHORT ).show ();
            location.setError ( "Enter Your Location" );
            return;
        }

        DatabaseReference reference = FirebaseDatabase.getInstance ().getReference ().child ( "Data" ).child ( "Members" );
        Query query = reference.orderByChild ( "b________Id" ).equalTo ( GlobalClass.updateId );
        query.addListenerForSingleValueEvent ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot11 : dataSnapshot.getChildren ()) {
                    Users p = dataSnapshot11.getValue ( Users.class );
                    String first = p.getC________FirstName ();


                    dataSnapshot11.getRef ().child ( "j________Location" ).setValue ( location.getText ().toString () );


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        Toast.makeText ( Main14Activity.this, " Your Location update was performed successfully", Toast.LENGTH_SHORT ).show ();
    }








}
