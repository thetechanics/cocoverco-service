package com.cocoverco.qbcustomer.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Russ on 8/22/2015.
 */
public class QBFormatttedDate {

    public String QBFormattedDate(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hhmm");
        Date dt = new Date();
        return dateFormat.format(dt);

    }

    public String QBFormattedDate(Date dt){

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hhmm");
        return dateFormat.format(dt);

    }

    public String QBFormattedDate (Date dt, String str){

        SimpleDateFormat dateFormat = new SimpleDateFormat(str);
        return dateFormat.format(dt);

    }
}
