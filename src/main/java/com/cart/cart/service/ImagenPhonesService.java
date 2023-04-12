
package com.cart.cart.service;

import com.cart.cart.model.ImagenPhones;
import com.cart.cart.repository.ImagenPhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImagenPhonesService {

    @Autowired
    ImagenPhonesRepository imagenRepository;

    public List<ImagenPhones> list(){
        return imagenRepository.findByOrderById();
    }

    public Optional<ImagenPhones> getOne(int id){
        return imagenRepository.findById(id);
    }

    public void save(ImagenPhones imagen){
        imagenRepository.save(imagen);
    }

    public void delete(int id){
        imagenRepository.deleteById(id);
    }

    public boolean exists(int id){
        return imagenRepository.existsById(id);
    }
}
