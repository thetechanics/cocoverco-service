package com.cocoverco.qbcustomer.core;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType name defaults to root element "QBXML"
@XmlType(name = "CustomerAdd", propOrder = {
        "familiar_name",
        "is_active",
        "company_name",
        "salutation",
        "first_name",
        "last_name",
        "customer_bill_address",
        "telephone_number",
        "alt_telephone_number",
        "email_address",
        "full_name",
        "account_number",
        "credit_limit",
        "contact_pref",
        "comment",
        "current_date_string"
})
@XmlRootElement(name = "QBXML")
public class Customer {

    //The property order determines the XML field order
    @XmlElement (name = "Name", nillable = true)
    private String familiar_name;

    @XmlElement (name = "IsActive", nillable = true)
    private String is_active;

    @XmlElement (name = "CompanyName", nillable = true)
    private String company_name;

    @XmlElement (name = "Salutation", nillable = true)
    private String salutation;

    @XmlElement (name = "FirstName", required = true)
    private String first_name;

    @XmlElement (name = "LastName", required = true)
    private String last_name;

    @XmlElement (name = "BillAddress", required = true)
    private BillAddress customer_bill_address;

    @XmlElement (name = "Phone", nillable = true)
    private String telephone_number;

    @XmlElement (name = "AltPhone", nillable = true)
    private String alt_telephone_number;

    @XmlElement (name = "Email", nillable = true)
    private String email_address;

    @XmlElement (name = "FullName", nillable = true)
    private String full_name;

    @XmlElement (name = "AcctNumber", nillable = true)
    private String account_number;

    @XmlElement (name = "CreditLimit", nillable = true)
    private String credit_limit;

    @XmlElement (name = "ContactPref", nillable = true)
    private String contact_pref;

    @XmlElement (name = "Comment", nillable = true)
    private String comment;

    @XmlElement (name = "CurrentDate", required = true)
    private String current_date_string;



    public Customer() {

        // Jackson deserialization

        setFamiliarName("");

        setIsActive("");

        setCompanyName("");

        setSalutation("");

        setAltTelephoneNumber("");

        setFullName("");

        setAccountNumber("");

        //setCreditLimit("");

        }//End Customer() constructor

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

        setCurrentDate();

    //End Customer(String, String, BillAddress, String, String, String, String)
    }

    @XmlTransient
    void setFamiliarName(String value) { this.familiar_name = setEmptyString(value); }

    String getFamiliarName() { return this.familiar_name; }

    @XmlTransient
    void setIsActive(String value) { this.is_active = setEmptyString(value); }

    String getIsActive() { return this.is_active; }

    @XmlTransient
    void setCompanyName(String value) { this.company_name = setEmptyString(value); }

    String getCompanyName() { return this.company_name; }

    @XmlTransient
    void setSalutation(String value) { this.salutation = setEmptyString(value); }

    String getSalutation() { return this.salutation; }

    @XmlTransient
    void setFirstName(String value) { this.first_name = setEmptyString(value); }

    String getFirstName() { return this.first_name; }

    @XmlTransient
    void setLastName(String value) { this.last_name = setEmptyString(value); }

    String getLastName() { return this.last_name; }

    @XmlTransient
    void setCustomerBillAddress(BillAddress value) { this.customer_bill_address = value; }

    BillAddress getCustomerBillAddress() { return this.customer_bill_address; }

    @XmlTransient
    void setTelephoneNumber(String value) { this.telephone_number = setEmptyString(value); }

    String getTelephoneNumber() { return this.telephone_number; }

    @XmlTransient
    void setAltTelephoneNumber(String value) { this.alt_telephone_number = setEmptyString(value); }

    String getAltTelephoneNumber() { return this.alt_telephone_number; }

    @XmlTransient
    void setEmailAddress(String value) { this.email_address = setEmptyString(value); }

    String getEmailAddress() { return this.email_address; }

    @XmlTransient
    void setFullName(String value) { this.full_name = setEmptyString(value); }

    String getFullName() { return this.full_name; }

    @XmlTransient
    void setAccountNumber(String value) { this.account_number = setEmptyString(value); }

    String getAccountNumber() { return this.account_number; }

    @XmlTransient
    void setCreditLimit(String value) { this.credit_limit = setEmptyString(value); }

    String getCreditLimit() { return this.credit_limit; }

    @XmlTransient
    void setContactPref(String value) { this.contact_pref = setEmptyString(value); }

    String getContactPref() { return this.contact_pref; }

    @XmlTransient
    void setComment(String value) { this.comment = setEmptyString(value); }

    String getComment() { return this.comment; }

   // @XmlTransient
    private void setCurrentDate() {



        QBFormattedDate qbfd;
        qbfd = new QBFormattedDate();
        //System.out.println("qbfd.getDateString() " + qbfd.getDateString());

        this.current_date_string = qbfd.getDateString();
        //System.out.println(this.current_date_string);

//        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hhmm");
//        Date dt = new Date();
//        this.current_date_string = dateFormat.format(dt);

    }//end setCurrentDate method

    public String getCurrentDate() { return this.current_date_string; }

    public String toString(){

        String str;
        str = "";

        try {
            str = new StringBuffer("First Name: ").append(this.first_name)
                    .append(", Last Name: ").append(this.last_name)
                    .append(", Bill Address: ").append(this.customer_bill_address.toString())
                    .append(", Telephone: ").append(this.telephone_number)
                    .append(", Email Address: ").append(this.email_address).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;
    }//End toString method

    private String setEmptyString(String value) {

        String str;

        //If no value was provided, make the value empty
        if(value.equals("") || value.length() == 0 ) {
            str = "";
        } else {
            str = value;
        }

        return str;
    }//End setEmptyString method

}