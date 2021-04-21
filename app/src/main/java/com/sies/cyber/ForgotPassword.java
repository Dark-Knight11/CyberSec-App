package com.sies.cyber;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class ForgotPassword extends AppCompatActivity {

    EditText forgot_password_email;
    ProgressBar progressBar;
    ImageButton forgot_password_button;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgot_password_email = findViewById(R.id.forgot_password_email);
        progressBar = findViewById(R.id.progressBarForgotPassword);
        forgot_password_button = findViewById(R.id.forgot_password_btn);

        mAuth = FirebaseAuth.getInstance();

        forgot_password_button.setOnClickListener(this::onClick);

    }

    private void onClick(View view) {

        final String email = forgot_password_email.getText().toString().trim();
        if (email.isEmpty()) {
            forgot_password_email.setError("Email Required");
            forgot_password_email.requestFocus();
        } else if (!email.endsWith("@siesgst.ac.in")) {
            forgot_password_email.setError("Please use a valid GST Email ID");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            forgot_password_email.setError("Enter a valid Email ID");
            forgot_password_email.requestFocus();
        } else {
            progressBar.setVisibility(View.VISIBLE);

            mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    progressBar.setVisibility(View.INVISIBLE);
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Please check your Email!", Toast.LENGTH_SHORT).show();
                        forgot_password_email.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}