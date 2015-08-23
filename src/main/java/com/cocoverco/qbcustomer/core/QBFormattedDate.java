package com.cocoverco.qbcustomer.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Russ on 8/22/2015.
 */
public class QBFormattedDate {

    private String dateString;

    public QBFormattedDate(){

        Date today;
        String output = "";
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat("MMddyyyy_hhmm");
        today = new Date();
        try {
            output = formatter.format(today);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDateString(output);

    }

    public QBFormattedDate(Date dt){

        String output = "";
        SimpleDateFormat formatter;


        formatter = new SimpleDateFormat("MMddyyyy_hhmm");
        try {
            output = formatter.format(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDateString(output);

    }

    public QBFormattedDate(String str) {

        Date today;
        String output = "";
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat(str);
        today = new Date();
        try {
            output = formatter.format(today);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDateString(output);

    }

    public QBFormattedDate (Date dt, String str){

        String output = "";
        SimpleDateFormat formatter;


        formatter = new SimpleDateFormat(str);
        try {
            output = formatter.format(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDateString(output);

    }

    private void setDateString(String str){
        this.dateString = str;
    }

    public String getDateString() {
        return this.dateString;
    }
}
