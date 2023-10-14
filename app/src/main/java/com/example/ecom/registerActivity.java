package com.example.ecom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecom.models.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class registerActivity extends AppCompatActivity {
    Button signUp;
    EditText email, password;
    TextView signIn;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        signUp = findViewById(R.id.button);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        signIn = findViewById(R.id.textView3);
        signIn.setOnClickListener(view -> startActivity(new Intent(registerActivity.this,
                loginActivity.class)));
        signUp.setOnClickListener(view -> {
            createUser();
            progressBar.setVisibility(View.VISIBLE);
        });
    }

    private void createUser() {
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Email not there", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Password not there", Toast.LENGTH_SHORT).show();
        }
        if(userPassword.length() < 6){
            Toast.makeText(this, "Password length less than 6", Toast.LENGTH_SHORT).show();
        }
        auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                UserModel userModel = new UserModel(userEmail, userPassword);
                String id = Objects.requireNonNull(task.getResult().getUser()).getUid();
                database.getReference().child("Users").child(id).setValue(userModel);
                progressBar.setVisibility(View.GONE);
                Toast.makeText(registerActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }else{
                progressBar.setVisibility(View.GONE);
                Toast.makeText(registerActivity.this, "Error:" + task.getException(),Toast.LENGTH_SHORT).show();
            }
        });{
        }
    }
}