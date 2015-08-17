package com.cocoverco.qbcustomer.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    //The property order determines the XML field order
    public String name;

    public String is_active;

    public String company_name;

    public String first_name;

    public String last_name;

    public String addr_1;

    public String addr_2;

    public String city;

    public String state;

    public String postal_code;

    public String telephone_number;

    public String salutation;

    public String alt_telephone_number;

    public String email_address;

    public String full_name;

    public String account_number;

    public String credit_limit;

    public String email_pref;

    public String telephone_pref;

    public String comment;

    public Customer() {
        // Jackson deserialization
    }

    public Customer(String first_name,
                    String last_name,
                    String addr_1,
                    String addr_2,
                    String city,
                    String state,
                    String postal_code,
                    String telephone_number,
                    String salutation,
                    String email_pref,
                    String telephone_pref,
                    String comment) {

        this.name =  first_name + " " + last_name;
        this.is_active = "1";
        this.first_name = first_name;
        this.last_name= last_name;
        this.addr_1 = addr_1;
        this.addr_2 = addr_2;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.telephone_number = telephone_number;
        this.salutation = salutation;
        this.alt_telephone_number = "";
        this.email_pref = email_pref;
        this.full_name = name;
        this.account_number = "";
        this.credit_limit = "";
        this.telephone_pref = telephone_pref;
        this.comment = comment;
    }

    @JsonProperty
    public String getName() { return name; }

    @JsonProperty
    public String getIsActive() { return is_active; }

    @JsonProperty
    public String getCompanyName() { return company_name; }

    @JsonProperty
    public String getFirstName() { return first_name; }

    @JsonProperty
    public String getLastName() { return last_name; }

    @JsonProperty
    public String getAddr1() { return addr_1; }

    @JsonProperty
    public String getAddr2() { return addr_2; }

    @JsonProperty
    public String getCity() { return city; }

    @JsonProperty
    public String getState() { return state; }

    @JsonProperty
    public String getPostalCode() { return postal_code; }

    @JsonProperty
    public String getTelephoneNumber() { return telephone_number; }

    @JsonProperty
    public String getSalutation() { return salutation; }

    @JsonProperty
    public String getAltTelephoneNumber() { return alt_telephone_number; }

    @JsonProperty
    public String getEmailAddress() { return email_address; }

    @JsonProperty
    public String getFullName() { return full_name; }

    @JsonProperty
    public String getAccountNumber() { return account_number; }

    @JsonProperty
    public String getCreditLimit() { return credit_limit; }

    @JsonProperty
    public String getEmailPref() { return email_pref; }

    @JsonProperty
    public String getTelephonePref() { return telephone_pref; }

    @JsonProperty
    public String getComment() { return comment; }

}