package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CALL_Perm = 1;
    public static String challenge1;
    public static String challenge2;
    public static String url;
    public static int action = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////////////////////////////////////////////////////////////////////////////////

        EditText editTextUrl = findViewById(R.id.url);

        if (action == 1) {
            int intchallenge1 = Integer.parseInt(challenge1);
            int intchallenge2 = Integer.parseInt(challenge2);
            Bundle extras = getIntent().getExtras();
            int result = extras.getInt("result");

            if (result == (intchallenge1 + intchallenge2)) {
                Toast.makeText(getApplicationContext(), "Challenge Completed", Toast.LENGTH_SHORT).show();
                url = editTextUrl.getText().toString();
                if (url.isEmpty()) {
                    url = "https://www.emi.ac.ma/";
                } else if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }
                result = 0;
                action = 0;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            } else {
                action = 0;
                Toast.makeText(getApplicationContext(), "Fausse Somme", Toast.LENGTH_SHORT).show();

            }
        }

        ImageButton call = findViewById(R.id.call);
        EditText editTextPhoneNumber = findViewById(R.id.phone);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LoginActivity.access == 0)
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                else {
                    String phoneNumber = editTextPhoneNumber.getText().toString();
                    Uri phoneUri = Uri.parse("tel:" + phoneNumber);
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(phoneUri);
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_Perm);
                    } else {
                        startActivity(intent);
                    }
                    startActivity(intent);
                }
            }
        });

        ImageButton internet = findViewById(R.id.internet);
        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextch1 = findViewById(R.id.editTextCh1);
                challenge1 = editTextch1.getText().toString();
                EditText editTextch2 = findViewById(R.id.editTextCh2);
                challenge2 = editTextch2.getText().toString();
                action = 1;
                Intent intent = new Intent(MainActivity.this, CheckActivity.class);
                intent.putExtra("challenge1", challenge1);
                intent.putExtra("challenge2", challenge2);
                startActivity(intent);

            }
        });

        ImageButton desktop = findViewById(R.id.desktop);
        desktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent("login.ACTION");
                startActivity(loginIntent);
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

    @Override
    public boolean isFinishing() {
        return super.isFinishing();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL_Perm) { //check the permission type using the requestCode
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) //the array is empty if not granted
                Toast.makeText(this, "GRANTED CALL", Toast.LENGTH_SHORT).show();
        }
    }

}