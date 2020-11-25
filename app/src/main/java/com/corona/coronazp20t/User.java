package com.corona.coronazp20t;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    //1. Objekto pozymiai(argumentai, kintamieji(vienas ir taspats))
    private String username;
    private String password;
    private String email;

    private SharedPreferences sharedPreferences;
    private static final String PREFERENCES_PACKAGE_NAME="com.corona.coronazp20t";
    private static final String USERNAME_KEY="username";
    private static final String PASSWORD_KEY="password";
    private static final String REMEMBER_ME_KEY="rememberMe";

    //2. Klases konstruktorius(konstruktoriai)
    //Sitas konstruktorius naudojamas registracijos
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    //kol kas buvo naudojamas prisijungimo lange(isvesti i ekrana vartotojo info)
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //jau dabar bus naudojamas prisijungimo lange perduodant konteksta-prisijungimo langa
    public User(Context context){
        this.sharedPreferences = context.getSharedPreferences(User.PREFERENCES_PACKAGE_NAME,
                Context.MODE_PRIVATE);
    }

    //3. Get'eriai ir Set'eriai
    public String getUsernameForRegistration() {
        return username;
    }
    public void setUsernameForRegistration(String username) {
        this.username = username;
    }

    public String getPasswordForRegistration() {
        return password;
    }
    public void setPasswordForRegistration(String password) {
        this.password = password;
    }

    public String getEmailForRegistration() {
        return email;
    }
    public void setEmailForRegistration(String email) {
        this.email = email;
    }

    public String getUsernameForLogin() {
        return this.sharedPreferences.getString(USERNAME_KEY,"");
    }
    public void setUsernameForLogin(String username) {
        this.sharedPreferences.edit().putString(USERNAME_KEY,username).commit();
    }

    public String getPasswordForLogin() {
        return this.sharedPreferences.getString(PASSWORD_KEY,"");
    }
    public void setPasswordForLogin(String password) {
        this.sharedPreferences.edit().putString(PASSWORD_KEY,password).commit();
    }

    public boolean isRememberedMeForLogin() {
        return sharedPreferences.getBoolean(REMEMBER_ME_KEY,false);
    }
    public void setRememberedMeForLogin(boolean rememberMe) {
        this.sharedPreferences.edit().putBoolean(REMEMBER_ME_KEY,rememberMe).commit();
    }
}
