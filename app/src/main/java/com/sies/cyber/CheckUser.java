package com.sies.cyber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CheckUser extends AppCompatActivity {
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser mFbUser = mAuth.getCurrentUser();
        if (mFbUser!=null) {
            Toast.makeText(getApplicationContext(), "Logged In", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CheckUser.this, MainActivity.class));
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(), "Log In", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CheckUser.this, Sign_In.class));
            finish();

        }
    }
}