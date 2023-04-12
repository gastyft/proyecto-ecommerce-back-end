
package com.cart.cart.service;


import com.cart.cart.model.ImagenNotebooks;
import com.cart.cart.repository.ImagenNotebooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImagenNotebooksService {

    @Autowired
    ImagenNotebooksRepository imagenRepository;

    public List<ImagenNotebooks> list(){
        return imagenRepository.findByOrderById();
    }

    public Optional<ImagenNotebooks> getOne(int id){
        return imagenRepository.findById(id);
    }

    public void save(ImagenNotebooks imagen){
        imagenRepository.save(imagen);
    }

    public void delete(int id){
        imagenRepository.deleteById(id);
    }

    public boolean exists(int id){
        return imagenRepository.existsById(id);
    }
}
