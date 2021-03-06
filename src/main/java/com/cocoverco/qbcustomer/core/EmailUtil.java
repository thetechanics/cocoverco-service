package com.cocoverco.qbcustomer.core;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author Pankaj
 * @author Russ Noftz
 * Code provided by Pankaj on February 9 2014 via JournalDev website
 * Changes made as necessary to implement EmailUtil for QBCustomerResource
 */
public class EmailUtil {

    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(Session session, String toEmail, String subject, String body){
        try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("rnoftz@comcast.net", "NoReply-Comcast"));

            msg.setReplyTo(InternetAddress.parse("rnoftz@comcast.net", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Utility method to send email with attachment
     * @param session
     * @param fromEmail
     * @param toEmail
     * @param subject
     * @param body
     * @param filename
     */
    public static void sendAttachmentEmail(Session session, String fromEmail, String toEmail, String subject, String body, String filename){
        try{
            //Create mime message type for session
            MimeMessage msg = new MimeMessage(session);
            //Define message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            //Define sender of message
            msg.setFrom(new InternetAddress(fromEmail, "Russ Noftz"));
            //Define return email address
            msg.setReplyTo(InternetAddress.parse(fromEmail, false));
            //Define message subject
            msg.setSubject(subject, "UTF-8");
            //Define message send timestamp
            msg.setSentDate(new Date());
            //Define message recipient
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText(body);

            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();

            // Set text message body part to multi-part message
            multipart.addBodyPart(messageBodyPart);

            // Second part is attachment
            messageBodyPart = new MimeBodyPart();
            //String filename = "qb_customer_xml_20150823_153157_069.txt";
            DataSource source = new FileDataSource(filename);
            //Define data handler for attachment
            messageBodyPart.setDataHandler(new DataHandler(source));
            //Identify artifact to attache
            messageBodyPart.setFileName(filename);
            //Add attachment body part to multi-part message
            multipart.addBodyPart(messageBodyPart);

            // Add the multi-part content to the message
            msg.setContent(multipart);

            // Send message
            Transport.send(msg);
            System.out.println("EMail Sent Successfully with attachment!!");
        }catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}