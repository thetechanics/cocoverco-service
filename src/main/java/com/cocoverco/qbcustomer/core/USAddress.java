package com.cocoverco.qbcustomer.core;

/** USAddress interface to represent person mailing address details for marshalling into XML
 *@author Russ Noftz 2015
 */
public interface USAddress {

    /**
     * Should return the value of the addr1 property.
     *
     * @return  possible object is {@link String }
     *
     */
    public String getAddr1();

    /**
     * Should return the value of the addr2 property.
     *
     * @return  possible object is {@link String }
     *
     */
    public String getAddr2();

    /**
     * Should return the value of the city property.
     *
     * @return  possible object is {@link String }
     *
     */
    public String getCity();

    /**
     * Should return the value of the state property.
     *
     * @return  possible object is {@link String }
     *
     */
    public String getState();

    /**
     * Should return the value of the postal_code property.
     *
     * @return  possible object is {@link String }
     *
     */
    public String getPostalCode();

    public String toString();

}