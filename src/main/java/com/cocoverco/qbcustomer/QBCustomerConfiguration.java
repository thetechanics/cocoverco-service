//Create this package under 'root/src/main/java'
package com.cocoverco.qbcustomer;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class QBCustomerConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    //@JsonProperty tells dropwizard to reference the YAML file
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    //@JsonProperty tells dropwizard to reference the YAML file
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    //@JsonProperty tells dropwizard to reference the YAML file
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    //@JsonProperty tells dropwizard to reference the YAML file
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}