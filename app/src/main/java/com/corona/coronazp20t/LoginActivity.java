package com.corona.coronazp20t;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //Atidaromas langas (tuscias)
        setContentView(R.layout.activity_login); //Pridek vaizda prie lango
        //Kodas rasomas nuo cia
        Button login=findViewById(R.id.login);//Susiejamas vaizde esantis elementas su kodu
        Button register=findViewById(R.id.register);
        final EditText username=findViewById(R.id.username);
        final EditText password=findViewById(R.id.password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToRegisterActivity);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cia rasomas kodas kuris vykdomas paspaudus mygtuka
                /*Toast.makeText(LoginActivity.this, "Prisijungimo vardas: "+
                        username.getText().toString()+"\nSlaptazodis: "+
                        password.getText().toString(), Toast.LENGTH_SHORT).show(); */
                if ((Validation.isValidUsername(username.getText().toString())) && (Validation.isValidPassword(password.getText().toString()))) {
                    //Ketinimas pereiti i paieskos langa                  is kur            i kur
                    Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);
                    startActivity(goToSearchActivity);
                }
                else { //jeigu blogas username
                    username.setError(getResources().getString(R.string.login_invalid_username));
                    password.setError(getResources().getString(R.string.login_invalid_username));
                    username.requestFocus();
                }
            }
        });
    }


}
