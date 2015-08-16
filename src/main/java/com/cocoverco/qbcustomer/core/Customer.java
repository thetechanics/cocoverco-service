package com.cocoverco.qbcustomer.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    public String first_name;

    public String last_name;

    public String street_1;

    public String street_2;

    public String city;

    public String state;

    public String postal_code;

    public String email_address;

    public String email_pref;

    public String telephone_pref;

    public String comment;

    public Customer() {
        // Jackson deserialization
    }

    public Customer(String first_name,
                    String last_name,
                    String street_1,
                    String street_2,
                    String city,
                    String state,
                    String postal_code,
                    String email_pref,
                    String telephone_pref,
                    String comment) {
        this.first_name = first_name;
        this.last_name= last_name;
        this.street_1 = street_1;
        this.street_2 = street_2;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.email_pref = email_pref;
        this.telephone_pref = telephone_pref;
        this.comment = comment;
    }

    @JsonProperty
    public String getFirstName() { return first_name; }

    @JsonProperty
    public String getLastName() { return last_name; }

    @JsonProperty
    public String getStreet_1() { return street_1; }

    @JsonProperty
    public String getStreet_2() { return street_2; }

    @JsonProperty
    public String getCity() { return city; }

    @JsonProperty
    public String getState() { return state; }

    @JsonProperty
    public String getPostalCode() { return postal_code; }

    @JsonProperty
    public String getEmailAddress() { return email_address; }

    @JsonProperty
    public String getEmailPref() { return email_pref; }

    @JsonProperty
    public String getTelephonePref() { return telephone_pref; }

    @JsonProperty
    public String getComment() { return comment; }

}