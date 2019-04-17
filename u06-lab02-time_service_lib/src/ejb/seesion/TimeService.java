/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.seesion;

import javax.ejb.Remote;

/**
 *
 * @author sunny
 */
@Remote
public interface TimeService {
    public String getTime();
}
