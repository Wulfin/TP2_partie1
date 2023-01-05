package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public static int access;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button okButton = findViewById(R.id.OKBtn);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(LoginActivity.access);
                EditText editTextUser = findViewById(R.id.editTextUser);
                EditText editTextPassword = findViewById(R.id.editTextPassword);
                String user = editTextUser.getText().toString();
                String password = editTextPassword.getText().toString();
                if (user.compareTo("a") == 0 && password.compareTo("a") == 0){
                    LoginActivity.access = 1;
                }
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
        Button cancelButton = findViewById(R.id.CancelBtn);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }
}