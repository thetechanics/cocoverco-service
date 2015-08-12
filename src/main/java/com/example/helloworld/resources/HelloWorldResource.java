package com.example.helloworld.resources;

import com.example.helloworld.core.Saying;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
//import com.sun.xml.internal.bind.v2.TODO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

//@Path determines path to call service (e.g. http://localhost:8080/cocoverco-service)
@Path("/cocoverco-service")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("first_name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }

    /*To Do:  Implement Customer class
    @POST
    @Timed
    public Customer*/
}