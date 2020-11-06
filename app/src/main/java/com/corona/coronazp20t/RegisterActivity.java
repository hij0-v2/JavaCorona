package com.corona.coronazp20t;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username=findViewById(R.id.username);
        final EditText password=findViewById(R.id.password);
        final EditText email=findViewById(R.id.email);

        Button register_button=findViewById(R.id.register_button);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Validation.isValidUsername(username.getText().toString())) &&
                        (Validation.isValidPassword(password.getText().toString())) &&
                        (Validation.isValidEmail(email.getText().toString()))) {

                    Intent goToLoginActivity=new Intent(RegisterActivity.this,
                            LoginActivity.class);
                    startActivity(goToLoginActivity);

                    Toast.makeText(RegisterActivity.this,"Prisijungimo vardas: "+
                            username.getText().toString()+"\nSlaptazodis: "+
                            password.getText().toString()+"\nEmail: "+email.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                }
                if (!Validation.isValidEmail(email.getText().toString())) {
                    email.setError(getResources().getString(R.string.register_invalid_email));
                    email.requestFocus();
                }
                if (!Validation.isValidPassword(password.getText().toString())) {
                    password.setError(getResources().getString(R.string.register_invalid_password));
                    password.requestFocus();
                }
                if (!Validation.isValidUsername(username.getText().toString())) {
                    username.setError(getResources().getString(R.string.register_invalid_username));
                    username.requestFocus();
                }
            }
        });
    }
}