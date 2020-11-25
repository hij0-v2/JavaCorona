package com.corona.coronazp20t;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
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

        //bus sukurtas User klases objektas
        final User user = new User(LoginActivity.this);

        final CheckBox rememberMe=findViewById(R.id.rememberMe);
        rememberMe.setChecked(user.isRememberedMeForLogin());
        if(rememberMe.isChecked()) {
            username.setText(user.getUsernameForLogin(),TextView.BufferType.EDITABLE);
            password.setText(user.getPasswordForLogin(),TextView.BufferType.EDITABLE);
        } else {//jeigu nepachekintas
            username.setText("",TextView.BufferType.EDITABLE);
            password.setText("",TextView.BufferType.EDITABLE);
        }

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
                if ((Validation.isValidUsername(username.getText().toString())) &&
                        (Validation.isValidPassword(password.getText().toString()))) {

                    user.setUsernameForLogin(username.getText().toString());
                    user.setPasswordForLogin(password.getText().toString());
                    if(rememberMe.isChecked()){
                        user.setRememberedMeForLogin(true);
                    } else {
                        user.setRememberedMeForLogin(false);
                    }

                    //Ketinimas pereiti i paieskos langa                  is kur            i kur
                    Intent goToSearchActivity = new Intent(LoginActivity.this,
                            SearchActivity.class);
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
