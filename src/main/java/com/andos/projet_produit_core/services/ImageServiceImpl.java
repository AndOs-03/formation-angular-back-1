package com.andos.projet_produit_core.services;

import com.andos.projet_produit_core.entites.Image;
import com.andos.projet_produit_core.repos.ImageRepository;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p></p>
 *
 * @author Anderson Ouattara 2023-05-20
 */
@Service
public class ImageServiceImpl implements ImageService {

  @Autowired
  ImageRepository imageRepository;
  @Autowired
  ProduitService produitService;

  @Override
  public Image uplaodImage(MultipartFile file) throws IOException {
    return imageRepository.save(
        Image.builder()
            .name(file.getOriginalFilename())
            .type(file.getContentType())
            .image(file.getBytes())
            .build()
    );
  }

  @Override
  public Image getImageDetails(Long id) throws IOException {
    final Optional<Image> dbImage = imageRepository.findById(id);
    return Image.builder()
        .idImage(dbImage.get().getIdImage())
        .name(dbImage.get().getName())
        .type(dbImage.get().getType())
        .image(dbImage.get().getImage())
        .build();
  }

  @Override
  public ResponseEntity<byte[]> getImage(Long id) throws IOException {
    final Optional<Image> dbImage = imageRepository.findById(id);
    return ResponseEntity
        .ok()
        .contentType(MediaType.valueOf(dbImage.get().getType()))
        .body(dbImage.get().getImage());
  }

  @Override
  public void deleteImage(Long id) {
    imageRepository.deleteById(id);
  }
}
