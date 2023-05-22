package com.andos.projet_produit_core.restcontrollers;

import com.andos.projet_produit_core.entites.Image;
import com.andos.projet_produit_core.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * <p></p>
 *
 * @author Anderson Ouattara 2023-05-20
 */
@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {

  @Autowired
  ImageService imageService;

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
    return imageService.uplaodImage(file);
  }

  @RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
  public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
    return imageService.getImageDetails(id);
  }

  @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
  public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
    return imageService.getImage(id);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public void deleteImage(@PathVariable("id") Long id) {
    imageService.deleteImage(id);
  }

  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public Image updateImage(@RequestParam("image") MultipartFile file) throws IOException {
    return imageService.uplaodImage(file);
  }
}
