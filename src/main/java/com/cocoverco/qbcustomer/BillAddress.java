/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.2-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.08.29 at 09:53:40 AM CEST 
//


package com.cocoverco.qbcustomer;

//import java.math.BigDecimal;
import javax.xml.bind.annotation.*;
//import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
//import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for USAddress complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="USAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zip" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *       &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" fixed="US" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
//...
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillAddress", propOrder = {
        "addr1",
        "addr2",
        "city",
        "state",
        "postal_code"
})
public class BillAddress {

    @XmlElement(name = "Addr1", required = true)
    protected String addr1;

    @XmlElement(name = "Addr2", required = true, nillable = true)
    protected String addr2;

    @XmlElement(name = "City", required = true)
    protected String city;

    @XmlElement(name = "State", required = true)
    protected String state;

    @XmlElement(name = "PostalCode", required = true)
    protected String postal_code;

/*    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String country;*/

    public BillAddress(String addr1,
                       String addr2,
                       String city,
                       String state,
                       String postal_code) {

        setAddr1(addr1);
        setAddr2(addr2);
        setCity(city);
        setState(state);
        setPostalCode(postal_code);

    //End BillAddress(String, String, String, String, String)
    }



    /**
     * Gets the value of the addr1 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddr1() {
        return addr1;
    }

    /**
     * Sets the value of the addr1 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    @XmlTransient
    public void setAddr1(String value) {
        this.addr1 = value;
    }

    /**
     * Gets the value of the addr2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddr2() {
        return addr2;
    }

    /**
     * Sets the value of the addr2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    @XmlTransient
    public void setAddr2(String value) {
        this.addr2 = value;
    }

    /**
     * Gets the value of the city property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    @XmlTransient
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    @XmlTransient
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the postal_code property.
     *
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal }
     *
     */
    public String getPostalCode() {
        return postal_code;
    }

    /**
     * Sets the value of the postal_code property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal }
     *
     */
    @XmlTransient
    public void setPostalCode(String value) {
        this.postal_code = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
/*    public String getCountry() {
        if (country == null) {
            return "US";
        } else {
            return country;
        }
    }*/

    /**
     * Sets the value of the country property.
     *
     * //@param value
     *     allowed object is
     *     {@link String }
     *
     */
    /*@XmlTransient
    public void setCountry(String value) {
        this.country = value;
    }*/


    public String toString(){

        return new StringBuffer("Street 1: ").append(this.addr1)
                .append(", Street 2: ").append(this.addr2)
                .append(", City: ").append(this.city)
                .append(", State: ").append(this.state)
                .append(", Postal Code: ").append(this.postal_code).toString();
    }

}
