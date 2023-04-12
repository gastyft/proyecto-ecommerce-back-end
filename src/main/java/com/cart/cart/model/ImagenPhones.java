
package com.cart.cart.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ImagenPhones {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String imagen_url;
    private String imagen_Id;

    public ImagenPhones() {
    }
        public ImagenPhones(String name, String imagen_url, String imagen_Id) {
        this.name = name;
        this.imagen_url = imagen_url;
        this.imagen_Id = imagen_Id;
    }


}
