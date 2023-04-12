
package com.cart.cart.controller;
import com.cart.cart.dto.MensajePhones;
import com.cart.cart.model.ImagenPhones;
import com.cart.cart.service.CloudinaryPhonesService;
import com.cart.cart.service.ImagenPhonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudinaryphones")
@CrossOrigin
public class CloudinaryPhonesController {

    @Autowired
    CloudinaryPhonesService cloudinaryService;

    @Autowired
    ImagenPhonesService imagenService;

    @GetMapping("/list")
    public ResponseEntity<List<ImagenPhones>> list(){
        List<ImagenPhones> list = imagenService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            return new ResponseEntity(new MensajePhones("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        ImagenPhones imagen =
                new ImagenPhones((String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        imagenService.save(imagen);
        return new ResponseEntity(new MensajePhones("imagen subida"), HttpStatus.OK);
    }

     @DeleteMapping("/delete/{id}")
            public ResponseEntity<?> delete(@PathVariable("id")int id) throws IOException{
                if(!imagenService.exists(id))
                    return new ResponseEntity(new MensajePhones("no existe"), HttpStatus.NOT_FOUND);
                ImagenPhones imagen= imagenService.getOne(id).get();
                Map result= cloudinaryService.delete(imagen.getImagen_Id());
                imagenService.delete(id);
                return new ResponseEntity(new MensajePhones("imagen eliminada"), HttpStatus.OK);
            }
         
            }
            
    
            