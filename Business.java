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
public class Business {
    private String name;
    private String mantra;
    private ObservableList<Customer> customers;
    private ObservableList<Deliveries> completeDeliveries;
    private ObservableList<Services> offeredServices;
    private ObservableList<Deliveries> pendingDeliveries;
    
    private Business(String name, String mantra,ObservableList customers,ObservableList completeDeliveries,
            ObservableList offeredServices,ObservableList pendingDeliveries){
        setName(name);
        setMantra(mantra);
        setCustomers(customers);
        setOfferedServices(offeredServices);
        setPendingDeliveries(pendingDeliveries);
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMantra() {
        return mantra;
    }

    public void setMantra(String mantra) {
        this.mantra = mantra;
    }

    public ObservableList getCustomers() {
        return customers;
    }

    public void setCustomers(ObservableList customers) {
        this.customers = customers;
    }

    public ObservableList getCompleteDeliveries() {
        return completeDeliveries;
    }

    public void setCompleteDeliveries(ObservableList completeDeliveries) {
        this.completeDeliveries = completeDeliveries;
    }

    public ObservableList getOfferedServices() {
        return offeredServices;
    }

    public void setOfferedServices(ObservableList offeredServices) {
        this.offeredServices = offeredServices;
    }

    public ObservableList getPendingDeliveries() {
        return pendingDeliveries;
    }

    public void setPendingDeliveries(ObservableList pendingDeliveries) {
        this.pendingDeliveries = pendingDeliveries;
    }
}
