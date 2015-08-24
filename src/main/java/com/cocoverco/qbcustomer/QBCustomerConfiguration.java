package com.cocoverco.qbcustomer;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class QBCustomerConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty
    private String emailRecipient;

    @NotEmpty
    private String emailHost;

    @NotEmpty
    private String emailPassword;

    @NotEmpty
    private String emailSender;

    //@JsonProperty tells dropwizard to reference the YAML file
    @JsonProperty
    public String getTemplate() { return template; }

    @JsonProperty
    public void setTemplate(String template) { this.template = template; }

    @JsonProperty
    public String getDefaultName() { return defaultName; }

    @JsonProperty
    public void setDefaultName(String name) { this.defaultName = name; }

    @JsonProperty
    public String getEmailRecipient() { return emailRecipient; }

    @JsonProperty
    public void setEmailRecipient(String name) { this.emailRecipient = name; }

    @JsonProperty
    public String getEmailHost() { return emailHost; }

    @JsonProperty
    public void setEmailHost(String name) { this.emailHost = name; }

    @JsonProperty
    public String getEmailPassword() { return emailPassword; }

    @JsonProperty
    public void setEmailPassword(String name) { this.emailPassword = name; }

    @JsonProperty
    public String getEmailSender() { return emailSender; }

    @JsonProperty
    public void setEmailSender(String name) { this.emailSender = name; }

}