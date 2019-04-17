/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author sunny
 */
@Named(value = "getPic")
@SessionScoped
public class GetPic implements Serializable{

    
    private String pageID="1";

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

    
    public GetPic() {
    }
    public String page(){
        if (pageID == null){
            return "index";
        }
        if (pageID.equals("1")){
            return "page1";
        }else if (pageID.equals("2")){
            return "page2";
        }else if (pageID.equals("3")){
            return "page3";
        }else {          
         return "home";       
      }     
    }
    
}
