
package com.cart.cart.controller;

import com.cart.cart.model.Dispo;
import com.cart.cart.service.IDispService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController

@CrossOrigin(origins="https://localhost:8080/")
public class DispController {
    
    @Autowired
  private IDispService interDisp;
    @GetMapping("/dispo/getdispolist")
      public List <Dispo> getDisp(){
return interDisp.getDisp();
}
    
    
    @PostMapping("/dispo/crear")
    public String createDisp(@RequestBody Dispo disp){
    interDisp.saveDisp(disp);
    return "La persona fue guardada correctamente";
    }
    
    @DeleteMapping("/dispo/borrar/{id}")
    public String deleteDisp(@PathVariable Long id){
    
    interDisp.deleteDisp(id);
    return "El dispositivo fue eliminado correctamente";
            }
    

    @PutMapping("/dispo/editar/{id}") //puede ser con el ID "/personas/editar/{id}"
    public Dispo editDisp (@PathVariable Long id,
            @RequestParam ("nombre") String nuevoNombre,
            @RequestParam("decrip") String nuevaDescrip,
            @RequestParam("precio") int nuevoPrecio,
            @RequestParam("url") String nuevaUrl) {
    Dispo disp= interDisp.findDisp(id);
    
    
    disp.setNombre(nuevoNombre);
    disp.setDescrip(nuevaDescrip);
    disp.setPrecio(nuevoPrecio);
    disp.setUrl(nuevaUrl);
    interDisp.saveDisp(disp);
    
    return disp;
    
    
    }
    
    
  @GetMapping("/dispo/traer/{id}")
 
  public Dispo findDisp(@PathVariable Long id){ 
        return interDisp.findDisp(id);
           
    }
    
    
    
    }
