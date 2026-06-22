package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(v -> {

            String userEmail = email.getText().toString().trim();
            String userPassword = password.getText().toString().trim();

            if (userEmail.isEmpty()) {
                email.setError("Email is required");
                email.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                email.setError("Enter valid email");
                email.requestFocus();
                return;
            }

            if (userPassword.isEmpty()) {
                password.setError("Password is required");
                password.requestFocus();
                return;
            }

            if (userEmail.equals("user@gmail.com")
                    && userPassword.equals("1234")) {

                Toast.makeText(MainActivity.this,
                        "Login Successful",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(
                        MainActivity.this,
                        HomeActivity.class);

                intent.putExtra("USERNAME", userEmail);
                startActivity(intent);

            } else {

                Toast.makeText(MainActivity.this,
                        "Invalid Email or Password",
                        Toast.LENGTH_LONG).show();

                password.setText("");
            }
        });
    }
}