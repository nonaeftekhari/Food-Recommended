package com.example.foodrecommended_asd;

import android.webkit.JavascriptInterface;

public class AccountSignup {
    private String password;
    private String checkPass;
    private String email;

    private String[] AccInfo = new String[2];

    AccountSignup(){
        password = "null";
        email = "null";
    }

    AccountSignup(String pass, String e){
        password = pass;
        email = e;
    }

    String getEmail(){
        return email;
    }

    @JavascriptInterface
    public void setEmail(String e){
        email = e;
    }

    String getPassword(){
        return password;
    }

    void setPassword(String pass){
        password = pass;
    }

    void setCheckPass(String pass){
        checkPass = pass;
    }

    @JavascriptInterface
    public String getCheckPass(){
        return checkPass;
    }

    void setAccountInfo(String e, String p){
        AccInfo[0] = email;
        AccInfo[1] = password;
    }

    void addInfoToDB(){


    }

    @JavascriptInterface
    public boolean checkPassword(String pass1, String pass2){

        /*
        a simple change would be to user .equals()
        return pass1.equals(pass2)
         */
        if (pass1.length() == 0 || pass2.length() == 0){
            return false;
        }
        else {
            for (int i = 0; i < pass1.length(); i++) {
                if (pass1.charAt(i) != pass2.charAt(i)) {
                    return false;
                }
            }
            this.password = pass1;
            return true;
        }
    }

}

