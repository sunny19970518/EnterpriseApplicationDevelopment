/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibaeans;

import ejb.TimeServiceEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author sunny
 */
@Named(value = "timeServiceCB")
@RequestScoped
public class TimeServiceCB {

    /**
     * Creates a new instance of TimeServiceCB
     */
    
    @EJB
    TimeServiceEJB timeServiceEJB;
    public TimeServiceCB() {
    }
    public String getCurrentTime(){
        return timeServiceEJB.getTime();
    }
    
}
