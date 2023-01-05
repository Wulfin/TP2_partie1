package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PersoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso);
        Button fakeButton = findViewById(R.id.QUITTERPerso);
        fakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersoActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFECYCLE ", getLocalClassName() + " : ici onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFECYCLE ", getLocalClassName() + " : ici onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFECYCLE ", getLocalClassName() + " : ici onDestroy");
        System.exit(0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFECYCLE ", getLocalClassName() + " : ici onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFECYCLE ", getLocalClassName() + " : ici onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFECYCLE ", getLocalClassName() + " : ici onRestart");
    }

}