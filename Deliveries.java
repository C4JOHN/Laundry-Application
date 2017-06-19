/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryapplication;

import java.util.Date;

/**
 *
 * @author removevirus
 */
public class Deliveries {
 private String description;
 private Customer customer;
 private Double price;
 private String remarks;
 private Date dateDelivered;
 private Date dateOpened;
 
 private Deliveries(){
     
 }
 private Deliveries(String description,Customer customer,Double price, String remarks,Date dateDelivered,Date
         dateOpened){
     setDescription(description);
     setCustomer(customer);
     setPrice(price);
     setRemarks(remarks);
     setDateDelivered(dateDelivered);
     setDateOpened(dateOpened);
             }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Date dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = new Date();
    }
 
}
