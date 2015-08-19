package com.cocoverco.qbcustomer.core;

import com.fasterxml.jackson.annotation.JsonProperty;
//import com.sun.xml.internal.bind.v2.TODO;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "QBXML")
public class Customer {

    //The property order determines the XML field order
    @XmlElement (name = "Name", required = true, nillable = true)
    public String familiar_name;

    @XmlElement (name = "IsActive", required = true, nillable = true)
    public String is_active;

    @XmlElement (name = "CompanyName", required = true, nillable = true)
    public String company_name;

    @XmlElement (name = "Salutation", required = true, nillable = true)
    public String salutation;

    @XmlElement (name = "FirstName", required = true)
    public String first_name;

    @XmlElement (name = "LastName", required = true)
    public String last_name;

    @XmlElement (name = "Addr1", required = true)
    public String addr_1;

    @XmlElement (name = "Addr2", required = true, nillable = true)
    public String addr_2;

    @XmlElement (name = "City", required = true)
    public String city;

    @XmlElement (name = "State", required = true)
    public String state;

    @XmlElement (name = "PostalCode", required = true)
    public String postal_code;

    @XmlElement (name = "Phone", required = true, nillable = true)
    public String telephone_number;

    @XmlElement (name = "AltPhone", required = true, nillable = true)
    public String alt_telephone_number;

    @XmlElement (name = "Email", required = true, nillable = true)
    public String email_address;

    @XmlElement (name = "FullName", required = true, nillable = true)
    public String full_name;

    @XmlElement (name = "AcctNumber", required = true, nillable = true)
    public String account_number;

    @XmlElement (name = "CreditLimit", required = true, nillable = true)
    public String credit_limit;

    @XmlElement (name = "EmailPref", required = true, nillable = true)
    public String email_pref;

    @XmlElement (name = "PhonePref", required = true, nillable = true)
    public String telephone_pref;

    @XmlElement (name = "Comment", required = true, nillable = true)
    public String comment;

    public Customer() {

        // Jackson deserialization

        setFamiliarName("");

        setIsActive("");

        setCompanyName("");

        setSalutation("");

        setAltTelephoneNumber("");

        setFullName("");

        setAccountNumber("");

        setCreditLimit("");

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

        this.familiar_name =  first_name + " " + last_name;
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
        this.full_name = familiar_name;
        this.account_number = "";
        this.credit_limit = "";
        this.telephone_pref = telephone_pref;
        this.comment = comment;
    }

    //TODO - Explore possible call optional value to avoid coded XML (e.g. Phone_Pref)

    @XmlTransient
    public void setFamiliarName(String str) { familiar_name = str; }

    public String getFamiliarName() { return familiar_name; }

    @XmlTransient
    public void setIsActive(String str) { is_active = str; }

    public String getIsActive() { return is_active; }

    @XmlTransient
    public void setCompanyName(String str) { company_name = str; }

    public String getCompanyName() { return company_name; }

    @XmlTransient
    public void setFirstName(String str) { first_name = str; }

    public String getFirstName() { return first_name; }

    @XmlTransient
    public void setLastName(String str) { last_name = str; }

    public String getLastName() { return last_name; }

    public String getAddr1() { return addr_1; }

    public String getAddr2() { return addr_2; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public String getPostalCode() { return postal_code; }

    public String getTelephoneNumber() { return telephone_number; }

    @XmlTransient
    public void setSalutation(String str) { salutation = str; }

    public String getSalutation() { return salutation; }

    @XmlTransient
    public void setAltTelephoneNumber(String str) { alt_telephone_number = str; }

    public String getAltTelephoneNumber() { return alt_telephone_number; }

    public String getEmailAddress() { return email_address; }

    @XmlTransient
    public void setFullName(String str) { full_name = str; }

    public String getFullName() { return full_name; }

    @XmlTransient
    public void setAccountNumber(String str) { account_number = str; }

    public String getAccountNumber() { return account_number; }

    @XmlTransient
    public void setCreditLimit(String str) { credit_limit = str; }

    public String getCreditLimit() { return credit_limit; }

    public String getEmailPref() { return email_pref; }

    public String getTelephonePref() { return telephone_pref; }

    public String getComment() { return comment; }

}