package com.cocoverco.qbcustomer.core;

/**
 * Created by Russ on 8/21/2015.
 */
//import customer.data.Address;
//import customer.data.Customer;
//...
import com.cocoverco.qbcustomer.BillAddress;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class TestCustomerXMLClient {
/*    public static final Logger logger =
            Logger.getLogger(TestCustomerXMLClient.class.getCanonicalName());

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        // Define the URL for testing the example application
        WebTarget webTarget =
                client.target("http://localhost:8080/customer/rest/Customer");

        // Test the POST method
        Customer customer = new Customer();
        BillAddress address = new BillAddress();
        customer.setCustomerBillAddress(address);

        customer.setFirstName("Duke");
        customer.setLastName("OfJava");
        address.setAddr1("Duke's Drive");
        address.setCity("JavaTown");
        address.setPostalCode("1234");
        address.setState("JA");
        customer.setEmailAddress("duke@java.net");
        customer.setTelephoneNumber("12341234");*/

/*        ClientResponse response =
                webTarget.type("application/xml").post(ClientResponse.class,
                        customer);

        logger.info("POST status: {0}" + response.getStatus());
        if (response.getStatus() == 201) {
            logger.info("POST succeeded");
        } else {
            logger.info("POST failed");
        }*/

 /*       // Test the GET method using content negotiation
        response = webResource.path("1").accept(MediaType.APPLICATION_XML)
                .get(ClientResponse.class);
        Customer entity = response.getEntity(Customer.class);

        logger.log(Level.INFO, "GET status: {0}", response.getStatus());
        if (response.getStatus() == 200) {
            logger.log(Level.INFO, "GET succeeded, city is {0}",
                    entity.getAddress().getCity());
        } else {
            logger.info("GET failed");
        }

        // Test the DELETE method
        response = webResource.path("1").delete(ClientResponse.class);

        logger.log(Level.INFO, "DELETE status: {0}", response.getStatus());
        if (response.getStatus() == 204) {
            logger.info("DELETE succeeded (no content)");
        } else {
            logger.info("DELETE failed");
        }*/

        /*response = webResource.path("1").accept(MediaType.APPLICATION_XML)
                .get(ClientResponse.class);
        logger.log(Level.INFO, "GET status: {0}", response.getStatus());
        if (response.getStatus() == 204) {
            logger.info("After DELETE, the GET request returned no content.");
        } else {
            logger.info("Failed, after DELETE, GET returned a response.");
        }*/

}