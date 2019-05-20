/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uibeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import repository.Car;
import repository.CarRepositoryBean;

/**
 *
 * @author sunny
 */
@Named(value = "carSelectBean")
@SessionScoped
public class CarSelectBean implements Serializable {

    /**
     * Creates a new instance of CarSelectBean
     */
    @EJB CarRepositoryBean repository;
    
    public List<Car> getCars(){
        return repository.findAll();
    }

    private String carID;

    /**
     * Get the value of carID
     *
     * @return the value of carID
     */
    public String getCarID() {
        return carID;
    }

    /**
     * Set the value of carID
     *
     * @param carID new value of carID
     */
    public void setCarID(String carID) {
        this.carID = carID;
    }

    private float price = 0;

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    private String pageID;

    /**
     * Get the value of pageID
     *
     * @return the value of pageID
     */
    public String getPageID() {
        return pageID;
    }

    /**
     * Set the value of pageID
     *
     * @param pageID new value of pageID
     */
    public void setPageID(String pageID) {
        this.pageID = pageID;
    }

    
    public CarSelectBean() {
        
    }

    public String editCarInfo(){
        System.out.println(carID);
        this.price = repository.query(Integer.parseInt(carID)).getPrice();
        return "editCarInfo";
    }
    
    public Car getInfo(){
        return repository.query(Integer.parseInt(carID));
    }
    
    public String page(){
        if (pageID == null){
            return "index";
        }
        if (pageID.equals("1")){
            return "cancel";
        }else if (pageID.equals("2")){
            Car newPrice = repository.query(Integer.parseInt(carID));
            newPrice.setPrice(this.getPrice());
            repository.update(Integer.parseInt(carID), newPrice);
            return "submit";
        }else {          
            return "home";       
      }     
    }
    
}
