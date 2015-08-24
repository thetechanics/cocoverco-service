package com.cocoverco.qbcustomer.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/** QBFormattedDate class intended to represent a formatted current date/time string.
 *@author Russ Noftz 2015
 */
public class QBFormattedDate {

    private String dateString;

    /**
     * Zero parameter constructor that defines the dateString member variable
     *
     * @throws  Exception
     *
     * */
    public QBFormattedDate(){

        Date today;
        String output = "";
        SimpleDateFormat formatter;

        formatter = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        today = new Date();
        try {
            output = formatter.format(today);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDateString(output);

    }

    /**
     * Constructor that accepts a Date object and defines the dateString member variable
     *
     * @param   dt  object for formatted date string
     * @throws  Exception
     *
     * */
    public QBFormattedDate(Date dt){

        String output = "";
        SimpleDateFormat formatter;


        formatter = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        try {
            output = formatter.format(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDateString(output);

    }

    /**
     * Constructor that accepts a String object, representing the desired date format
     * and defines the dateString member variable
     *
     * @param   str Representation of date format
     * @throws  Exception
     *
     * */
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

    /**
     * Constructor that accepts Date and String objects and defines the dateString member variable
     * using the provided Date and String.
     *
     * @param   dt  Date value for formatted string
     * @param   str String representation of desired data format
     * @throws Exception
     *
     * */
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

    /**
     * Sets the value of the dateString member variable
     *
     * @param   str A string representing the desired value
     */
    private void setDateString(String str){
        this.dateString = str;
    }

    /**
     * Gets the value of the dateString member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    public String getDateString() {
        return this.dateString;
    }
}
