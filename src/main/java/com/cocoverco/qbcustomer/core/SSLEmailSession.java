package com.cocoverco.qbcustomer.core;



import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 * @author Pankaj
 * @author Russ Noftz
 * Code provided by Pankaj on February 9 2014 via JournalDev website
 * Changes made as necessary to implement EmailUtil for QBCustomerResource
 */
public class SSLEmailSession {

    private final String toEmail;
    private final String host;
    private final String password;
    private final String fromEmail;

    /**
     * No parameter constructor
     */
    public SSLEmailSession(){
        toEmail = "rnoftz@northwestern.edu"; // can be any email id
        host = "smtp.comcast.net";
        password = "c0oldeck"; // correct password for gmail id
        fromEmail = "rnoftz@comcast.net"; //requires valid gmail id
    }

    /**
     * Multi-parameter constructor
     * @param to    Email recipient
     * @param hst   Email service host name
     * @param pwd   Email service password
     * @param from  Email sender
     */
    public SSLEmailSession(String to, String hst, String pwd, String from){

        //Recipient email address
        toEmail = to;
        //Email service host name
        host = hst;
        //Email service password
        password = pwd;
        //Sender email address
        fromEmail = from;
    }

    /**
     * Method to open session with email service and to call EmailUtil to send message.
     *requires TLS or SSL: smtp.gmail.com (use authentication)
     *Use Authentication: Yes
     *Port for SSL: 465
     */
    public void getSSLSession(String filename) {

        System.out.println("SSLEmail Start");
        //Instantiate Properties object
        Properties props = new Properties();
        //Populate properties as needed for email session
        props.put("mail.smtp.host", host); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port

        //Instantiate Authenticator object to log into email service
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        //Create active email session
        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");

        //Commented - Send email w/o attachment
        //EmailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");

        //Send email with attachment
        EmailUtil.sendAttachmentEmail(session,
                fromEmail,
                toEmail,
                "Web Submission w/Attachment",
                "Find attached the Quickbooks customer import file",
                filename);


    }

}