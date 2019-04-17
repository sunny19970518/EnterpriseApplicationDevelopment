/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import ejb.seesion.TimeService;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author sunny
 */
@Named(value = "timeServiceBean")
@RequestScoped
public class TimeServiceBean {

    /**
     * Creates a new instance of TimeServiceBean
     */
    @EJB
    TimeService timeService;
    public TimeServiceBean() {
    }
    
    public String getCurrentTime(){
        return timeService.getTime();
    }
    
}
