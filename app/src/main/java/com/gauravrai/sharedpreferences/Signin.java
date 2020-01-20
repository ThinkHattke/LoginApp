package com.gauravrai.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    TextView register;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(!(userName.isEmpty() || pass.isEmpty())) {

                    String savedUsername = sharedpreferences.getString(USERNAME,"");
                    String savedPassword = sharedpreferences.getString(PASSWORD, "");

                    if(userName.equals(savedUsername) && pass.equals(savedPassword)) {
                        startActivity(new Intent(Signin.this, MainActivity.class));
                    } else {
                        Toast.makeText(Signin.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Signin.this,"Please enter user name or password to continue",Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signin.this, Signup.class));
            }
        });

    }
}
