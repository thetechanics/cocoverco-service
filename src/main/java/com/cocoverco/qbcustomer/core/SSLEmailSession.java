package com.cocoverco.qbcustomer.core;



import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 * @author Pankaj
 * Code provided by Pankaj on February 9 2014 via JournalDev website
 */
public class SSLEmailSession {

    private final String toEmail;
    private final String host;
    private final String password;
    private final String fromEmail;

    public SSLEmailSession(){
        toEmail = "rnoftz@northwestern.edu"; // can be any email id
        host = "smtp.comcast.net";
        password = "c0oldeck"; // correct password for gmail id
        fromEmail = "rnoftz@comcast.net"; //requires valid gmail id
    }

    public SSLEmailSession(String to, String hst, String pwd, String from){

        toEmail = to; // can be any email id
        host = hst;
        password = pwd; // correct password for gmail id
        fromEmail = from; //requires valid gmail id
    }

    /**
     Outgoing Mail (SMTP) Server
     requires TLS or SSL: smtp.gmail.com (use authentication)
     Use Authentication: Yes
     Port for SSL: 465
     */
    public void getSSLSession(String filename) {
//        final String fromEmail = "rnoftz@comcast.net"; //requires valid gmail id
//        final String password = "c0oldeck"; // correct password for gmail id
//        final String toEmail = "rnoftz@northwestern.edu"; // can be any email id

        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", host); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");
        //EmailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");

        EmailUtil.sendAttachmentEmail(session,
                fromEmail,
                toEmail,
                "Web Submission w/Attachment",
                "Find attached the Quickbooks customer import file",
                filename);

        //EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");

    }

}