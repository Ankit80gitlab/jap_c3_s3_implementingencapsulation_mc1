package com.niit.courier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {
    // Declare the attributes that correspond to Address
    String name;
    int houseNo;
    String street;
    String city;
    String phoneNo;


    // This methods takes a phone no as a string and validates the phone number
    // The phone no must be in the format below
    //  +<area code><10 digit numbers> - +919776855678
    // or a 10 digit number - 9776855678


    public int isPhoneNoValid(String phone)
    {
        Pattern pattern = Pattern.compile("(\\W)?(91)?[0-9]{10}");
        Matcher matcher = pattern.matcher(phone);

        int res=0;

        if(matcher.matches())
        {
            res=1;
        }

        return res;
    }


    // Setter and getter methods


    public void setName (String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }



    // The method must return the address in the below format
    // Address [city=xxx,houseNo=xxx,name=xxx,phoneNo=xxx,street=xxx]


    // Parameterized constructor
    public Address(String name, int houseNo, String street, String city, String phoneNo) {
        // Initialize values here
        this.name=name;
        this.houseNo=houseNo;
        this.street=street;
        this.city=city;
        this.phoneNo=phoneNo;
    }

    public String toString ()
    {
        return ("Address ["+"city="+city+","+" houseNo="+houseNo+","+" name="+name+","+" phoneNo="+phoneNo+","+" street="+street+"]");
    }
}
