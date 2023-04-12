
package com.cart.cart.service;

import com.cart.cart.model.Dispo;
import java.util.List;


/**
 *
 * @author Usuario
 */
public interface IDispService {
      
    public List <Dispo>  getDisp();

    public void saveDisp (Dispo disp);
    
    public void deleteDisp (Long id);
    
    public Dispo findDisp (Long id);
}
