/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import ejb3.seesion.TimeService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author sunny
 */
@Named(value = "timeServiceClientBean")
@RequestScoped
public class TimeServiceClientBean {

    /**
     * Creates a new instance of TimeServiceClientBean
     */
    @EJB
    TimeService timeService;
    public TimeServiceClientBean() {
    }
    
    public String getCurrentTime(){
        System.out.println(timeService.getClass());
        return timeService.getTime();
    }
    
}
