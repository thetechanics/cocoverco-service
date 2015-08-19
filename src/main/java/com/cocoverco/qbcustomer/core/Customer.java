package com.cocoverco.qbcustomer.core;

import com.cocoverco.qbcustomer.BillAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
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

    @XmlElement (name = "BillAddress", required = true, nillable = true)
    public BillAddress customer_bill_address;

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

    @XmlElement (name = "ContactPref", required = true, nillable = true)
    public String contact_pref;

    @XmlElement (name = "Comment", nillable = true)
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
                    BillAddress bill_address,
                    String telephone_number,
                    String email_address,
                    String contact_pref,
                    String comment) {

        setCustomerBillAddress(bill_address);

        setFamiliarName("");

        setIsActive("");

        setCompanyName("");

        setSalutation("");

        setFirstName(first_name);

        setLastName(last_name);

        setCustomerBillAddress(bill_address);

        setTelephoneNumber(telephone_number);

        setAltTelephoneNumber("");

        setEmailAddress(email_address);

        setContactPref(contact_pref);

        setComment(comment);

        setFullName("");

        setAccountNumber("");

        setCreditLimit("");

        //TODO - Put empty form values in array, iterate through to set variables to ""


    }

    //TODO - Explore possible call to optional value to avoid coded XML (e.g. Phone_Pref)

    @XmlTransient
    public void setFamiliarName(String value) { this.familiar_name = setEmptyString(value); }

    public String getFamiliarName() { return this.familiar_name; }

    @XmlTransient
    public void setIsActive(String value) { this.is_active = setEmptyString(value); }

    public String getIsActive() { return this.is_active; }

    @XmlTransient
    public void setCompanyName(String value) { this.company_name = setEmptyString(value); }

    public String getCompanyName() { return this.company_name; }

    @XmlTransient
    public void setSalutation(String value) { this.salutation = setEmptyString(value); }

    public String getSalutation() { return this.salutation; }

    @XmlTransient
    public void setFirstName(String value) { this.first_name = setEmptyString(value); }

    public String getFirstName() { return this.first_name; }

    @XmlTransient
    public void setLastName(String value) { this.last_name = setEmptyString(value); }

    public String getLastName() { return this.last_name; }

    @XmlTransient
    public void setTelephoneNumber(String value) { this.telephone_number = setEmptyString(value); }

    public String getTelephoneNumber() { return this.telephone_number; }

    @XmlTransient
    public void setAltTelephoneNumber(String value) { this.alt_telephone_number = setEmptyString(value); }

    public String getAltTelephoneNumber() { return this.alt_telephone_number; }

    @XmlTransient
    public void setEmailAddress(String value) { this.email_address = setEmptyString(value); }

    public String getEmailAddress() { return this.email_address; }

    @XmlTransient
    public void setFullName(String value) { this.full_name = setEmptyString(value); }

    public String getFullName() { return this.full_name; }

    @XmlTransient
    public void setAccountNumber(String value) { this.account_number = setEmptyString(value); }

    public String getAccountNumber() { return this.account_number; }

    @XmlTransient
    public void setCreditLimit(String value) { this.credit_limit = setEmptyString(value); }

    public String getCreditLimit() { return this.credit_limit; }

    @XmlTransient
    public void setContactPref(String value) { this.contact_pref = setEmptyString(value); }

    public String getContactPref() { return this.contact_pref; }

    @XmlTransient
    public void setComment(String value) { this.comment = setEmptyString(value); }

    public String getComment() { return this.comment; }

    public void setCustomerBillAddress(BillAddress value) { this.customer_bill_address = value; }

    public BillAddress getCustomerBillAddress() { return this.customer_bill_address; }

    private String setEmptyString(String value) {

        String str;

        //If no value was provided, make the value empty
        if(value.equals("") || value.length() == 0 ) {
            str = "";
        } else {
            str = value;
        }

        return str;
    }

}