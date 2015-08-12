package com.cocoverco.qbcustomer.resources;

import com.cocoverco.qbcustomer.core.Saying;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
//import com.sun.xml.internal.bind.v2.TODO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

//@Path determines path to call the service (e.g. http://localhost:8080/cocoverco-service)
@Path("/cocoverco-service")
//@Produces indicates that the media type returned by the server.  In this case JSON
@Produces(MediaType.APPLICATION_JSON)
//Jersey resource class to define the behavior for a specific URI.  e.g. <Base URL>/cocoverco-service
public class QBCustomerResource {
    //Declare template variable as String
    private final String template;
    //Declare defauultName variable as String
    private final String defaultName;
    //Declare counter variable as AtomicLong
    private final AtomicLong counter;

    //QBCustomerResource constructor that takes to String parameters
    public QBCustomerResource(String template, String defaultName) {
        //Define this instance of the 'template' variable as the parameter 'template'
        this.template = template;
        //Define this instance of the 'defaultName' variable as the parameter 'defaultName'
        this.defaultName = defaultName;
        //Define this instance of the 'counter' variable as a new AtomicLong object with an initial value of zero
        this.counter = new AtomicLong();
    }

    //Use @POST for HTML form POST request (parameters not visible in URI)
    //@POST determs what method is executed when a POST request is submitted to the service
    @POST
    //Jersey @FormParam paramter annotation requires '@Consumes("application/x-www-form-urlencoded"'
    @Consumes("application/x-www-form-urlencoded")
    // Use @GET for HTML form GET requests (parameters visible in URI)
    //@GET determines what method is executed when a GET request is submitted to the service
    // @GET
    //@Timed will generate a Jersey metric for the time spent in the method
    @Timed
    //The 'sayHello' method takes the 'first_name' parameter value from the client as well as an optional String parameter
    //@QueryParam("first_name") captures the value of the 'first_name' parameter sent by the client.
    public Saying sayHello(@FormParam("first_name") Optional<String> name) {
//    public Saying sayHello(@QueryParam("first_name") Optional<String> name) {
        //Define the String variable 'value' using the 'template' format provided in the constructor
        //??? - If parameter'name' is null, then use the defaultName parameter from the constructor ???
        final String value = String.format(template, name.or(defaultName));
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