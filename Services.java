/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryapplication;

import javafx.util.Duration;

/**
 *
 * @author removevirus
 */
public class Services {
    private String name;
    private String description;
    private Double price;
    private Duration duration;
    
    public Services(String name,String description, Double price,Duration duration){
        setName(name);
        setDescription(description);
        setPrice(price);
        setDuration(duration);
    }public Services(){
        //
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
