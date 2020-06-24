package com.bridelabz.opensourcelibraries.util;


import com.opencsv.bean.CsvBindByPosition;

public class MyUser {
    @CsvBindByPosition(position = 0)
    private String name;
    @CsvBindByPosition(position = 1)
    private String email;
    @CsvBindByPosition(position = 2)
    private String phoneNo;
    @CsvBindByPosition(position = 3)
    private String country;

    public MyUser()
    {

    }
    public MyUser(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;

    }


}
