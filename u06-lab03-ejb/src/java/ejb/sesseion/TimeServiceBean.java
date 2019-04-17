/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sesseion;

import ejb.seesion.TimeService;
import java.util.Calendar;
import java.util.Formatter;
import javax.ejb.Stateless;

/**
 *
 * @author sunny
 */
@Stateless
public class TimeServiceBean implements TimeService {

    @Override
    public String getTime() {
        Formatter  fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt.format("%tr", cal);
        return fmt.toString();
    }
}
