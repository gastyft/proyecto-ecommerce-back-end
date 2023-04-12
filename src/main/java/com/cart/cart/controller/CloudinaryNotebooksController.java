
package com.cart.cart.controller;

import com.cart.cart.dto.MensajeNotebooks;
import com.cart.cart.model.ImagenNotebooks;
import com.cart.cart.service.CloudinaryNotebooksService;
import com.cart.cart.service.ImagenNotebooksService;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;




@RestController
@RequestMapping("/cloudinarynotebooks")
@CrossOrigin
public class CloudinaryNotebooksController {

    @Autowired
    CloudinaryNotebooksService cloudinaryService;

    @Autowired
    ImagenNotebooksService imagenService;

    @GetMapping("/list")
    public ResponseEntity<List<ImagenNotebooks>> list(){
        List<ImagenNotebooks> list = imagenService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            return new ResponseEntity(new MensajeNotebooks("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
        ImagenNotebooks imagen =
                new ImagenNotebooks((String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        imagenService.save(imagen);
        return new ResponseEntity(new MensajeNotebooks("imagen subida"), HttpStatus.OK);
    }

     @DeleteMapping("/delete/{id}")
            public ResponseEntity<?> delete(@PathVariable("id")int id) throws IOException{
                if(!imagenService.exists(id))
                    return new ResponseEntity(new MensajeNotebooks("no existe"), HttpStatus.NOT_FOUND);
                ImagenNotebooks imagen= imagenService.getOne(id).get();
                Map result= cloudinaryService.delete(imagen.getImagen_Id());
                imagenService.delete(id);
                return new ResponseEntity(new MensajeNotebooks("imagen eliminada"), HttpStatus.OK);
            }
         
            }
            
    
            
