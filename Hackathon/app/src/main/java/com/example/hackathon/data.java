package com.example.hackathon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class data {
    private String fname;
    private double fvalue;
    private int fprogress;
    private Date fdate;

    public data(String aName, double aValue){
        fname = aName;
        fvalue = aValue;
        fprogress = 0;
        String date = "01/01/2001";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            fdate = dateFormat.parse(date);
        }catch(ParseException e){}
    }

    public void addprogress(){
        fprogress++;
    }

    public void update(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            fdate = dateFormat.parse(date);
        }catch(ParseException e){}
    }

    public Date getFdate() {
        return fdate;
    }

    public void resetprogress(){fprogress = 0;}

    public void addvalue(double extra){
        fvalue = fvalue + extra;
    }

    public String getFname() {
        return fname;
    }

    public String getFvalue() {
        return Double.toString(fvalue);
    }

    public Integer getFprogress() {
        return fprogress;
    }
}
