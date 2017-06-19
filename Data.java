/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;

/**
 *
 * @author removevirus
 */
public class Data {
    
    public static ObservableList<Services> servicesList;
    public static ObservableList<Customer> customersList;
    public Data(){
        
    }
    
     public static ObservableList<Services> getServices(){
       servicesList=FXCollections.observableArrayList();
       servicesList.addAll(
               new Services("Washing","Wash clothes of without ioning",34.0,new Duration(34)),
               new Services("Pressing Clothes","Pressing Clothes Without Ironing",34.3,new Duration(34)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home",34.3,new Duration(333)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home",34.3,new Duration(333)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home",34.3,new Duration(333)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home Sweeping and Cleaning of "
                       + "HomeSweeping and Cleaning of HomeSweeping and Cleaning of Home",
                       34.3,new Duration(333)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home",34.3,new Duration(333)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home",34.3,new Duration(333)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home",34.3,new Duration(333)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home",34.3,new Duration(333)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home",34.3,new Duration(333)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home",34.3,new Duration(333)),
               new Services("Home Cleaning","Sweeping and Cleaning of Home",34.3,new Duration(333)));
  return servicesList;
     }
     public static void addServices(String name, String description,Double price,Duration dur){
         servicesList.add(new Services(name,description,price,dur));
     }
     public static ObservableList<Customer> getCustomers(){
         customersList=FXCollections.observableArrayList();
         customersList.addAll(
                      new Customer("John","34343434","first east lane, Westeros",null),
                      new Customer("Jon Stark","wt344r4","Castle Black, Night Watch",null));
         
         
         return customersList;
     }
     public static void addCustomers(String name,String num,String address){
         customersList.add(new Customer(name,num,address,null));
     }
}
