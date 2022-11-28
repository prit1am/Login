package com.example.myfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText em;
    private EditText pas;
    private Button lg;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        em=findViewById(R.id.em);
        pas=findViewById(R.id.pas);
        lg=findViewById(R.id.lg);
        auth=FirebaseAuth.getInstance();

       lg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email1=em.getText().toString();
               String password=pas.getText().toString();
               if(TextUtils.isEmpty(email1)||TextUtils.isEmpty(password)){
                   Toast.makeText(login.this,"please enter Email and password",Toast.LENGTH_SHORT).show();
               }
               else{
                   login1(email1,password);
               }
           }

       });


    }
    private  void login1(String email,String password){
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(login.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(login.this,"Login Successful",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
