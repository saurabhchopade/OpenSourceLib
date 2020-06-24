package com.bridelabz.opensourcelibraries.util;
import com.opencsv.bean.CsvBindByPosition;

public class OpenCsv {
    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private String email;

    @CsvBindByPosition(position = 2)
    private String phoneNo;

    @CsvBindByPosition(position = 3)
    private String country;

    public String getName()
    {
        return this.name;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getPhoneNo()
    {
        return this.phoneNo;
    }
    public String getCountry()
    {
        return this.country;
    }
}
