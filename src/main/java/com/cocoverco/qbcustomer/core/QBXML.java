package com.cocoverco.qbcustomer.core;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
/**
 * Created by Russ on 8/21/2015.
 */
//...

//@XmlRootElement
public class QBXML {

    public QBXML(){}

    /*public QBXML(CustomerMsgsRq value){
        setCustomerMsgsRq(value);
    }

    private CustomerMsgsRq customerMsgsRq;

//    @XmlElement
    protected void setCustomerMsgsRq(CustomerMsgsRq value){
        customerMsgsRq = value;
    }*/

    /*private CustomerAddRq customerAddRq;

    static class CustomerAddRq {}

    //2nd level wrapper
    static class CustomerMsgsRq{

        //create 3rd level wrapper
        @XmlElement(name = "CustomerAddRq")
        private CustomerAddRq customerAddRq;

        public CustomerAddRq getCustomerAddRq() {
            return customerAddRq;
        }
    }

    //set method for 3rd level wrapper
    @XmlElement(name = "CustomerMsgsRq")
    private void setCustomerAddRq(CustomerMsgsRq customerMsgsRq) {
        customerAddRq = customerMsgsRq.getCustomerAddRq()
    }*/

}
