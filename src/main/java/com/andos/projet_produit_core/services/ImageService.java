package com.andos.projet_produit_core.services;

import com.andos.projet_produit_core.entites.Image;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p></p>
 *
 * @author Anderson Ouattara 2023-05-20
 */
public interface ImageService {

  Image uplaodImage(MultipartFile file) throws IOException;

  Image getImageDetails(Long id) throws IOException;

  ResponseEntity<byte[]> getImage(Long id) throws IOException;

  void deleteImage(Long id);
}
