/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uibeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import repository.Car;
import repository.CarRepositoryBean;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 */
@Named(value = "carSelectionBean")
@SessionScoped
public class CarSelectionBean implements Serializable{

    
    // Inject the car repository
    // DO NOT REMOVE THE CODE
    @EJB CarRepositoryBean repository;
   
    /**
     * Action method to redirect to displayInfo facelets page.
     * @return target page name
     */
    
    public List<Car> getCars(){
        return repository.findAll();
    }
    
    private int carId;

    /**
     * Get the value of carId
     *
     * @return the value of carId
     */
    public int getCarId() {
        return carId;
    }

    /**
     * Set the value of carId
     *
     * @param carId new value of carId
     */
    public void setCarId(int carId) {
        this.carId = carId;
    }
    
    private String carName;

    /**
     * Get the value of carName
     *
     * @return the value of carName
     */
    public String getCarName() {
        return carName;
    }

    /**
     * Set the value of carName
     *
     * @param carName new value of carName
     */
    public void setCarName(String carName) {
        this.carName = carName;
    }

    private String facturer;

    /**
     * Get the value of facturer
     *
     * @return the value of facturer
     */
    public String getFacturer() {
        return facturer;
    }

    /**
     * Set the value of facturer
     *
     * @param facturer new value of facturer
     */
    public void setFacturer(String facturer) {
        this.facturer = facturer;
    }

    private String imgUrl;

    /**
     * Get the value of imgUrl
     *
     * @return the value of imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Set the value of imgUrl
     *
     * @param imgUrl new value of imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
  
    public String dispalyInfo(){
        System.out.println("do:");
        System.out.println(repository.query(carId));
        this.carName = repository.query(carId).getName();
        this.facturer = repository.query(carId).getManufacturer();
        this.imgUrl = repository.query(carId).getImg_uri();
        System.out.println(this.imgUrl);
        return "displayInfo?faces-redirect=true";
    }
    
    public void addCar(){
        Car newCar = new Car();
        newCar.setName(carName);
        newCar.setManufacturer(facturer);
        newCar.setImg_uri(imgUrl);
        repository.create(newCar);
    }
    
    public void updateCar(){
        repository.query(carId).setName(carName);
        repository.query(carId).setManufacturer(facturer);
        repository.query(carId).setImg_uri(imgUrl);
    }
    
    public void delectCar(){
        repository.delete(carId);
    }
    
}
