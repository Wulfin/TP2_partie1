package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AutreLoginActivity extends AppCompatActivity {

    public static int access2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button okButton = findViewById(R.id.OKBtn2);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextUser = findViewById(R.id.editTextUser2);
                EditText editTextPassword = findViewById(R.id.editTextPassword2);
                String user = editTextUser.getText().toString();
                String password = editTextPassword.getText().toString();
                if (user.compareTo("a") == 0 && password.compareTo("a") == 0){
                    AutreLoginActivity.access2 = 1;
                }
                startActivity(new Intent(AutreLoginActivity.this, MainActivity.class));
            }
        });
        Button cancelButton = findViewById(R.id.CancelBtn2);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutreLoginActivity.this, MainActivity.class));
            }
        });
    }
}