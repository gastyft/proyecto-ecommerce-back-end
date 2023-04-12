
package com.cart.cart.repository;

import com.cart.cart.model.ImagenNotebooks;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImagenNotebooksRepository extends JpaRepository<ImagenNotebooks, Integer>{
    List<ImagenNotebooks> findByOrderById();
}