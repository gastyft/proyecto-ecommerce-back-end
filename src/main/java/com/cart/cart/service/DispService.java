
package com.cart.cart.service;

import com.cart.cart.model.Dispo;
import com.cart.cart.repository.DispRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Usuario
 */
@Service
public class DispService implements IDispService{
    @Autowired
    private DispRepository dispRepository;
    
@Override
 public List<Dispo> getDisp(){
    List<Dispo> listaDisp = dispRepository.findAll();
    return listaDisp;



}
    
     @Override
    public void saveDisp(Dispo disp){
    dispRepository.save(disp);
    
    }

    @Override
    public void deleteDisp(Long id){
    dispRepository.deleteById(id);
    
    }
    
    @Override
    public Dispo findDisp(Long id_pers){
       Dispo disp = dispRepository.findById(id_pers).orElse(null);
    return disp;
    
    }
}
