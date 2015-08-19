package com.cocoverco.qbcustomer.core;

import com.cocoverco.qbcustomer.BillAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
//import com.sun.xml.internal.bind.v2.TODO;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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

    /*@XmlElement (name = "BillAddress", required = true, nillable = true)
    BillAddress billAddress;*/

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

    @XmlElement (name = "Comment", nillable = true)
    public String comment;

    public Customer() {

        // Jackson deserialization

        /*billAddress = new BillAddress();*/

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
                    String email_address,
                    String email_pref,
                    String telephone_pref,
                    String comment) {

        setFamiliarName("");

        setIsActive("");

        setCompanyName("");

        setSalutation("");

        setFirstName(first_name);

        setLastName(last_name);

        setAddr1(addr_1);

        setAddr2(addr_2);

        setCity(city);

        setState(state);

        setPostalCode(postal_code);

        setTelephoneNumber(telephone_number);

        setAltTelephoneNumber("");

        setEmailAddress(email_address);

        setEmailPref(email_pref);

        setTelephonePref(telephone_pref);

        setComment(comment);

        setFullName("");

        setAccountNumber("");

        setCreditLimit("");

    }

    //TODO - Explore possible call to optional value to avoid coded XML (e.g. Phone_Pref)

    @XmlTransient
    public void setFamiliarName(String value) { familiar_name = value; }

    public String getFamiliarName() { return familiar_name; }

    @XmlTransient
    public void setIsActive(String value) { is_active = value; }

    public String getIsActive() { return is_active; }

    @XmlTransient
    public void setCompanyName(String value) { company_name = value; }

    public String getCompanyName() { return company_name; }

    @XmlTransient
    public void setSalutation(String value) { salutation = value; }

    public String getSalutation() { return salutation; }

    @XmlTransient
    public void setFirstName(String value) { first_name = value; }

    public String getFirstName() { return first_name; }

    @XmlTransient
    public void setLastName(String value) { last_name = value; }

    public String getLastName() { return last_name; }

    @XmlTransient
    public void setAddr1(String value) { addr_1 = value; }

    public String getAddr1() { return addr_1; }

    @XmlTransient
    public void setAddr2(String value) { addr_2 = value; }

    public String getAddr2() { return addr_2; }

    @XmlTransient
    public void setCity(String value) { city = value; }

    public String getCity() { return city; }

    @XmlTransient
    public void setState(String value) { state = value; }

    public String getState() { return state; }

    @XmlTransient
    public void setPostalCode(String value) { postal_code = value; }

    public String getPostalCode() { return postal_code; }

    @XmlTransient
    public void setTelephoneNumber(String value) { telephone_number = value; }

    public String getTelephoneNumber() { return telephone_number; }

    @XmlTransient
    public void setAltTelephoneNumber(String value) {
        //If no value was provided, make the value empty
        /*if(value.equals("") || value.equals(null))
                alt_telephone_number = "";
         else {
            alt_telephone_number = value;
        }*/

        alt_telephone_number = setEmptyString(value);
    }

    public String getAltTelephoneNumber() { return this.alt_telephone_number; }

    @XmlTransient
    public void setEmailAddress(String value) { email_address = value; }

    public String getEmailAddress() { return email_address; }

    @XmlTransient
    public void setFullName(String value) { full_name = value; }

    public String getFullName() { return full_name; }

    @XmlTransient
    public void setAccountNumber(String value) { account_number = value; }

    public String getAccountNumber() { return account_number; }

    @XmlTransient
    public void setCreditLimit(String value) { credit_limit = value; }

    public String getCreditLimit() { return credit_limit; }

    @XmlTransient
    public void setEmailPref(String value) { email_pref = value; }

    public String getEmailPref() { return email_pref; }

    @XmlTransient
    public void setTelephonePref(String value) { telephone_pref = value; }

    public String getTelephonePref() { return telephone_pref; }

    @XmlTransient
    public void setComment(String value) { comment = value; }

    public String getComment() { return comment; }

    private String setEmptyString(String value) {

        String str;

        //If no value was provided, make the value empty
        if(value.equals("") || value.length() == 0 || value == null) {
            str = "";
        } else {
            str = value;
        }

        return str;
    }

}