package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        String ch1 = extras.getString("ch1");
        String ch2 = extras.getString("ch2");

        setContentView(R.layout.activity_check);
        TextView textViewCh1 = findViewById(R.id.textviewCh1);
        textViewCh1.setText(ch1);
        TextView textViewCh2 = findViewById(R.id.textviewCh2);
        textViewCh2.setText(ch2);

        Button cancel = findViewById(R.id.CancelCh);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Opération annulée", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CheckActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button okbtn = findViewById(R.id.okChbtn);
        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result;
                EditText editTextSomme = findViewById(R.id.editTextSomme);
                int userSum = Integer.parseInt(editTextSomme.getText().toString());
                result = userSum;
                Intent intent = new Intent(CheckActivity.this, MainActivity.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });

    }
}