package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        String challenge1 = getIntent().getExtras().getString("challenge1");
        String challenge2 = getIntent().getExtras().getString("challenge2");

        TextView textViewCh1 = findViewById(R.id.textviewCh1);
        textViewCh1.setText(challenge1);
        TextView textViewCh2 = findViewById(R.id.textviewCh2);
        textViewCh2.setText(challenge2);

        Button cancel = findViewById(R.id.CancelCh);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Opération annulée", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CheckActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button confirmBtn = findViewById(R.id.confirmChBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result;
                EditText editTextSum = findViewById(R.id.editTextSomme);
                int userSum = Integer.parseInt(editTextSum.getText().toString());
                result = userSum;
                Intent intent = new Intent(CheckActivity.this, MainActivity.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });

    }
}