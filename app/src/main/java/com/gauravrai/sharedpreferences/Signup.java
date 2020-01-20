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

public class Signup extends AppCompatActivity {

    EditText username;
    EditText password;
    Button register;
    TextView login;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(!(userName.isEmpty() || pass.isEmpty())) {

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(USERNAME, userName);
                    editor.putString(PASSWORD, pass);
                    editor.commit();

                    Toast.makeText(Signup.this, "now sign in", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Signup.this, Signin.class));

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup.this, Signin.class));
            }
        });

    }
}
