package com.cocoverco.qbcustomer.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

import com.cocoverco.qbcustomer.core.*;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;


/*
TODO - Send Email with attachment

TODO - Implement USAddress interface

TODO - Get properties from config file (date format, email authentication details, etc.)

TODO - Define exception handling more specifically

TODO - Complete XML structure

TODO - Display thank you message to user and forward to Home

TODO - Add unit tests

TODO - Explore hosting server/database

TODO - Save data to database

TODO - Improve JavaScript validation

TODO - Impmlement equal and hashCode methods

TODO - Put empty form values in array, iterate through to set variables to ""
*/


/** QBCustomerResource  class implements jersey web service
 *@author Russ Noftz 2015
 */
//@Path determines URL path to call the service (e.g. <host>/cocoverco-service)
@Path("/cocoverco-service")
//Jersey resource class to define the behavior for a specific URI/Request type.  e.g. <Base URL>/cocoverco-service, GET
public class QBCustomerResource {
    //Declare template variable as String
    private final String template;
    //Declare defauultName variable as String
    private final String defaultName;
    //Declare counter variable as AtomicLong
    private final AtomicLong counter;

    /**
     * Constructor that accepts two string parameters for use in defining output template
     * and default user name (from YML file) if one is not provided.
     *
     * @param   template    A reference to a YML template file
     * @param   defaultName name defined in the YML file to be used if no name is provided from the client
     *
     * */
    public QBCustomerResource(String template, String defaultName) {
        //Define this instance of the 'template' variable as the parameter 'template'
        this.template = template;
        //Define this instance of the 'defaultName' variable as the parameter 'defaultName'
        this.defaultName = defaultName;
        //Define this instance of the 'counter' variable as a new AtomicLong object with an initial value of zero
        this.counter = new AtomicLong();
    }//End QBCustomerResource(String, String) constructor

    /**
     * Method that gets called from the web service when the client submits a POST request.  The method
     * pulls values from the POST request using the @FormParam annotations.  The method passes those through
     * to the Customer and BillAddress objects and the method writes the resulting XML to a date stamped file.
     * <p/>
     * Temporarily returns the de-serialized customer object back to the client as XML.  The intended behavior is
     * display a thank you message and return the user to the web site Home page
     *
     * @param   first_name  Value from the First Name field of the client form
     * @param   last_name   Value from the First Name field of the client form
     * @param   addr_1      Value from the First Name field of the client form
     * @param   addr_2      Value from the First Name field of the client form
     * @param   city        Value from the First Name field of the client form
     * @param   state       Value from the First Name field of the client form
     * @param   postal_code Value from the First Name field of the client form
     * @throws  javax.xml.bind.JAXBException
     * @throws  FileNotFoundException
     * @throws  IOException
     *
     * */
    //@POST annotation determines that this method will be called for client POST requests
    @POST
    //@Produces annotation determines the return format
    @Produces(MediaType.APPLICATION_XML)
    //@Timed will generate a Jersey metric for the time spent in the method
    @Timed
    //@FormParam annotation captures the form values from the client request
    public Customer getCustomer(@FormParam("first_name") String first_name,
                                @FormParam("last_name") String last_name,
                                @FormParam("street_1") String addr_1,
                                @FormParam("street_2") String addr_2,
                                @FormParam("city") String city,
                                @FormParam("state") String state,
                                @FormParam("postal_code") String postal_code,
                                @FormParam("telephone_number") String telephone_number,
                                @FormParam("email_address") String email_address,
                                @FormParam("contact_pref") String contact_pref,
                                @FormParam("comment") String comment){

        //Declare and define BillAddress object
        final BillAddress billAddress = new BillAddress(addr_1,
                addr_2,
                city,
                state,
                postal_code);

        //Declare and define Customer object (with BillAddress child)
        final Customer customer = new Customer(first_name,
                last_name,
                billAddress,
                telephone_number,
                email_address,
                contact_pref,
                comment);

        //Declare and define QBFormattedDate object
//        QBFormattedDate qbfd = new QBFormattedDate("yyyyMMdd_HHmmss_SSS");

        //Marshal Customer object and write to a file
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(Customer.class);
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            OutputStream os = new FileOutputStream( "cocoverco_test_" + qbfd.getDateString() + ".txt" );
            OutputStream os = new FileOutputStream( "qb_customer_xml_" + customer.getCurrentDate() + ".txt" );
            marshaller.marshal( customer, os );
            os.close();

        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Create attach XML to email and send
        SSLEmailSession session = new SSLEmailSession();
        session.getSSLSession();

        return customer;

    } //End getCustomer(String, String, String, String, String, String, String, String, String, String, String)

    /*
    //Commenting out GET response - Throws exception, fix as able
    //??? Consumes necessary?
    //@Consumes("application/x-www-form-urlencoded")
    //@GET annotation determines that this method will be called for client GET requests
    @GET
    //@Produces indicates the media type returned by the method.  JSON is returned in the next line.
    @Produces(MediaType.APPLICATION_JSON)
    //@Timed will generate a Jersey metric for the time spent in the method
    @Timed
    //The 'sayHello' method takes the 'first_name' parameter value from the client as well as an optional String parameter
    //@FormParam("first_name") captures the value of the 'first_name' parameter from the client POST request.
    //The incoming parameter is cast an an 'Optional' object, with a String constructor
    //Jersey @FormParam annotation requires '@Consumes("application/x-www-form-urlencoded"'
    public Saying sayHello(@FormParam("first_name") Optional<String> first_name,
                           @FormParam("last_name") Optional<String> last_name,
                           @FormParam("street_1") Optional<String> street_1,
                           @FormParam("street_2") Optional<String> street_2,
                           @FormParam("city") Optional<String> city,
                           @FormParam("state") Optional<String> state,
                           @FormParam("postal_code") Optional<String> postal_code,
                           @FormParam("telephone_number") Optional<String> telephone_number,
                           @FormParam("email_address") Optional<String> email_address,
                           @FormParam("email_pref") Optional<String> email_pref,
                           @FormParam("telephone_pref") Optional<String> telephone_pref,
                           @FormParam("comment") Optional<String> comment ) {
        //Define the String variable 'value' using the 'template' format provided in the constructor
        //NOTE - To add field to the output, ??? add a form parameter to the 'Saying' class (e.g. last_name) ???
        //and add a String object (e.g. %s) to the template (e.g. cocoverco-service.yml)
        //and an additional parameter to 'format' (e.g. last_name.or(""))

        String value;
        value = "";

        try {
            value = String.format(template,
                    first_name.or(defaultName),
                    last_name.or(""),
                    street_1.or(""),
                    street_2.or(""),
                    city.or(""),
                    postal_code.or(""),
                    email_address.or(""),
                    telephone_number.or(""),
                    comment.or("")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Return a new Saying object to the client with an incremented counter and the formatted String 'value' variable
        return new Saying(counter.incrementAndGet(),value);


    } //End sayHello method
    */



} //End QBCustomerResource class