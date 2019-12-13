package com.example.foodrecommended_asd;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountSignupTest {

    @Test
    public void getPassword() {
        String expected = "test";
        String output;

        AccountSignup getPass = new AccountSignup("test", "test@gmail.com");
        output = getPass.getPassword();

        assertEquals(expected, output);
    }

    @Test
    public void setPassword() {
        String expected = "test";
        String output;

        AccountSignup setPass = new AccountSignup();
        setPass.setPassword("test");

        output = setPass.getPassword();

        assertEquals(expected, output);
    }

    @Test
    public void setCheckPass() {
        String expected = "test1";
        String output;

        AccountSignup checkPass = new AccountSignup();
        checkPass.setCheckPass("test1");
        output = checkPass.getCheckPass();

        assertEquals(expected, output);

    }

    @Test
    public void getCheckPass() {
        String expected = "test1";
        String output;

        AccountSignup checkPass = new AccountSignup();
        checkPass.setCheckPass("test1");

        output = checkPass.getCheckPass();

        assertEquals(expected, output);
    }

    @Test
    public void checkPassword() {
        boolean expected = true;
        boolean outcome;

        AccountSignup firstPass = new AccountSignup("test", "test@gmail.com");
        firstPass.setCheckPass("test");

        if (firstPass.getPassword().length() == 0 || firstPass.getCheckPass().length() == 0){
            outcome = false;
        }
        else {
            for (int i = 0; i < firstPass.getPassword().length(); i++) {
                if (firstPass.getPassword().charAt(i) != firstPass.getCheckPass().charAt(i)) {
                    outcome = false;
                }
            }
            outcome = true;
        }

        assertEquals(expected, outcome);
    }
}