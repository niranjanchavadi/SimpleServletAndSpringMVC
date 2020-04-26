package com.loginservlet.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static Pattern userName = Pattern.compile("^[A-Z][a-z]{2,}$");
    private static Pattern firstrName = Pattern.compile("^[A-Z][a-z]{2,}$");
    private static Pattern lastName = Pattern.compile("^[A-Z][a-z]{2,}$");
    private static Pattern validPhoneNumber = Pattern.compile("^[1-9][0-9]{9}$");
    private static Pattern email = Pattern.compile("^\\w+[\\+\\.\\w-]*@([\\w-]+\\.)*\\w+[\\w-]*\\.([a-z]{2,4}|\\d+)$");
    private static Pattern passwords = Pattern.compile("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!*]).{8,40})");

    public static boolean validateUserName(String userName) {

        Matcher matcherObject = Validation.userName.matcher(userName);
        return matcherObject.matches();
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        Matcher matcherObject = validPhoneNumber.matcher(phoneNumber);
        return matcherObject.matches();
    }

    public static boolean validateEmail(String emails) {

        Matcher matcherObject = email.matcher(emails);
        return matcherObject.matches();
    }


    public static boolean validatePassword(String password) {
        Matcher matcherObject = passwords.matcher(password);
        return matcherObject.matches();
    }


    public static boolean validateLastName(String lastName) {

        Matcher matcherObject = Validation.lastName.matcher(lastName);
        return matcherObject.matches();
    }
    public static boolean validateFirstName(String firstName) {

        Matcher matcherObject = Validation.firstrName.matcher(firstName);
        return matcherObject.matches();
    }

}
