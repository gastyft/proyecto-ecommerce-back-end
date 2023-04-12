
package com.cart.cart.repository;

import com.cart.cart.model.ImagenPhones;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ImagenPhonesRepository extends JpaRepository<ImagenPhones, Integer>{
    List<ImagenPhones> findByOrderById();
}