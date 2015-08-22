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
        System.out.println("QBFD Constructor " + output);
        setDateString(output);

    }

    public QBFormattedDate(Date dt){

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hhmm");
        setDateString(dateFormat.format(dt));

    }

    public QBFormattedDate(String str) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(str);
        Date dt = new Date();
        setDateString(dateFormat.format(dt));

    }

    public QBFormattedDate (Date dt, String str){

        SimpleDateFormat dateFormat = new SimpleDateFormat(str);
        setDateString(dateFormat.format(dt));

    }

    private void setDateString(String str){
        this.dateString = str;
    }

    public String getDateString() {
        return this.dateString;
    }
}
