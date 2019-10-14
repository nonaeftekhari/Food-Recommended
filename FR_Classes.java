package com.example.fr_classes;
import java.util.*;

public class FR_Classes {
    class User_Profile{
        int ID;
        String name;
        int age;
        String phoneNumber;

        User_Profile(String n, String num, int a){
            name = n;
            phoneNumber = num;
            age = a;
        }
        String getName(){
            return name;
        }

        void setName(String uN){
            name = uN;
        }

        String getPhoneNumber(){
            return phoneNumber;
        }

        void setPhoneNumber(String uS){
            phoneNumber = uS;
        }


    }

    class Restaurant_Profile{
        int resID;
        String resName;
        String resAddress;
        String resPhoneNum;

        Restaurant_Profile(String name, String address, String phone){
            resName = name;
            resAddress = address;
            resPhoneNum = phone;
        }

        void setName(String name){
            resName = name;
        }

        String getName(){
            return resName;
        }


    }
}
