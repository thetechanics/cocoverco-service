// File Name SendFileEmail.java

package com.cocoverco.qbcustomer.core;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import com.dumbster.smtp.SimpleSmtpServer;

public class SendFileEmail
{

    private String recipient;
    private String sender;
    private String subject;
    private String message;
    private String filename;

    public SendFileEmail(){
        setRecipient("rnoftz@northwestern.edu");
        setSender("rnoftz@comcast.net");
        setSubject("Failure in sendEmail");
        setMessage("Empty constructor called for SendFileEmail.");
        setFileName("file.txt");

    //End SendFileEmail()
    }

    public SendFileEmail(String rec, String sndr, String sub, String msg, String fn) {

        setRecipient(rec);
        setSender(sndr);
        setSubject(sub);
        setMessage(msg);
        setFileName(fn);

    //End SendFileEmail(String, String, String)
    }

    private void setRecipient(String rec){ recipient = rec; }

    private String getRecipient() { return recipient; }

    private void setSender(String sndr){ sender = sndr; }

    private String getSender() { return sender; }

    private void setSubject(String sub) { subject = sub; }

    private String getSubject() { return subject; }

    private void setMessage(String msg) { message = msg; }

    private String getMessage() { return message; }

    private void setFileName(String fn) { filename = fn; }

    private String getFileName() { return filename; }


    public void sendEmailAttachment()
    {


        // Recipient's email ID needs to be mentioned.
        String to = getRecipient();

        // Sender's email ID needs to be mentioned
        String from = getSender();

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("imap.comcast.net", host);

        properties.setProperty("mail.user", "rnoftz@comcast.net");
        properties.setProperty("mail.password", "c0oldeck");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(getSender()));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(this.getRecipient()));

            // Set Subject: header field
            message.setSubject(getSubject());

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText(getMessage());

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = getFileName();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart );

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();

        //End catch exception
        }

    //End sendEmailAttachment
    }
}