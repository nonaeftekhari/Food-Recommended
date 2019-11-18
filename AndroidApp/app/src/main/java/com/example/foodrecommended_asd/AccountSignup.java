package com.example.foodrecommended_asd;

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

    void setEmail(String e){
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

    String getCheckPass(){
        return checkPass;
    }



    void setAccountInfo(String e, String p){
        AccInfo[0] = email;
        AccInfo[1] = password;
    }

    void addInfoToDB(){


    }

    boolean checkPassword(String pass1, String pass2){
        for (int i = 0; i < pass1.length(); i++){
            if(pass1.charAt(i) != pass2.charAt(i)){
                return false;
            }

        }

        return true;
    }

}

