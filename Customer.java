/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryapplication;

import javafx.collections.ObservableList;

/**
 *
 * @author removevirus
 */
public class Customer {

    private String name;
    private String phoneNumber;
    private String address;
    private ObservableList<Deliveries> deliveries;
    private Customer(){
        setName(null);
        setPhoneNumber(null);
        setAddress(null);
        setDeliveries(deliveries);
    }
    public Customer(String name, String phoneNumber,String address,ObservableList deliveries){
        setName(name);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setDeliveries(deliveries);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ObservableList<Deliveries> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(ObservableList<Deliveries> deliveries) {
        this.deliveries = deliveries;
    }
    
    
}
