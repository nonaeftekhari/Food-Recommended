package com.example.foodrecommended_asd;

import android.webkit.JavascriptInterface;

public class AccountSignup {
    private String password;
    private String checkPass;
    private String email;
    private String name;

    private String[] AccInfo = new String[2];

    AccountSignup(){
        password = "null";
        email = "null";
    }

    AccountSignup(String pass, String e){
        password = pass;
        email = e;
    }

    @JavascriptInterface
    public String getEmail(){
        return email;
    }

    @JavascriptInterface
    public void setEmail(String e){
        e.toLowerCase();
        email = e;
    }

    @JavascriptInterface
    public String getPassword(){
        return password;
    }

    @JavascriptInterface
    public void setPassword(String pass){
        password = pass;
    }

    @JavascriptInterface
    public void setCheckPass(String pass){
        checkPass = pass;
    }

    @JavascriptInterface
    public void setName(String n){ name = n;}

    @JavascriptInterface
    public String getName(){return name;}

    @JavascriptInterface
    public String getCheckPass(){
        return checkPass;
    }

    void setAccountInfo(String e, String p){
        AccInfo[0] = email;
        AccInfo[1] = password;
    }

    void addInfoToDB(String em, String pass){


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

    @JavascriptInterface
    public boolean properPassword(String pass){
        boolean passing = false;
        boolean length = false;
        boolean capital = false;

        for (int i = 0; i < pass.length(); i++){
            if (pass.charAt(i) >= 65 && pass.charAt(i) <= 95){
                capital = true;
            }
        }

        if (pass.length() <= 50 && pass.length() >= 8){
            length = true;
        }

        if (capital == true && length == true){
            passing = true;
            return passing;
        }
        else{
            passing = false;
            return passing;
        }
    }

}

