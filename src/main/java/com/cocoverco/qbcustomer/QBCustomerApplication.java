package com.cocoverco.qbcustomer;

import com.cocoverco.qbcustomer.resources.QBCustomerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.cocoverco.qbcustomer.health.TemplateHealthCheck;
//...

//Application class with 'main' method.  Extends Application super class with Configuration parameter
public class QBCustomerApplication extends Application<QBCustomerConfiguration> {
    //psvm
    public static void main(String[] args) throws Exception {
        System.out.println("Start of QBCustomerApplication.main method");
        //Call local 'run' method.  Pass command line arguments (dropwizard YML file).  e.g. 'java -jar ... server cocoverco-service.yml'
        new QBCustomerApplication().run(args);
    }

    @Override
    public String getName() {
        return "cocoverco-service";
    }

    @Override
    public void initialize(Bootstrap<QBCustomerConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(QBCustomerConfiguration configuration,
                    Environment environment) {
        System.out.println("Inside QBCustomerApplication.run method");
        final QBCustomerResource resource = new QBCustomerResource(
                configuration.getTemplate(),
                configuration.getDefaultName(),
                configuration.getEmailSender(),
                configuration.getEmailHost(),
                configuration.getEmailPassword(),
                configuration.getEmailSender()
        );

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);

        }

}