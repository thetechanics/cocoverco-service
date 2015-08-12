package com.cocoverco.qbcustomer;

import com.cocoverco.qbcustomer.resources.QBCustomerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.cocoverco.qbcustomer.health.TemplateHealthCheck;

public class QBCustomerApplication extends Application<QBCustomerConfiguration> {
    public static void main(String[] args) throws Exception {
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
        final QBCustomerResource resource = new QBCustomerResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);

        }

}