
package com.cart.cart.repository;

import com.cart.cart.model.Dispo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Usuario
 */
@Repository
public interface DispRepository extends JpaRepository<Dispo, Long>{
    
}
