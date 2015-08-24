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

/** Customer class intended to represent customer details for marshalling into XML
 * and formatted for import into QuickBooks.
 *@author Russ Noftz 2015
 */
@XmlRootElement(name = "QBXML")
public class Customer {

    /**
     * Zero parameter constructor for Customer class
     *
     *
     */
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

    /**
     * Constructor for Customer class
     *
     * @param   first_name          The customer's first (given) name
     * @param   last_name           The customer's last (surname) name
     * @param   bill_address        A BillAddress object representing the customer's mailing address
     * @param   telephone_number    The customer's telephone number
     * @param   email_address       The customer's email address
     * @param   contact_pref        The customer's contact preference ('email' or 'telephone')
     * @param   comment             Comment text as defined by the customer
     * @see     BillAddress
     */
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

    }//End Customer(String, String, BillAddress, String, String, String, String)


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


    /**
     * Sets the value of the familiar_name member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setFamiliarName(String value) { this.familiar_name = setEmptyString(value); }

    /**
     * Gets the value of the familiar_name member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getFamiliarName() { return this.familiar_name; }

    /**
     * Sets the value of the is_active member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setIsActive(String value) { this.is_active = setEmptyString(value); }

    /**
     * Gets the value of the is_active member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getIsActive() { return this.is_active; }

    /**
     * Sets the value of the company_name member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setCompanyName(String value) { this.company_name = setEmptyString(value); }

    /**
     * Gets the value of the company_name member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getCompanyName() { return this.company_name; }

    /**
     * Sets the value of the salutation nmember variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setSalutation(String value) { this.salutation = setEmptyString(value); }

    /**
     * Gets the value of the salutation member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getSalutation() { return this.salutation; }

    /**
     * Sets the value of the first_name member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setFirstName(String value) { this.first_name = setEmptyString(value); }

    /**
     * Gets the value of the first_name member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getFirstName() { return this.first_name; }

    /**
     * Sets the value of the last_name member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setLastName(String value) { this.last_name = setEmptyString(value); }

    /**
     * Gets the value of the last_name member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getLastName() { return this.last_name; }

    /**
     * Sets the value of the customer_bill_adddress member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setCustomerBillAddress(BillAddress value) { this.customer_bill_address = value; }

    /**
     * Gets the value of the customer_bill_address member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    BillAddress getCustomerBillAddress() { return this.customer_bill_address; }

    /**
     * Sets the value of the telephone_number member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setTelephoneNumber(String value) { this.telephone_number = setEmptyString(value); }

    /**
     * Gets the value of the telephone_number member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getTelephoneNumber() { return this.telephone_number; }

    /**
     * Sets the value of the alt_telephone_number member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setAltTelephoneNumber(String value) { this.alt_telephone_number = setEmptyString(value); }

    /**
     * Gets the value of the alt_telephone_number member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getAltTelephoneNumber() { return this.alt_telephone_number; }

    /**
     * Sets the value of the email_address member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setEmailAddress(String value) { this.email_address = setEmptyString(value); }

    /**
     * Gets the value of the email_adddress member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getEmailAddress() { return this.email_address; }

    /**
     * Sets the value of the full_name member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setFullName(String value) { this.full_name = setEmptyString(value); }

    /**
     * Gets the value of the full_name member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getFullName() { return this.full_name; }

    /**
     * Sets the value of the account_number  member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setAccountNumber(String value) { this.account_number = setEmptyString(value); }

    /**
     * Gets the value of the account_number member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getAccountNumber() { return this.account_number; }

    /**
     * Sets the value of the credit_limit member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setCreditLimit(String value) { this.credit_limit = setEmptyString(value); }

    /**
     * Gets the value of the credit_limit member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getCreditLimit() { return this.credit_limit; }

    /**
     * Sets the value of the contact_pref member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setContactPref(String value) { this.contact_pref = setEmptyString(value); }

    /**
     * Gets the value of the contact_pref member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getContactPref() { return this.contact_pref; }

    /**
     * Sets the value of the comment member variable
     *
     * @param   value    A string representing the desired value
     */
    @XmlTransient
    void setComment(String value) { this.comment = setEmptyString(value); }

    /**
     * Gets the value of the comment member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    String getComment() { return this.comment; }

    /**
     * Sets the value of the current_date_string member variable
     *
     **/
    //@XmlTransient
    void setCurrentDate() {

        QBFormattedDate qbfd;
        qbfd = new QBFormattedDate("yyyyMMdd_HHmmss_SSS");
        //System.out.println("qbfd.getDateString() " + qbfd.getDateString());

        this.current_date_string = qbfd.getDateString();
        //System.out.println(this.current_date_string);

    }//end setCurrentDate method

    /**
     * Gets the value of the current_date_string member variable.
     *
     * @return  possible object is {@link String }
     *
     */
    public String getCurrentDate() { return this.current_date_string; }

    /**
     * Gets the value of all of the member variable formatted into a concatenated string.
     *
     * @return  possible object is {@link String }
     * @throws Exception
     *
     */
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

    /**
     * If the provided string is either empty or zero length, an empty string
     * is returned.  Any other string is returned unchanged.
     *
     * @param   value    A string representing the desired value
     */
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

}//End Customer class