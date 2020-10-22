package com.corona.coronazp20t;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USERNAME_REGEX_PATTERN="^[A-Za-z]{3,20}$";

    public static boolean isValidUsername(String username) {

        Pattern pattern=Pattern.compile(USERNAME_REGEX_PATTERN); //kuriamas sablonas pagal musu stringa
        Matcher matcher=pattern.matcher(username); //palyginamos sablonas su vartotojo ivestais duomenimis

        return matcher.find(); //grazina true jeigu atitinka, false priesingu atveju
    }
}
