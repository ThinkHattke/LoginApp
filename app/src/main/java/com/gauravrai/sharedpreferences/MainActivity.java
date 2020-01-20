package com.gauravrai.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView hello;
    Button logout;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String USERNAME = "username";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.hello);
        logout = findViewById(R.id.logout);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String username = sharedpreferences.getString(USERNAME, "User");

        hello.setText("Hi, "+username);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Signin.class));
            }
        });

    }
}
