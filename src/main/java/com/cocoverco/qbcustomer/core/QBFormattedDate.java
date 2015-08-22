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
        String output;
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat("MMddyyyy_hhmm");
        today = new Date();
        output = formatter.format(today);
        setDateString(output);

    }

    public QBFormattedDate(Date dt){

        String output;
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat("MMddyyyy_hhmm");
        output = formatter.format(dt);
        setDateString(output);

    }

    public QBFormattedDate(String str) {

        Date today;
        String output;
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat(str);
        today = new Date();
        output = formatter.format(today);
        setDateString(output);

    }

    public QBFormattedDate (Date dt, String str){

        String output;
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat(str);
        output = formatter.format(dt);
        setDateString(output);

    }

    private void setDateString(String str){
        this.dateString = str;
    }

    public String getDateString() {
        return this.dateString;
    }
}
