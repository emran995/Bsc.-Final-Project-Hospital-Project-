package com.example.emran2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main5 );


//       Users user = new Users ("12/9/1995","315939511","Emran","abdallah","050052054"
//               ,"male","12/9/1995","70","0529551229","haifa");
//
//        DatabaseReference Dataa = FirebaseDatabase.getInstance ().getReference ("Data").child ( "Medical Staff" );
//        Dataa.push ().setValue ( user );

    }

    public void start8(View view) {

        Intent my = new Intent ( Main5Activity.this, Main4Activity.class );
        startActivity ( my );

    }

}