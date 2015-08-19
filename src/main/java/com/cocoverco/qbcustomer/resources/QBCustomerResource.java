package com.cocoverco.qbcustomer.resources;

import com.cocoverco.qbcustomer.core.Saying;
import com.cocoverco.qbcustomer.core.Customer;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
//import com.sun.xml.internal.bind.v2.TODO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

//@Path determines path to call the service (e.g. http://localhost:8080/cocoverco-service)
@Path("/cocoverco-service")
//@Produces indicates that the media type returned by the server.  In this case JSON
//!!! Working JSON resource return type:  @Produces(MediaType.APPLICATION_JSON)
//Jersey resource class to define the behavior for a specific URI.  e.g. <Base URL>/cocoverco-service
public class QBCustomerResource {
    //Declare template variable as String
    private final String template;
    //Declare defauultName variable as String
    private final String defaultName;
    //Declare counter variable as AtomicLong
    private final AtomicLong counter;

    //QBCustomerResource constructor that takes two String parameters
    public QBCustomerResource(String template, String defaultName) {
        //Define this instance of the 'template' variable as the parameter 'template'
        this.template = template;
        //Define this instance of the 'defaultName' variable as the parameter 'defaultName'
        this.defaultName = defaultName;
        //Define this instance of the 'counter' variable as a new AtomicLong object with an initial value of zero
        this.counter = new AtomicLong();
    }

    //??? The presence of the parameter in the method signature determines the presence of the value in the XML
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public Customer getCustomer(@FormParam("first_name") String first_name,
                                @FormParam("last_name") String last_name,
                                @FormParam("street_1") String addr_1,
                                @FormParam("street_2") String addr_2,
                                @FormParam("city") String city,
                                @FormParam("state") String state,
                                @FormParam("postal_code") String postal_code,
                                @FormParam("telephone_number") String telephone_number,
                                @FormParam("email_address") String email_address,
                                @FormParam("email_pref") String email_pref,
                                @FormParam("telephone_pref") String telephone_pref,
                                @FormParam("comment") String comment/*,
                                String name,
                                String is_active,
                                String company_name,
                                String salutation,
                                String alt_telephone_number,
                                String full_name,
                                String account_number,
                                String credit_limit*/){

        final Customer customer = new Customer();

        //customer.name = customer.getName();
        //customer.is_active = customer.getIsActive();
        //customer.company_name = customer.getCompanyName();
        //customer.salutation = customer.getSalutation();
        customer.first_name = first_name;
        customer.last_name = last_name;
        /*customer.billAddress.addr1 = addr_1;
        customer.billAddress.addr2 = addr_2;
        customer.billAddress.city = city;
        customer.billAddress.state = state;
        customer.billAddress.postal_code = postal_code;*/
        /* Commented out to make room for BillAddress class*/
        customer.addr_1 = addr_1;
         customer.addr_2 = addr_2;
        customer.city = city;
        customer.state = state;
        customer.postal_code = postal_code;
        customer.telephone_number = telephone_number;
        //customer.alt_telephone_number = customer.getAltTelephoneNumber();
        customer.email_address = email_address;
        //customer.full_name = customer.getFullName();
        //customer.account_number = customer.getAccountNumber();
        //customer.credit_limit = customer.getCreditLimit();
        customer.email_pref = email_pref;
        customer.telephone_pref = telephone_pref;
        customer.comment = comment;

        return customer;

    }


    //Use @POST for HTML form POST request (parameters not visible in URI)
    //@POST determs what method is executed when a POST request is submitted to the service
    //!!! Working JSON resource post type:  @POST
    //Jersey @FormParam paramter annotation requires '@Consumes("application/x-www-form-urlencoded"'
    @Consumes("application/x-www-form-urlencoded")
    // Use @GET for HTML form GET requests (parameters visible in URI)
    //@GET determines what method is executed when a GET request is submitted to the service
    // @GET
    //@Timed will generate a Jersey metric for the time spent in the method
    @Timed
    //The 'sayHello' method takes the 'first_name' parameter value from the client as well as an optional String parameter
    //@FormParam("first_name") captures the value of the 'first_name' parameter from the client POST request.
    //The incoming parameter is cast an an 'Optional' object, with a String constructor
    public Saying sayHello(@FormParam("first_name") Optional<String> name,
                           @FormParam("last_name") Optional<String> last_name,
                           @FormParam("street_1") Optional<String> street_1,
                           @FormParam("street_2") Optional<String> street_2,
                           @FormParam("city") Optional<String> city,
                           @FormParam("state") Optional<String> state,
                           @FormParam("postal_code") Optional<String> postal_code,
                           @FormParam("email_address") Optional<String> email_address,
                           @FormParam("email_pref") Optional<String> email_pref,
                           @FormParam("telephone_pref") Optional<String> telephone_pref,
                           @FormParam("comment") Optional<String> comment ) {
//    public Saying sayHello(@QueryParam("first_name") Optional<String> name) {
        //Define the String variable 'value' using the 'template' format provided in the constructor
        //??? - If parameter'name' is null, then use the defaultName parameter from the constructor ???
        //NOTE - To add field to the output, add a form parameter to the 'Saying' call (e.g. last_name)
        //add a String object (e.g. %s) to the template (e.g. cocoverco-service.yml) and an additional parameter to 'format' (e.g. last_name.or(""))
        final String value = String.format(template,
                name.or(defaultName),
                last_name.or(""),
                street_1.or(""));
        //Return a new Saying object to the client with an incremented counter and the formatted String 'value' variable
        return new Saying(counter.incrementAndGet(), value);

        //End sayHello method
    }

    /*To Do:  Implement Customer class
    //Can we create a CustomerString class, with a global variable and the build the class members with a series of methods?
    @POST
    @Timed
    public Customer toString(@QueryParam("first_name")), */

//End QBCustomerResource class
}